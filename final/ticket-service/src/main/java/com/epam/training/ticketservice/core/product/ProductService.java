package com.epam.training.ticketservice.core.product;

import com.epam.training.ticketservice.core.product.model.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getProductList();

    Optional<ProductDto> getProductByName(String productName);

    void createProduct(ProductDto productDto);
}
