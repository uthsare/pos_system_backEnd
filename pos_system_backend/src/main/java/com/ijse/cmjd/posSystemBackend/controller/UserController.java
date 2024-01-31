package com.ijse.cmjd.posSystemBackend.controller;

import com.ijse.cmjd.posSystemBackend.dto.UserPwdDTO;
import com.ijse.cmjd.posSystemBackend.entity.User;
import com.ijse.cmjd.posSystemBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/user/{id}/change-password")
    public ResponseEntity<User> changeUserPassword(@PathVariable Long id, @RequestBody UserPwdDTO userPwdDTO) {
        return ResponseEntity.ok().body(userService.changeUserPassword(id, userPwdDTO));
    }
}
