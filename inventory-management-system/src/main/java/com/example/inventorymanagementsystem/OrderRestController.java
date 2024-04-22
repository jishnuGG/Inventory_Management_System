package com.example.inventorymanagementsystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @GetMapping
    public Iterable<Order> getAll() {
        return this.orderService.getAllOrders();
    }

    @GetMapping("{orderId}")
    public Optional<Order> getOne(
            @PathVariable("orderId") Integer id
    ) {
        return this.orderService.getOrderById(id);
    }

}
