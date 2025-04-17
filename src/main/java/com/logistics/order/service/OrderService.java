package com.logistics.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.order.model.Order;
import com.logistics.order.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    


    public Order createOrder(Order order) {
        
        Order savedOrder = orderRepository.save(order);
        
        return savedOrder;
    }
    

    public Order updateOrder(Order order) {
        if (!orderRepository.existsById(order.getOrderId())) {
            throw new RuntimeException("Order not found with ID: " + order.getOrderId());
        }
        
        Order savedOrder = orderRepository.save(order);


        return savedOrder;
    }

    public String deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
        orderRepository.deleteById(orderId);
        
        return "Order deleted successfully: " + orderId;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
