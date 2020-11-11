package com.github.ricardocomar.springbootcamunda.appgateway.usecase;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.CamundaGateway;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import com.github.ricardocomar.springbootcamunda.appgateway.model.StockReplace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockReplaceUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockReplaceUseCase.class);

    @Autowired
    private CamundaGateway camundaGateway;

    public StockReplace sendStockReplace(StockReplace stockReplace) {

        Process process = camundaGateway.sendStockReplace(stockReplace);
        LOGGER.info("Stock Replacement published with process id \"{}\"", process.getProcessId());

        return stockReplace.withProcess(process);
    }
}
