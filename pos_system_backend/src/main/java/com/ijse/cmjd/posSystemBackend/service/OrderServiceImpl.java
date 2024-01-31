package com.ijse.cmjd.posSystemBackend.service;

import com.ijse.cmjd.posSystemBackend.dto.OrderDTO;
import com.ijse.cmjd.posSystemBackend.entity.Order;
import com.ijse.cmjd.posSystemBackend.entity.Product;
import com.ijse.cmjd.posSystemBackend.repository.OrderRepository;
import com.ijse.cmjd.posSystemBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService{
   @Autowired
   private OrderRepository orderRepository;

   @Autowired
   private ProductRepository productRepository;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();

        List<Long> products = orderDTO.getProducts();

        Set<Product> productsSet = new HashSet<>();

        order.setTotal(0.0);

        for (Long productId : products) {
            Product product = productRepository.findById(productId).orElse(null);

            if(product != null && product.getInStockQTY() != 0) {
                productsSet.add(product);
                order.setTotal(order.getTotal() + product.getUnitPrice());

                //Reduce the QTY of current stock
            }
        }

        Double tax = (order.getTotal()/100) * 15; //Adding 15% Tax

        order.setTax(tax);
        order.setOrderTime(LocalDateTime.now());
        order.setProducts(productsSet);

        return orderRepository.save(order);
    }
}
