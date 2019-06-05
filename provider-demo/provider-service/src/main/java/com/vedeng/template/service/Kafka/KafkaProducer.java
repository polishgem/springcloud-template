package com.vedeng.template.service.Kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @Description:
 * @Auther: Duke.li
 * @Date: 2019/3/16 13:39
 */

@Service("kafkaProducer")
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static Gson gson = new GsonBuilder().create();


    /* *
     * 功能描述: 发送消息
     * @param: [topic, msg]
     * @return: boolean
     * @auther: duke.li
     * @date: 2019/3/16 13:41
     */
    public void send(String topic, String msg){
        log.info("+++++++++++++++++++  topic = " + topic);

        log.info("+++++++++++++++++++  message = " + gson.toJson(msg));
        // topic 为消息主题
        kafkaTemplate.send(topic, gson.toJson(msg));
    }
}
