package com.study.myfunny_kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {
    @Value("${funny.kafka.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produceMessage(String msg) {
        this.kafkaTemplate.send(topicName, msg);
    }
}
