package com.ijse.cmjd.posSystemBackend.service;

import com.ijse.cmjd.posSystemBackend.dto.UserPwdDTO;
import com.ijse.cmjd.posSystemBackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
   List<User> getAllUsers();
   User createUser(User user);
   User getUserById(Long id);
   User changeUserPassword(Long id, UserPwdDTO userPwdDTO);
}
