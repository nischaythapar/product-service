package com.programminglearner.product_service.controller;

import com.programminglearner.product_service.dto.ProductRequest;
import com.programminglearner.product_service.dto.ProductResponse;
import com.programminglearner.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        // here the productRequest acts as a DTO
        // and the logic for this will basically be inside the service
        // and not the controller itself

        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
       return productService.getAllProducts();
    }
}
