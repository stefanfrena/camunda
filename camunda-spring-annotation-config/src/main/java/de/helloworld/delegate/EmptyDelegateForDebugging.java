package de.helloworld.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import de.helloworld.dto.PersonDto;

@Service
public class EmptyDelegateForDebugging implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("EmptyDelegateForDebugging");

	}

}
