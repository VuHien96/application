package com.application.productservice.service;

import com.application.productservice.model.dto.ProductDTO;
import com.application.productservice.model.request.ProductRequest;
import com.application.productservice.model.response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getListProducts();

    ProductResponse getProductById(Long id);

    ProductDTO createProduct(ProductRequest request);

    void updateProduct(ProductRequest request, Long id);

    void deleteProduct(Long id);

    void reduceQuantity(Long id, Long quantity);
}
