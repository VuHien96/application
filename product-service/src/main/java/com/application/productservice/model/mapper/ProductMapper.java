package com.application.productservice.model.mapper;

import com.application.productservice.entity.Product;
import com.application.productservice.model.dto.ProductDTO;
import com.application.productservice.model.request.ProductRequest;
import com.application.productservice.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product mapToProduct(ProductRequest request);

    ProductDTO mapToProductDTO(Product product);

    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productId", source = "id")
    ProductResponse mapToProductResponse(Product product);

    List<ProductDTO> mapToListProduct(List<Product> products);
}
