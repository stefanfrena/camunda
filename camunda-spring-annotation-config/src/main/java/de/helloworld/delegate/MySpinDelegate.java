package de.helloworld.delegate;

import static org.camunda.spin.Spin.JSON;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.SpinList;
import org.camunda.spin.json.SpinJsonDataFormatException;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.stereotype.Service;

@Service
public class MySpinDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) {
		System.out.print("called spin delegate: ");
		String returnString = null;
		String customerName = null;
		
		String jsonArrayString = (String) execution.getVariable("jsonArray");
		String jsonString = (String) execution.getVariable("json");
		
		if(null == jsonString){
			jsonString = "{\"customer\": \"Kermit\"}";
		}
		if(null == jsonArrayString){
			jsonArrayString = "{\"customer\": [\"Geraldo\", \"Waldo\"]}";
		}
			
		
		try{
			//simple
			SpinJsonNode json = JSON(jsonString);
			SpinJsonNode customerProperty = json.prop("customer");
			returnString = customerProperty.stringValue();
			
			//array
			SpinJsonNode jsonArray = JSON(jsonArrayString);
			SpinJsonNode customerArrayProperty = jsonArray.prop("customer");
			SpinList<SpinJsonNode> customers = customerArrayProperty.elements();
			SpinJsonNode customer = customers.get(0);
			customerName = customer.stringValue();
			returnString = returnString + " " +customerName;
			
		}catch(SpinJsonDataFormatException e){
			returnString = "invalid JSON!";
		}
		System.out.println(returnString);
		
	}

}
