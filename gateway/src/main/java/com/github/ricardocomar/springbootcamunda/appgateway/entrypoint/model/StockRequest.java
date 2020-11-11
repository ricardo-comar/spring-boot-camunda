
package com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model;

import lombok.Data;

@Data
public class StockRequest {

    public String sku;

    public Double quantity;
}
