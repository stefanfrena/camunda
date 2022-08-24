package de.frena;

import javax.annotation.PostConstruct;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.impl.persistence.entity.ExternalTaskEntity;
import org.camunda.bpm.engine.impl.persistence.entity.ExternalTaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  @Autowired
  private RuntimeService runtimeService;
  
  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @PostConstruct
  private void init() {
    // runtimeService
    //     .createProcessInstanceByKey("icp-process")
    //     .setVariable("dataset", "ICP")
    //     .execute();

  }

}