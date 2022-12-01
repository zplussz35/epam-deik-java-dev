/*package com.epam.training.ticketservice.core.checkout.impl;

//import com.epam.training.ticketservice.core.cart.Cart;
import com.epam.training.ticketservice.core.cart.grossprice.GrossPriceCalculator;
import com.epam.training.ticketservice.core.checkout.CheckoutService;
import com.epam.training.ticketservice.core.checkout.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckoutServiceImpl implements CheckoutService {

    private final GrossPriceCalculator grossPriceCalculator;
    private final CheckoutObservable checkoutObservable;

    @Autowired
    public CheckoutServiceImpl(GrossPriceCalculator grossPriceCalculator, CheckoutObservable checkoutObservable) {
        this.grossPriceCalculator = grossPriceCalculator;
        this.checkoutObservable = checkoutObservable;
    }

    @Override
    public OrderDto checkout(Cart cart) {
        OrderDto orderDto = new OrderDto(cart.getMovieDtoList(), cart.getAggregatedNetPrice(), grossPriceCalculator.getAggregatedGrossPrice(cart));
        checkoutObservable.notifyObservers(orderDto);
        return orderDto;
    }
}
*/
