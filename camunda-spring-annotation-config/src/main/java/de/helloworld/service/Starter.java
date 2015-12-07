package de.helloworld.service;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Starter {

  @Autowired
  private RuntimeService runtimeService;

  public void start(String processId) {
    System.out.println("starting process for id " + processId);
    runtimeService.startProcessInstanceByKey(processId);
  }

}
