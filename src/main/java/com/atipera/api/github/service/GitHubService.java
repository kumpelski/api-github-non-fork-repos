package com.atipera.api.github.service;

import com.atipera.api.github.exception.UserNotFoundException;
import com.atipera.api.github.model.Branch;
import com.atipera.api.github.model.Repo;
import com.atipera.api.github.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GITHUB_API_URL = "https://api.github.com/users/";

	public List<Response> getRepositories(String username) {
		try {
			// get repo data
			String repos_url = GITHUB_API_URL + username + "/repos";
			Repo[] repositories = restTemplate.getForObject(repos_url, Repo[].class);
			if (repositories == null)
				throw new UserNotFoundException();

			return Arrays
					.stream(repositories)
					.filter(repo -> !repo.isFork()) // filter if fork
					.peek(repo -> { // get and add branch data
						String branches_url = repo.getBranchesUrl().replace("{/branch}", "");
						Branch[] branches = restTemplate.getForObject(branches_url, Branch[].class);
						if (branches != null)
							repo.setBranches(Arrays.asList(branches));
					})
					.map(repo -> { // map to response format
						Response response = new Response();
						response.setName(repo.getName());
						response.setOwner(repo.getOwner());
						response.setBranches(repo.getBranches());
						return response;
					})
					.collect(Collectors.toList());

		} catch (HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException();
		}
	}
}
