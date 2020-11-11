package com.github.ricardocomar.springbootcamunda.appgateway.mapper;

import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.StockRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.model.StockReplace;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StockReplaceMapper {

public abstract StockReplace fromRequest(StockRequest request);
    
}
