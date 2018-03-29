package de.frena.holidayreplacement.service;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.frena.holidayreplacement.dto.MyTaskDto;

@Service
public class UserTaskManager {

	@Autowired
	private TaskService taskService;

	public void setCandidateUser(String userId, String taskId) {
		taskService.addCandidateUser(taskId, userId);
	}

	public List<MyTaskDto> getCandidateTasksForUser(String userId) {
		List<Task> list = taskService.createTaskQuery().taskCandidateUser(userId).list();

		List<MyTaskDto> dtoList = createTaskList(list);

		return dtoList;
	}

	public List<MyTaskDto> getCandidateTasksForGroup(String group) {
		List<Task> list = taskService.createTaskQuery().taskCandidateGroup(group).list();

		List<MyTaskDto> dtoList = createTaskList(list);

		return dtoList;
	}

	private List<MyTaskDto> createTaskList(List<Task> list) {
		List<MyTaskDto> dtoList = new ArrayList<>();

		for (Task task : list) {
			MyTaskDto dto = new MyTaskDto();
			dto.setTaskId(task.getId());
			dto.setTaskName(task.getName());
			dtoList.add(dto);
		}
		return dtoList;
	}
}
