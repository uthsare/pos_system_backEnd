package com.ijse.cmjd.posSystemBackend.repository;

import com.ijse.cmjd.posSystemBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
}
