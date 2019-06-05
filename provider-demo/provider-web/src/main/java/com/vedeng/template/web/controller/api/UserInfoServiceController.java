package com.vedeng.template.web.controller.api;

import com.vedeng.provider.api.dto.UserDTO;
import com.vedeng.provider.api.service.UserInfoService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户服务接口实现
 * @author: Wyatt
 * @Date: 2019-06-05 14:36
 */
@RestController
public class UserInfoServiceController implements UserInfoService {

    @Override
    public UserDTO findById(Long aLong) {
        //业务逻辑
        UserDTO userDTO = new UserDTO();
        userDTO.setId(999L);
        userDTO.setUsername("come from feign iterface");
        return userDTO;
    }
}