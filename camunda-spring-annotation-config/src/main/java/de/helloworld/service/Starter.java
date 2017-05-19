package de.helloworld.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.helloworld.dto.HelloWorldDto;

@Service
public class Starter {

  @Autowired
  private RuntimeService runtimeService;
  
  @Autowired
  private ProcessEngine processEngine;

  public String start(HelloWorldDto dto) {
    System.out.println("starting process for id " + dto.getName());
    String randomBusinessKey = createBusinessKey();
    
    if(null == dto.getVersion()){
    	runtimeService.startProcessInstanceByKey(dto.getName(),randomBusinessKey);
    }
    else{
    	 ProcessDefinition pd = processEngine.getRepositoryService().createProcessDefinitionQuery()
 			    .processDefinitionKey(dto.getName())
 			    .processDefinitionVersion(dto.getVersion()).singleResult();
 			processEngine.getRuntimeService().startProcessInstanceById(pd.getId(), randomBusinessKey);
    }
	return randomBusinessKey;
  }


private String createBusinessKey() {
	Double rand = Math.random() * 1000;
	String businessKey = rand.toString().substring(0, 3);
	
	return businessKey;
}

}
