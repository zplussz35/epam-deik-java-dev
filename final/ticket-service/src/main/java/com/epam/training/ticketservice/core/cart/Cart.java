/*package com.epam.training.ticketservice.core.cart;

import com.epam.training.ticketservice.core.checkout.CheckoutObserver;
import com.epam.training.ticketservice.core.checkout.model.OrderDto;
import com.epam.training.ticketservice.core.finance.bank.Bank;
import com.epam.training.ticketservice.core.finance.money.Money;
import com.epam.training.ticketservice.core.movie.model.MovieDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class Cart implements CheckoutObserver {

    private final Bank bank;
    private final List<MovieDto> movieDtoList;

    public static Cart createEmptyCart(Bank bank) {
        return new Cart(bank, new ArrayList<>());
    }

    public static Cart createCart(Bank bank, MovieDto... movieDtos) {
        return new Cart(bank, Arrays.asList(movieDtos));
    }

    public void addProduct(MovieDto movieDto) {
        if (movieDto != null) {
            movieDtoList.add(movieDto);
        }
    }

    public void removeProduct(MovieDto movieDto) {
        if (movieDto != null) {
            movieDtoList.remove(movieDto);
        }
    }

    public Money getAggregatedNetPrice() {
        Money aggregatedPrice = new Money(0, Currency.getInstance("HUF"));
        for (MovieDto movieDto : movieDtoList) {
            aggregatedPrice = aggregatedPrice.add(movieDto.getNetPrice(), bank);
        }
        return aggregatedPrice;
    }

    public List<MovieDto> getMovieDtoList() {
        return List.copyOf(movieDtoList);
    }

    public void clearCart() {
        movieDtoList.clear();
    }

    @Override
    public void handleOrder(OrderDto orderDto) {
        clearCart();
    }
}
*/