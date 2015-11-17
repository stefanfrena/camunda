package de.helloworld.configuration;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.ProcessEngineService;
import org.camunda.bpm.engine.AuthorizationService;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * configuration for the camunda powered workflow engine
 * 
 *
 */
@Configuration
public class CamundaConfig {

  /**
   * the shared process engine service configured in the container
   * 
   * @return
   */
  @Bean
  public ProcessEngineService processEngineService() {
    return BpmPlatform.getProcessEngineService();
  }

  // /**
  // * bootstrap the spring powered process application
  // *
  // * @return
  // */
  // @Bean
  // public SpringServletProcessApplication processApplication() {
  // SpringServletProcessApplication application = new SwopProcessApplication();
  // return application;
  // }

  /**
   * the process engine
   * 
   * @return
   * @throws Exception
   */
  // keep the destroy method as toString. the spring container wraps the process engine by
  // DisposableBeanAdapter to provide cleanup logic. if no destroy method is proved by the bean,
  // spring infers the destroy method see DisposableBeanAdapter.inferDestroyMethodIfNecessary
  // pointing to DisposableBeanAdapter.CLOSE_METHOD_NAME == close. the close method on
  // ProcessEngineImpl unregisters and destroys the shared engine. :(
  @Bean(destroyMethod = "toString")
  public ProcessEngine processEngine() throws Exception {
    return processEngineService().getDefaultProcessEngine();
  }

  /**
   * the repository service
   * 
   * @return
   * @throws Exception
   */
  @Bean
  public RepositoryService repositoryService() throws Exception {
    return processEngine().getRepositoryService();
  }

  /**
   * the runtime service
   * 
   * @return
   * @throws Exception
   */
  @Bean
  public RuntimeService runtimeService() throws Exception {
    return processEngine().getRuntimeService();
  }

  /**
   * the task service
   * 
   * @return
   * @throws Exception
   */
  @Bean
  public TaskService taskService() throws Exception {
    return processEngine().getTaskService();
  }

  /**
   * the history service
   * 
   * @return
   * @throws Exception
   */
  @Bean
  public HistoryService historyService() throws Exception {
    return processEngine().getHistoryService();
  }

  /**
   * the management service
   * 
   * @return
   * @throws Exception
   */
  @Bean
  public ManagementService managementService() throws Exception {
    return processEngine().getManagementService();
  }

  /**
   * the identity service
   * 
   * @return
   * @throws Exception
   */
  @Bean
  public IdentityService identityService() throws Exception {
    return processEngine().getIdentityService();
  }

  @Bean
  public AuthorizationService authorizationService() throws Exception {
    return processEngine().getAuthorizationService();
  }
}
