package com.vedeng.template.service.user;

import com.vedeng.template.domain.user.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional(propagation = Propagation.REQUIRED)
    User queryUser(long id);
}
