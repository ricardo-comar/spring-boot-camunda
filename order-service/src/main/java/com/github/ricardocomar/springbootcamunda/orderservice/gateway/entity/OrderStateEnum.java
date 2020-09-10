package com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity;

import lombok.Getter;

@Getter
public enum OrderStateEnum {

    CREATED(10), APPROVED(100), REJECTED(90);

    private OrderStateEnum(int code) {
        this.code = code;
    }

    private int code;
}
