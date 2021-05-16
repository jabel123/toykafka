package com.study.myfunny_kafka.controller;

import com.study.myfunny_kafka.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("trigger")
public class TestCtrl {
    private final Producer producer;

    @Autowired
    public TestCtrl(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping("/produce")
    public void requestProduceMessage()
    {
        for (int i = 0; i < 100; i++)
        {
            producer.sendMessageTopic1("sexy girl - " + i);
        }
    }
}
