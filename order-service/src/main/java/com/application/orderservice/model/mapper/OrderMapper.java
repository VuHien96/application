package com.application.orderservice.model.mapper;

import com.application.orderservice.entity.Order;
import com.application.orderservice.external.response.PaymentResponse;
import com.application.orderservice.external.response.ProductResponse;
import com.application.orderservice.model.dto.OrderDTO;
import com.application.orderservice.model.response.OrderResponse;
import com.application.orderservice.model.response.PaymentDetails;
import com.application.orderservice.model.response.ProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "totalAmount ", source = "amount")
    OrderDTO mapToOrderDTO(Order order);

    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "amount", source = "order.amount")
    @Mapping(target = "paymentDetails.amount", source = "paymentDetails.amount")
    @Mapping(target = "paymentDetails.paymentId", source = "paymentDetails.paymentId")
    @Mapping(target = "paymentDetails.status", source = "paymentDetails.status")
    @Mapping(target = "paymentDetails.paymentMode", source = "paymentDetails.paymentMode")
    @Mapping(target = "paymentDetails.paymentDate", source = "paymentDetails.paymentDate")
    @Mapping(target = "paymentDetails.orderId", source = "paymentDetails.orderId")
    OrderResponse mapToOrderResponse(Order order, ProductDetails productDetails, PaymentDetails paymentDetails);

    ProductDetails mapToProductDetail(ProductResponse response);


    PaymentDetails mapToPaymentDetail(PaymentResponse response);
}
