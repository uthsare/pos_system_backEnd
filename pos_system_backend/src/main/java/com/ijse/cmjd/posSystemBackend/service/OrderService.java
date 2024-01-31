package com.ijse.cmjd.posSystemBackend.service;

import com.ijse.cmjd.posSystemBackend.dto.OrderDTO;
import com.ijse.cmjd.posSystemBackend.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
List<Order> getAllOrders();
Order getOrderById(Long id);
Order createOrder(OrderDTO orderDTO);
}
