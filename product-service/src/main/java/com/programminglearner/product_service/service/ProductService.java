package com.programminglearner.product_service.service;

import com.programminglearner.product_service.dto.ProductRequest;
import com.programminglearner.product_service.dto.ProductResponse;
import com.programminglearner.product_service.model.Product;
import com.programminglearner.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {

//        Product product = Product.builder()
//                .name(productRequest.getName())
//                .description(productRequest.getDescription())
//                .price(productRequest.getPrice())
//                .build();

        Product product = new Product();
        product.setDescription(productRequest.getDescription());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());

        productRepository.save(product);
        //log.info("The product" + product.getId() + "has been saved in the repository");
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapProductToResponse).toList();
        }

    private ProductResponse mapProductToResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescrption(product.getDescription());
        productResponse.setPrice(product.getPrice());

        return productResponse;
    }
}
