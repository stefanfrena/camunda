package de.frena.holidayreplacement.delegate;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.frena.holidayreplacement.dto.MyTaskDto;
import de.frena.holidayreplacement.service.UserTaskManager;

@Component
public class DeleteGroupsAndUsersIfNotNeeded implements JavaDelegate {

	@Autowired
	private UserTaskManager userTaskManager;

	@Autowired
	private IdentityService identityService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		String groupId = (String) execution.getVariable("candidateGroup_Coordinator");

		List<User> userList = identityService.createUserQuery().memberOfGroup(groupId).list();
		for (User user : userList) {
			List<MyTaskDto> list = userTaskManager.getCandidateTasksForUser(user.getId());
			if (list.size() == 0) {
				identityService.deleteUser(user.getId());
			}
		}

		List<MyTaskDto> list = userTaskManager.getCandidateTasksForGroup(groupId);
		if (list.size() == 0) {
			identityService.deleteGroup(groupId);
		}

	}

}
