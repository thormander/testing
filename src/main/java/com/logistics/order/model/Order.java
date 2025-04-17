package com.logistics.order.model;

import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order extends RepresentationModel<Order> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String description;
    private String productName;
    private String orderType;
    private String comment;
    private String userId;

    // Default constructor
    public Order() {
    }

    public Order(String description, String productName, 
                 String orderType, String comment, String userId) {
        this.description = description;
        this.productName = productName;
        this.orderType = orderType;
        this.comment = comment;
        this.userId = userId;
    }

    // Constructor with ID (for retrieval and updates)
    public Order(Long orderId, String description, String productName, 
                 String orderType, String comment, String userId) {
        this.orderId = orderId;
        this.description = description;
        this.productName = productName;
        this.orderType = orderType;
        this.comment = comment;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Order withComment(String comment) {
        this.setComment(comment);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", description='" + description + '\'' +
                ", productName='" + productName + '\'' +
                ", orderType='" + orderType + '\'' +
                ", comment='" + comment + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}