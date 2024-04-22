package com.example.inventorymanagementsystem;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Iterable<Order> getAllOrders() {

        return this.repository.findAll();

    }

    Optional<Order> getOrderById(Integer id) {
        return repository.findById(id);
    }

}