package com.example.inventorymanagementsystem;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.*;

@Controller
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showAllOrders (
            Model model
    ) {
        Iterable<Order> allOrders = this.orderService.getAllOrders();
        model.addAttribute("data", allOrders);
        return "orders";
    }

    @GetMapping("{orderId}")
    public String showOneOrder (
            Model model,
            @PathVariable("orderId") Integer id
    ) {
        Optional<Order> order = this.orderService.getOrderById(id);
        if (order.isEmpty()) {
            model.addAttribute(
                    "error",
                    "Order with id " + id + " not found"
            );
        } else {
            model.addAttribute(
                    "order",
                    order.get()
            );
        }
        return "order";
    }
    @GetMapping("new")
    public String newOrderForm(Model model){

        Order order=new Order() ;
        order.setStatus(OrderStatus.SUBMITTED);
        order.setPlacedTime(LocalDateTime.now());
       model.addAttribute("order",order);
        return "new-order";
    }
 @PutMapping
    public String updateOrCreateOrder(
            @ModelAttribute Order order
 ){
        System.out.println(order);
        return "redirect:/orders";
 }
    @GetMapping("login")
    public String log(){
        return "login";
    }
}