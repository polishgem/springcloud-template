package com.vedeng.template.service;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: Duke.li
 * @Date: 2019/3/14 20:55
 */
public interface KafkaService {

    void send(String topic, String msg);
}
