
package com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OrderRequest {

    public String customer;

    public Double value;

    public CreditCard card;

    public BankSlip bankSlip;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BankSlip {

        String number;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonSerialize(using = LocalDateSerializer.class)
        LocalDate dueDate;

        Double value;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreditCard {

        String name;

        String number;

        String expirity;

        String ccv;
    }
}
