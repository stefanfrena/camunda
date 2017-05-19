package assertscenario;

import static org.assertj.core.api.Assertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.withVariables;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.camunda.bpm.consulting.process_test_coverage.ProcessTestCoverage;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.scenario.ProcessScenario;
import org.camunda.bpm.scenario.Scenario;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import delegate.DelegateToMock;


public class AssertScenarioTest {

	@Rule
	public ProcessEngineRule rule = new ProcessEngineRule();

	private Map<String, Object> variables;
	private ProcessScenario process;
	private Scenario scenario;

	 @Mock
	 private DelegateToMock delegateToMock;
	 
	@Before
	public void setUp() {
		Mocks.register("delegateToMock", delegateToMock);
		process = Mockito.mock(ProcessScenario.class);
		variables = Variables.createVariables().putValue("variable", "");
		
	}

	@Deployment(resources = "bpmn/assert-scenario.bpmn")
	@Test
	public void testParsingAndDeployment() {
		
	}
	
	@Deployment(resources = "bpmn/assert-scenario.bpmn")
	@Test
	public void testManualPath_approve() {
		//given
		variables = Variables.createVariables().putValue("variable", "manual");
		
		// when
		
		when(process.waitsAtUserTask(Mockito.anyString())).thenReturn((task) -> task.complete());
		
		when(process.waitsAtUserTask("UserTaskDecide")).thenReturn((task) -> {
			task.complete(withVariables("approved", true));
		});
		
		scenario = Scenario.run(process).startByKey("camunda-bpm-scenario-testing", variables).execute();
		
		// then
		Mockito.verify(process).hasFinished("EndEventProcessApproved");
		
		ProcessTestCoverage.calculate(scenario.instance(process), rule.getProcessEngine());
	
	}

	@Deployment(resources = "bpmn/assert-scenario.bpmn")
	@Test
	public void testManualPath_dont_approve() {
		//given
		variables = Variables.createVariables().putValue("variable", "manual");
		
		// when
		when(process.waitsAtUserTask(Mockito.anyString())).thenReturn((task) -> task.complete());
		
		when(process.waitsAtUserTask("UserTaskDecide")).thenReturn((task) -> {
			task.complete(withVariables("approved", false));
		});
//		when(process.waitsAtServiceTask("Delegate_Task")).thenReturn((task) -> {
//			task.complete(withVariables("blub", "bla"));
//		});

		scenario = Scenario.run(process).startByKey("camunda-bpm-scenario-testing", variables).execute();
				
		// then
		Mockito.verify(process).hasFinished("EndEventProcessNotApproved");
		ProcessTestCoverage.calculate(scenario.instance(process), rule.getProcessEngine());
		
	}

	@Deployment(resources = "bpmn/assert-scenario.bpmn")
	@Test
	public void testNonManualPath() {
		// when
		when(process.waitsAtReceiveTask("ReceiveTask")).thenReturn((receiveTask) -> {
			assertThat(receiveTask.getEventName()).isEqualTo("testMessage");
			receiveTask.receive();
		});
		scenario = Scenario.run(process).startByKey("camunda-bpm-scenario-testing", variables).execute();

		// then
		Mockito.verify(process).hasFinished("EndEventProcessNonManEnd");
		
		ProcessTestCoverage.calculate(scenario.instance(process), rule.getProcessEngine());
	}

	@Deployment(resources = "bpmn/assert-scenario.bpmn")
	@Test
	public void testNonManualPath_fireBoundaryEvent_timer() {
		// when
		
		when(process.waitsAtReceiveTask("ReceiveTask")).thenReturn((receiveTask) -> {
			assertThat(receiveTask.getEventName()).isNotEqualTo("interruptMessage");
			receiveTask.defer("P1DT2M", receiveTask::receive);
		});
		scenario = Scenario.run(process).startByKey("camunda-bpm-scenario-testing", variables).execute();
		
		// then
		Mockito.verify(process).hasFinished("EndEventProcessNonManEnd");
		
		ProcessTestCoverage.calculate(scenario.instance(process), rule.getProcessEngine());
	}


}
