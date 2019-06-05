package com.vedeng.template.web.controller;

import com.vedeng.template.domain.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/users")
@RestController
public class UserController {

  @Value("${timeout}")
  private String timeout1;

  @Value("${timeout}")
  private Integer timeout2;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return new User(1L, "test张三");
  }

  @GetMapping("/apollo")
  public String apolloTest() {
    return timeout1 + ", " + timeout2.toString();
  }
}
