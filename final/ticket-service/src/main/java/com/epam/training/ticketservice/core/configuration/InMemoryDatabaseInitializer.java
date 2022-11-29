package com.epam.training.ticketservice.core.configuration;

import com.epam.training.ticketservice.core.product.persistence.entity.Product;
import com.epam.training.ticketservice.core.product.persistence.repository.ProductRepository;
import com.epam.training.ticketservice.core.user.persistence.entity.User;
import com.epam.training.ticketservice.core.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("prod")
@RequiredArgsConstructor
public class InMemoryDatabaseInitializer {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        User admin = new User("admin", "admin", User.Role.ADMIN);
        userRepository.save(admin);

        Product hypo = new Product("Hypo", 550.0, "HUF");
        productRepository.save(hypo);
    }
}
