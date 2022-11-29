package com.epam.training.ticketservice.core.warehouse;



import com.epam.training.ticketservice.core.checkout.CheckoutObserver;
import com.epam.training.ticketservice.core.checkout.model.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService implements CheckoutObserver {

    @Override
    public void handleOrder(OrderDto orderDto) {
        System.out.println("WarehouseService handleOrder method is called!");
    }
}
