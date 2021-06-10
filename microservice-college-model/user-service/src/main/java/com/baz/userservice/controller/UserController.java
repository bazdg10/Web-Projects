package com.baz.userservice.controller;

import com.baz.userservice.VO.ResponseTemplateVO;
import com.baz.userservice.entity.User;
import com.baz.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser (@RequestBody User user) {
        log.info("Inside saveUser of userController");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of userController");
        return userService.getUserWithDepartment(userId);
    }

}


