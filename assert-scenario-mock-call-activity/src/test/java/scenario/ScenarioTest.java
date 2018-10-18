package scenario;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.consulting.process_test_coverage.ProcessTestCoverage;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.scenario.ProcessScenario;
import org.camunda.bpm.scenario.Scenario;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@Deployment(resources = "bpmn/process.bpmn")

public class ScenarioTest {

  @Rule
  public ProcessEngineRule rule = new ProcessEngineRule();
  @Mock
  private ProcessScenario process;

  private List<org.camunda.bpm.engine.repository.Deployment> deployedDummies = new ArrayList<>();

  @Before
  public void setupDefaultScenario() {
    MockitoAnnotations.initMocks(this);
  }


  @Test
  public void testParsingAndDeployment() {
    // nothing is done here, as we just want to check for exceptions during
    // deployment
  }

  @Test
  public void testHappyPath() {
    deployMockedSubProcess("approve");
    Scenario scenario = Scenario.run(process).startByKey("process").execute();
    ProcessEngineAssertions.assertThat(scenario.instance(process)).hasPassed("EndEvent");
  }

  @Test
  public void testHappyPath_rejection() {
    deployMockedSubProcess("reject");
    Scenario scenario = Scenario.run(process).startByKey("process").execute();
    ProcessEngineAssertions.assertThat(scenario.instance(process)).hasPassed("EndEvent_Rejected");
  }

  private void deployMockedSubProcess(String value) {
    BpmnModelInstance modelInstance = Bpmn.createExecutableProcess() //
        .id("thesubprocess") //
        .startEvent() //
        .serviceTask().camundaResultVariable("result").camundaExpression(value) //
        .endEvent() //
        .done();

    org.camunda.bpm.engine.repository.Deployment deployment =
        rule.getProcessEngine().getRepositoryService().createDeployment()
            .addModelInstance("thesubprocess" + ".bpmn", modelInstance).deploy();

    deployedDummies.add(deployment);
  }

  @After
  public void calculateCoverage() throws Exception {
    for (org.camunda.bpm.engine.repository.Deployment deployment : deployedDummies) {
      rule.getProcessEngine().getRepositoryService().deleteDeployment(deployment.getId());
    }
    deployedDummies.clear();

    // calculate coverage for all tests
    ProcessTestCoverage.calculate(rule.getProcessEngine());
  }
}
