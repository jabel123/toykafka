package com.study.myfunny_kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConsumerService {

    @KafkaListener(
            topics = "${funny.kafka.topic}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(List<String> msgList) {
        for (String msg : msgList)
        {
            log.info("{}", msg);
        }
    }
}
