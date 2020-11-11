package com.github.ricardocomar.springbootcamunda.appgateway.model;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
public class StockReplace {

    String sku;

    Double quantity;

    @With
    public Process process;
}
