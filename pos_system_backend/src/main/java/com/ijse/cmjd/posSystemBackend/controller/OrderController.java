package com.ijse.cmjd.posSystemBackend.controller;


import com.ijse.cmjd.posSystemBackend.dto.OrderDTO;
import com.ijse.cmjd.posSystemBackend.entity.Order;
import com.ijse.cmjd.posSystemBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(orderService.getOrderById(id));
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        Order newOrder = orderService.createOrder(orderDTO);

        return ResponseEntity.status(201).body(newOrder);
    }
}
