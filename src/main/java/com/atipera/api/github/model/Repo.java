package com.atipera.api.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repo {

	private String name;

	private boolean fork;

	@JsonProperty("branches_url")
	private String branchesUrl;

	private Owner owner;

	private List<Branch> branches;

}
