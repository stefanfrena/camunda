package de.helloworld.delegate;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.helloworld.dto.PersonDto;

@Service
public class ErrorThrowingDelegate implements JavaDelegate {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private ManagementService managementService;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		errorMethod();
		
		try {
			
			errorMethod();
			
		} catch (Exception e) {
			execution.setVariable("exceptionVar", "this is the error that happened in delegate ["+ e.getMessage()+"]");
			
			
		}
		

	}

	private void errorMethod() throws Exception {
		throw new Exception("error message");
		
	}

}
