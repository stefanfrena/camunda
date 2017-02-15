package de.helloworld.delegate;

import java.util.List;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.management.JobDefinition;
import org.camunda.bpm.engine.management.UpdateJobSuspensionStateSelectBuilder;
import org.camunda.bpm.engine.runtime.Job;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.model.dmn.instance.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitTimerDelegate implements JavaDelegate {

	@Autowired
	private ManagementService managementService;
	@Autowired
	private RuntimeService runtimeService;

	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.print("deleting timer job...");
		deleteTimerJob("followUpReminder_Timer");
		System.out.println("done");
	}

	private void deleteTimerJob(String alarmName) {
		JobDefinition jobDefinition = managementService.createJobDefinitionQuery().activityIdIn(alarmName)
				.singleResult();
		
		Job job = managementService.createJobQuery().jobDefinitionId(jobDefinition.getId()).singleResult();
		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
		
		if (null != job) {
			managementService.deleteJob(job.getId());
			
		}
	}

}
