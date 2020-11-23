
package com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
    public static class BankSlip {

        Double discount;

        private String number;

        private Double value;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonSerialize(using = LocalDateSerializer.class)
        private LocalDate expirity;

    }

    @Data
    @NoArgsConstructor
    public static class CreditCard {

        private String name;

        private String ccv;

        private String number;

        private Double value;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonSerialize(using = LocalDateSerializer.class)
        private LocalDate expirity;
    }

}
