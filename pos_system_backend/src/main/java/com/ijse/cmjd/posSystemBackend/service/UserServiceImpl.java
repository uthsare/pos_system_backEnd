package com.ijse.cmjd.posSystemBackend.service;

import com.ijse.cmjd.posSystemBackend.dto.UserPwdDTO;
import com.ijse.cmjd.posSystemBackend.entity.User;
import com.ijse.cmjd.posSystemBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
//change password
    @Override
    public User changeUserPassword(Long id, UserPwdDTO userPwdDTO) {
        return null;
    }
}
