package com.vedeng.template.web.controller;

import com.vedeng.provider.api.dto.UserDTO;
import com.vedeng.provider.api.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouli
 */
@RequestMapping("/movies")
@RestController
public class MovieController {


  @Autowired
  private UserFeignClient userFeignClient;

  /*
  @GetMapping("/users/{id}")
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }
  */

  @GetMapping("/test")
  public UserDTO findById() {
    return userFeignClient.findById(1L);
  }
}
