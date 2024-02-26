package com.dragonbyte.Kafka.consumer;

import com.dragonbyte.Kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    //@KafkaListener(topics = "mohan", groupId = "myGroup")
    public void consumeMsg(String msg){
        log.info(String.format("Consuming the message form mohan topic: %s",msg));

    }

    @KafkaListener(topics = "mohan", groupId = "myGroup")
    public void consumeJsonMsg(Student student){
        log.info(String.format("Consuming the message form mohan topic: %s",student.toString()));

    }

}
