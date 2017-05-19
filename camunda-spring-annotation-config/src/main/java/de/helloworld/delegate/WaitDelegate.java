package de.helloworld.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import de.helloworld.dto.PersonDto;

@Service
public class WaitDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Integer count = (Integer) execution.getVariable("count");
		if (null == count){
			count = 1;
		}
		System.out.println("waiting in task "+count);
		execution.setVariable("count", count +1);
		Thread.sleep(15000);

	}

}
