package de.frena.holidayreplacement.service;

import org.springframework.stereotype.Service;

@Service
public class NameGeneratorService {

	
	private static final String DIVIDER = "_";

	public String groupName(String userId, String role) {
		return userId + DIVIDER + role;
	}
	public String origAssigneeFromGroupName(String groupName) {
		String originalAssignee = groupName.substring(0, groupName.indexOf(DIVIDER));
		return originalAssignee;
	}

}
