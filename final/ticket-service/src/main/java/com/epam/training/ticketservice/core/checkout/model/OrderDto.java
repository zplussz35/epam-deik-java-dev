package com.epam.training.ticketservice.core.checkout.model;

import com.epam.training.ticketservice.core.finance.money.Money;
import com.epam.training.ticketservice.core.product.model.ProductDto;
import lombok.Value;

import java.util.List;

@Value
public class OrderDto {

    private final List<ProductDto> productDtoList;
    private final Money netPrice;
    private final Money grossPrice;
}
