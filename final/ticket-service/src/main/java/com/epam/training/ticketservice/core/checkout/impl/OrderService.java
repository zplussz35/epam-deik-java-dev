/*package com.epam.training.ticketservice.core.checkout.impl;

import com.epam.training.ticketservice.core.checkout.CheckoutObserver;
import com.epam.training.ticketservice.core.checkout.model.OrderDto;
import com.epam.training.ticketservice.core.checkout.persistance.model.Order;
import com.epam.training.ticketservice.core.checkout.persistance.model.OrderItem;
import com.epam.training.ticketservice.core.checkout.persistance.repository.OrderRepository;
import com.epam.training.ticketservice.core.finance.money.Money;
import com.epam.training.ticketservice.core.movie.model.MovieDto;
import com.epam.training.ticketservice.core.user.UserService;
import com.epam.training.ticketservice.core.user.model.UserDto;
import com.epam.training.ticketservice.core.user.persistence.entity.User;
import com.epam.training.ticketservice.core.user.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService implements CheckoutObserver {

    private final UserService userService;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public void handleOrder(OrderDto orderDto) {
        UserDto userDto = userService.describe().orElseThrow(() -> new IllegalArgumentException("You need to first login!"));
        User user = userRepository.findByUsername(userDto.getUsername()).orElseThrow(() -> new IllegalArgumentException("No such username!"));
        Order order = createOrderEntityFromDto(orderDto, user);
        orderRepository.save(order);
    }

    private Order createOrderEntityFromDto(OrderDto orderDto, User user) {
        return Order.builder()
                .user(user)
                .orderItems(orderDto.getMovieDtoList().stream()
                        .map(this::createOrderItemFromProduct)
                        .collect(Collectors.toList()))
                .netPriceAmount(orderDto.getNetPrice().getAmount())
                .grossPriceAmount(orderDto.getGrossPrice().getAmount())
                .netPriceCurrencyCode(orderDto.getNetPrice().getCurrency().getCurrencyCode())
                .grossPriceCurrencyCode(orderDto.getGrossPrice().getCurrency().getCurrencyCode())
                .build();
    }

    /*public List<OrderDto> retrieveOrdersForUser(UserDto userDto) {
        return orderRepository.findByUserUsername(userDto.getUsername()).stream()
                .map(this::createOrderDtoFromEntity)
                .collect(Collectors.toList());
    }

    /*private OrderDto createOrderDtoFromEntity(Order order) {
        return new OrderDto(
                order.getOrderItems().stream().map(this::createProductFromOrderItem).collect(Collectors.toList()),
                new Money(order.getNetPriceAmount(), Currency.getInstance(order.getNetPriceCurrencyCode())),
                new Money(order.getGrossPriceAmount(), Currency.getInstance(order.getGrossPriceCurrencyCode()))
        );
    }

    /*private MovieDto createProductFromOrderItem(OrderItem orderItem) {
        return MovieDto.builder()
                .withName(orderItem.getName())
                .withNetPrice(new Money(orderItem.getNetPriceAmount(), Currency.getInstance(orderItem.getNetPriceCurrencyCode())))
                .build();
    }

    private OrderItem createOrderItemFromProduct(MovieDto movieDto) {
        return OrderItem.builder()
                .name(movieDto.getName())
                .netPriceAmount(movieDto.getNetPrice().getAmount())
                .netPriceCurrencyCode(movieDto.getNetPrice().getCurrency().getCurrencyCode())
                .build();
    }
}
*/