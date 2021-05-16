package com.study.myfunny_kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConsumerService {

    private final KafkaTemplate<String, String> template;

    @Value("${funny.kafka.topic1}")
    private String topic1;

    @Value("${funny.kafka.topic1}")
    private String topic2;

    @Autowired
    public ConsumerService(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @KafkaListener(
            topics = "${funny.kafka.topic1}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen1(List<String> msgList) {
        for (String msg : msgList)
        {
            log.info("{} - {}", topic1, msg);
            template.send(topic2, msg);
        }
    }

    @KafkaListener(
            topics = "${funny.kafka.topic2}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen2(List<String> msgList) {
        for (String msg : msgList)
        {
            log.info("{} - {}", topic2, msg);
            template.send(topic1, msg);
        }
    }
}
