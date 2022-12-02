/*package com.epam.training.ticketservice.core.checkout.impl;

import com.epam.training.ticketservice.core.checkout.CheckoutObserver;
import com.epam.training.ticketservice.core.checkout.model.OrderDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CheckoutObservable {

    private final List<CheckoutObserver> observerList;

    public void notifyObservers(OrderDto orderDto) {
        observerList.forEach(observer -> observer.handleOrder(orderDto));
    }
}
*/