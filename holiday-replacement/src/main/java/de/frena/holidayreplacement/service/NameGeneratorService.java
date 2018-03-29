package de.frena.holidayreplacement.service;

import org.springframework.stereotype.Service;

@Service
public class NameGeneratorService {

	public String groupName(String userId, String role) {
		return "group_" + userId + "_" + role;
	}

}
