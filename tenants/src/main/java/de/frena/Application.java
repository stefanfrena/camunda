package de.frena;

import java.util.List;

import javax.annotation.PostConstruct;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
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
  private void init(){
      runtimeService.createProcessInstanceByKey("tenants-process").setVariable("tenantId", "stefan").execute();

      List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().tenantIdIn("stefan").list();
      System.out.println(list.size());
      
    
  }

}