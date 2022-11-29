package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.finance.money.Money;
import com.epam.training.ticketservice.core.product.ProductService;
import com.epam.training.ticketservice.core.product.model.ProductDto;
import com.epam.training.ticketservice.core.user.UserService;
import com.epam.training.ticketservice.core.user.model.UserDto;
import com.epam.training.ticketservice.core.user.persistence.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.Currency;
import java.util.List;
import java.util.Optional;

@ShellComponent
@AllArgsConstructor
public class ProductCommand {

    private final ProductService productService;
    private final UserService userService;

    @ShellMethod(key = "user product list", value = "List the available products")
    public List<ProductDto> listProducts() {
        return productService.getProductList();
    }

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "admin product create", value = "Create new product")
    public ProductDto createProduct(String name, Double amount, String currency) {
        ProductDto productDto = ProductDto.builder()
                .withName(name)
                .withNetPrice(new Money(amount, Currency.getInstance(currency)))
                .build();
        productService.createProduct(productDto);
        return productDto;
    }

    private Availability isAvailable() {
        Optional<UserDto> user = userService.describe();
        return user.isPresent() && user.get().getRole() == User.Role.ADMIN
                ? Availability.available()
                : Availability.unavailable("You are not an admin!");
    }
}
