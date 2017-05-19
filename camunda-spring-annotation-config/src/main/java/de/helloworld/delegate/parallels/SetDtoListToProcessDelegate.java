package de.helloworld.delegate.parallels;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import de.helloworld.dto.PersonDto;

@Service
public class SetDtoListToProcessDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		List<PersonDto> list = new ArrayList<PersonDto>();
		list.add(create("Peter", "Meier"));
		list.add(create("Stefan", "Huber"));
		list.add(create("John", "Doe"));
		
		execution.setVariable("personList", list);
		
		List<String> errorList = new ArrayList<String>();
		execution.setVariable("errorList", errorList);
		
		
	}

	private PersonDto create(String first, String last) {
		return new PersonDto(first, last);
	}

}
