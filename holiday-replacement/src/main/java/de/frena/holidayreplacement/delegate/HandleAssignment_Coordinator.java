package de.frena.holidayreplacement.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.frena.holidayreplacement.service.NameGeneratorService;
import de.frena.holidayreplacement.service.UserManager;

@Service
public class HandleAssignment_Coordinator implements JavaDelegate {

	@Autowired
	private UserManager userManager;

	@Autowired
	private NameGeneratorService groupNameService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String userId = (String) execution.getVariable("userId");
		userManager.createUserIfNotExists(userId);

		String groupName = groupNameService.groupName(userId, "coordinator");
		userManager.createGroupIfNotExists(groupName);
		userManager.createMembershipIfNotExists(userId, groupName);

		execution.setVariable("candidateGroup_Coordinator", groupName);
	}

}
