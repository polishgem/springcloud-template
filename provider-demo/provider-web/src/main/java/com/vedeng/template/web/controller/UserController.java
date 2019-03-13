package com.vedeng.template.web.controller;

import com.vedeng.template.domain.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/users")
@RestController
public class UserController {


  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return new User(1L, "test张三");
  }

}
