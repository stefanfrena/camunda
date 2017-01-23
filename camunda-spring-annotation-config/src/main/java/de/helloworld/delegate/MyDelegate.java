package de.helloworld.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import de.helloworld.dto.PersonDto;

@Service
public class MyDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String key = (null == execution.getBusinessKey()) ? "<none>" : execution.getBusinessKey();

		System.out.println("delegate called from process with businessId " + key);
		
		PersonDto person = (PersonDto) execution.getVariable("person");
		
		execution.setVariable("lastname", person.getLastName());

	}

}
