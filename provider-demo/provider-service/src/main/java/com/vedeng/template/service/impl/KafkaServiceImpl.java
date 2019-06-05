package com.vedeng.template.service.impl;

import com.vedeng.template.service.Kafka.KafkaProducer;
import com.vedeng.template.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @Auther: Duke.li
 * @Date: 2019/3/14 20:59
 */
@Service("kafkaService")
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public void send(String topic, String msg){

        // topic-vedeng 为消息主题
        kafkaProducer.send(topic, msg);
    }

}
