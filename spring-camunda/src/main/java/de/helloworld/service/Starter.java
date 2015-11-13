package de.helloworld.service;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Starter {

  private static final String PROCESS_INSTANCE_KEY = "do-nothing";

  @Autowired
  private RuntimeService runtimeService;

  public void start(String name) {
    System.out.println("starting process for name " + name);
    runtimeService.startProcessInstanceByKey(PROCESS_INSTANCE_KEY);
  }

}
