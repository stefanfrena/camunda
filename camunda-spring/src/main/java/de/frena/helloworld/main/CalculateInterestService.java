package de.frena.helloworld.main;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class CalculateInterestService implements JavaDelegate {

  public void execute(DelegateExecution delegate) throws Exception {

    System.out.println("Service started - Delegate started");

  }

}
