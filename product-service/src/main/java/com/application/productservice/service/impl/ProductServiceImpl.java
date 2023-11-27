package com.application.productservice.service.impl;

import com.application.productservice.entity.Product;
import com.application.productservice.exception.BadRequestException;
import com.application.productservice.exception.NotFoundException;
import com.application.productservice.exception.ProductServiceCustomException;
import com.application.productservice.locale.Translator;
import com.application.productservice.model.dto.ProductDTO;
import com.application.productservice.model.mapper.ProductMapper;
import com.application.productservice.model.request.ProductRequest;
import com.application.productservice.model.response.ProductResponse;
import com.application.productservice.repository.ProductRepository;
import com.application.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getListProducts() {
        var products = productRepository.findAll();
        return productMapper.mapToListProduct(products);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        log.info("Start getProductById with id [{}]", id);
        var product = checkProduct(id);
        return productMapper.mapToProductResponse(product);
    }

    private Product checkProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("product.not.found")));
    }

    @Override
    public ProductDTO createProduct(ProductRequest request) {
        log.info("Start createProduct with param [{}]", request);
        var product = productMapper.mapToProduct(request);
        productRepository.save(product);
        return productMapper.mapToProductDTO(product);
    }

    @Override
    public void updateProduct(ProductRequest request, Long id) {
        log.info("Start updateProduct with param [{}] & [{}]", request, id);
        var product = checkProduct(id);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        productRepository.save(product);
        log.info("End updateProduct with id [{}]", id);
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Start deleteProduct with id [{}]", id);
        checkProduct(id);
        productRepository.deleteById(id);
        log.info("End deleteProduct with id [{}]", id);
    }

    @Override
    public void reduceQuantity(Long id, Long quantity) {
        log.info("Start reduceQuantity with id [{}] & quantity [{}]", id, quantity);
        var product = checkProduct(id);
        if (product.getQuantity() < quantity) {
//            throw new BadRequestException(Translator.toLocale("product.sufficient.quantity"));
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product quantity updated successfully");
    }
}
