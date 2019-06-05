package com.vedeng.template.web.controller;

import com.vedeng.template.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: Duke.li
 * @Date: 2019/3/14 21:26
 */
@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/send")
    public void apolloTest(String topic, String msg) {
        kafkaService.send(topic, msg);
    }
}
