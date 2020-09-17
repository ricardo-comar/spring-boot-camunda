package com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity;

import lombok.Getter;

@Getter
public enum OrderStateEnum {

    CREATED(10), APPROVED(20), FINISHED(50), REJECTED(90), CANCELLED(99);

    private OrderStateEnum(int code) {
        this.code = code;
    }

    private int code;
}
