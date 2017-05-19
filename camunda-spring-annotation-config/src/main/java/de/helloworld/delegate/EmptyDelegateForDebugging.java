package de.helloworld.delegate;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.helloworld.dto.PersonDto;



@Service
public class EmptyDelegateForDebugging implements JavaDelegate {

	@Autowired
	private ManagementService managementService;
	@Autowired
	private RuntimeService runtimeService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("EmptyDelegateForDebugging");
		

	}

}
