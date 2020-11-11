package com.github.ricardocomar.springbootcamunda.appgateway.entrypoint;

import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.StockRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.mapper.StockReplaceMapper;
import com.github.ricardocomar.springbootcamunda.appgateway.model.StockReplace;
import com.github.ricardocomar.springbootcamunda.appgateway.usecase.StockReplaceUseCase;
import com.github.ricardocomar.springbootcamunda.appgateway.validator.OrderValidationException;
import com.github.ricardocomar.springbootcamunda.appgateway.validator.StockRequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;
import lombok.AllArgsConstructor;

/**
 * PublishController
 */
@RestController
@AllArgsConstructor
public class StockController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

    @Autowired
    private StockRequestValidator validator;

    @Autowired
    private StockReplaceMapper mapper;

    @Autowired
    private StockReplaceUseCase stockReplace;

    @PostMapping(path = "/stock/replace")
    public ResponseEntity<?> stockReplace(@RequestBody(required = true) final StockRequest body) {

        LOGGER.info("Stock replacement received with SKU {}", body.getSku());

        ValidationResult validation = validator.validate(body);
        if (!validation.isValid()) {
            throw ValidationException.create(OrderValidationException.class, validation);
        }

        StockReplace replacement = mapper.fromRequest(body);
        StockReplace replacementSaved = stockReplace.sendStockReplace(replacement);

        return ResponseEntity.status(HttpStatus.CREATED).body(replacementSaved);
    }
}