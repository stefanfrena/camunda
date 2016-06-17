package de.helloworld.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Starter {

  @Autowired
  private RuntimeService runtimeService;
  
  @Autowired
  private ProcessEngine processEngine;

  public String start(String processId) {
    System.out.println("starting process for id " + processId);
    String randomBusinessKey = createBusinessKey();
	runtimeService.startProcessInstanceByKey(processId,randomBusinessKey);
	return randomBusinessKey;
  }

  public String startVersion(String processId, Integer version) {
	  System.out.println("starting process for id " + processId +" in Version "+version);
	  String randomBusinessKey = createBusinessKey();
	  
	  ProcessDefinition pd = processEngine.getRepositoryService().createProcessDefinitionQuery()
			    .processDefinitionKey(processId)
			    .processDefinitionVersion(version).singleResult();
			processEngine.getRuntimeService().startProcessInstanceById(pd.getId(), randomBusinessKey);
	  
	  runtimeService.startProcessInstanceByKey(processId,randomBusinessKey);
	  return randomBusinessKey;
  }

private String createBusinessKey() {
	Double rand = Math.random() * 1000;
	String businessKey = rand.toString().substring(0, 3);
	
	return businessKey;
}

}
