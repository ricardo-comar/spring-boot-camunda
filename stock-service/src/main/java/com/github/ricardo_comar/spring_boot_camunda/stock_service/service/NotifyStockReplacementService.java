package com.github.ricardo_comar.spring_boot_camunda.stock_service.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * NotifyStockReplacement
 */
@Component
public class NotifyStockReplacementService implements JavaDelegate {

  private static final Logger LOGGER = LoggerFactory.getLogger(NotifyStockReplacementService.class);

  @Override
  public void execute(DelegateExecution execution) throws Exception {

      LOGGER.info("Execution: " + execution);
  }
}
