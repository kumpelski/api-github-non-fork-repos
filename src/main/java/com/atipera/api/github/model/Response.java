package com.atipera.api.github.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	private String name;

	private Owner owner;

	private List<Branch> branches;

}
