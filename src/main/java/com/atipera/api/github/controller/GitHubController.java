package com.atipera.api.github.controller;

import com.atipera.api.github.exception.UserNotFoundException;
import com.atipera.api.github.model.ErrorResponse;
import com.atipera.api.github.model.Repo;
import com.atipera.api.github.model.Response;
import com.atipera.api.github.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GitHubController {

	@Autowired
	private GitHubService gitHubService;

	@GetMapping("/non-fork-repos/{username}")
	public ResponseEntity<?> getRepositories(@PathVariable String username) {
		try {
			List<Response> repositories = gitHubService.getRepositories(username);
			return new ResponseEntity<>(repositories, HttpStatus.OK);
		} catch (UserNotFoundException e) {
			ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
			return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		}
	}

}
