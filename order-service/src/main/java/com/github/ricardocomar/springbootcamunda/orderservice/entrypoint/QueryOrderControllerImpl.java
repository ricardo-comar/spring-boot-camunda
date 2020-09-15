package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.mapper.OrderMapper;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderResponse;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import com.github.ricardocomar.springbootcamunda.orderservice.usecase.QueryOrderUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

/**
 * PublishController
 */
@RestController
@AllArgsConstructor
public class QueryOrderControllerImpl implements QueryOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryOrderControllerImpl.class);

    @Autowired
    private QueryOrderUseCase queryOrder;

    @Autowired
    private OrderMapper mapper;

    @Override
    public ResponseEntity<QueryOrderResponse> queryOrder(String orderId) {
        LOGGER.info("OrderId received for query {}", orderId);

        Optional<Order> opOrder = queryOrder.queryOrder(orderId);

        if (opOrder.isPresent()) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.fromQuery(opOrder.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 

    }
}
