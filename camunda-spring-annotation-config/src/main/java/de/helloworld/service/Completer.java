package de.helloworld.service;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Completer {

  @Autowired
  private TaskService taskService;

  public void complete(String taskDefKey, String businessKey) {
    Task task = taskService.createTaskQuery().processInstanceBusinessKey(businessKey).taskDefinitionKey(taskDefKey).singleResult();
    taskService.complete(task.getId());
  }

}
