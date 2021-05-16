package com.study.myfunny_kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {
    @Value("${funny.kafka.topic1}")
    private String topicName1;

    @Value("${funny.kafka.topic2}")
    private String topicName2;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageTopic1(String msg) {
        this.kafkaTemplate.send(topicName1, msg);
    }

    public void sendMessageTopic2(String msg) {
        this.kafkaTemplate.send(topicName2, msg);
    }
}
