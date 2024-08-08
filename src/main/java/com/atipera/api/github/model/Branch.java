package com.atipera.api.github.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

	private String name;
	private Commit commit;

	@Data
	public static class Commit {
		private String sha;
	}

}
