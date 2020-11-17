package com.github.ricardocomar.springbootcamunda.orderservice.gateway.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.util.UUID;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.BankSlipEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.CreditCardEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderStateEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository repo;

    @Test
    public void testSaveCreditCard() {

        OrderEntity order = new OrderEntity();
        order.setCustomer("John Snow");
        order.setOrderId(UUID.randomUUID().toString());
        order.setState(OrderStateEnum.CREATED);
        order.setValue(123.0);

        CreditCardEntity card = new CreditCardEntity();
        card.setCcv("123");
        card.setExpirity(LocalDate.now().plusYears(1));
        card.setName("JOHN SNOW");
        card.setOrder(order);
        card.setValue(123.0);
        order.setCreditCard(card);

        OrderEntity savedOrder = repo.saveAndFlush(order);
        assertNotNull(savedOrder);
    }
    

    @Test
    public void testSaveBankSlip() {

        OrderEntity order = new OrderEntity();
        order.setCustomer("John Snow");
        order.setOrderId(UUID.randomUUID().toString());
        order.setState(OrderStateEnum.CREATED);
        order.setValue(123.0);

        BankSlipEntity bankSlip = new BankSlipEntity();
        bankSlip.setExpirity(LocalDate.now().plusYears(1));
        bankSlip.setOrder(order);
        bankSlip.setNumber("1234567");
        bankSlip.setValue(123.0);
        bankSlip.setDiscount(0.0);
        order.setBankSlip(bankSlip);

        OrderEntity savedOrder = repo.saveAndFlush(order);
        assertNotNull(savedOrder);
    }
    
}
