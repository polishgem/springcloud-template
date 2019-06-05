package com.vedeng.provider.api.service;

import com.vedeng.provider.api.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface UserInfoService {

  @GetMapping("/userInfo/{id}")
  UserDTO findById(@PathVariable("id") Long id);
}
