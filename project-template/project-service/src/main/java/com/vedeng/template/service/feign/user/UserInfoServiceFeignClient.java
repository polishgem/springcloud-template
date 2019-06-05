package com.vedeng.template.service.feign.user;

import com.vedeng.provider.api.dto.UserDTO;
import com.vedeng.provider.api.service.UserInfoService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "provider", fallback = UserInfoFeignClientFallback.class)
public interface UserInfoServiceFeignClient extends UserInfoService {
}

@Component
class UserInfoFeignClientFallback implements UserInfoServiceFeignClient {

    @Override
    public UserDTO findById(Long aLong) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(0L);
        userDTO.setUsername("hystrix");

        return userDTO;
    }
}