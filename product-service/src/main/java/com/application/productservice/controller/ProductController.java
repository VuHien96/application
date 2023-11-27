package com.application.productservice.controller;

import com.application.productservice.model.dto.ProductDTO;
import com.application.productservice.model.request.ProductRequest;
import com.application.productservice.model.response.ProductResponse;
import com.application.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {
        ProductResponse productResponse
                = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/reduce-quantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable Long id, @RequestParam Long quantity) {
        productService.reduceQuantity(id, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
