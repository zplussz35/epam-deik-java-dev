package com.epam.training.ticketservice.core.cart.grossprice.impl;

import com.epam.training.ticketservice.core.cart.Cart;
import com.epam.training.ticketservice.core.cart.grossprice.GrossPriceCalculator;
import com.epam.training.ticketservice.core.finance.money.Money;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GrossPriceCalculatorDecorator implements GrossPriceCalculator {

    private GrossPriceCalculator grossPriceCalculator;

    @Override
    public Money getAggregatedGrossPrice(Cart cart) {
        return grossPriceCalculator.getAggregatedGrossPrice(cart);
    }
}
