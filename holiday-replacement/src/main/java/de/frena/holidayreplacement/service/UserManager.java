package de.frena.holidayreplacement.service;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

	@Autowired
	private IdentityService identityService;

	public void createGroupIfNotExists(String groupName) {

		List<Group> groups = identityService.createGroupQuery().groupId(groupName).list();
		if (groups.size() == 0) {
			Group newGroup = identityService.newGroup(groupName);
			identityService.saveGroup(newGroup);
		}

	}

	public void createUserIfNotExists(String userId) {
		List<User> list = identityService.createUserQuery().userId(userId).list();
		if (list.size() == 0) {
			User newUser = identityService.newUser(userId);
			identityService.saveUser(newUser);
		}

	}

	public void createMembershipIfNotExists(String userId, String groupName) {
		List<Group> list = identityService.createGroupQuery().groupId(groupName).groupMember(userId).list();
		if (list.size() == 0) {
			identityService.createMembership(userId, groupName);
		}

	}

}
