package com.epam.training.ticketservice.core.checkout;

import com.epam.training.ticketservice.core.cart.Cart;
import com.epam.training.ticketservice.core.checkout.model.OrderDto;

public interface CheckoutService {

    OrderDto checkout(Cart cart);
}
