package de.helloworld.delegate.spin;

import static org.camunda.spin.Spin.JSON;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.stereotype.Service;

import de.helloworld.dto.PersonDto;

@Service
public class PersonDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String personString = (String) execution.getVariable("person");

		if(null == personString){
			personString = "{\"firstName\":\"james\",\"lastName\":\"last\"}";
		}
		
		SpinJsonNode json = JSON(personString);
		PersonDto personDto = json.mapTo(PersonDto.class);
		
		System.out.println(personDto.toString());
		
	}

}
