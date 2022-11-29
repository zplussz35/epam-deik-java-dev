package com.epam.training.ticketservice.core.cart;

import com.epam.training.ticketservice.core.checkout.CheckoutObserver;
import com.epam.training.ticketservice.core.checkout.model.OrderDto;
import com.epam.training.ticketservice.core.finance.bank.Bank;
import com.epam.training.ticketservice.core.finance.money.Money;
import com.epam.training.ticketservice.core.product.model.ProductDto;
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
    private final List<ProductDto> productDtoList;

    public static Cart createEmptyCart(Bank bank) {
        return new Cart(bank, new ArrayList<>());
    }

    public static Cart createCart(Bank bank, ProductDto... productDtos) {
        return new Cart(bank, Arrays.asList(productDtos));
    }

    public void addProduct(ProductDto productDto) {
        if (productDto != null) {
            productDtoList.add(productDto);
        }
    }

    public void removeProduct(ProductDto productDto) {
        if (productDto != null) {
            productDtoList.remove(productDto);
        }
    }

    public Money getAggregatedNetPrice() {
        Money aggregatedPrice = new Money(0, Currency.getInstance("HUF"));
        for (ProductDto productDto : productDtoList) {
            aggregatedPrice = aggregatedPrice.add(productDto.getNetPrice(), bank);
        }
        return aggregatedPrice;
    }

    public List<ProductDto> getProductDtoList() {
        return List.copyOf(productDtoList);
    }

    public void clearCart() {
        productDtoList.clear();
    }

    @Override
    public void handleOrder(OrderDto orderDto) {
        clearCart();
    }
}
