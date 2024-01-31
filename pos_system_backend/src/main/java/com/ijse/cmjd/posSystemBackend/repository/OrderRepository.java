package com.ijse.cmjd.posSystemBackend.repository;

import com.ijse.cmjd.posSystemBackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
