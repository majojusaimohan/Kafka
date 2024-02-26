package com.dragonbyte.Kafka.controller;


import com.dragonbyte.Kafka.payload.Student;
import com.dragonbyte.Kafka.producer.KafkaJsonProducer;
import com.dragonbyte.Kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){

        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued sucessfully");

    }

    @PostMapping("/json")
    public ResponseEntity<String> studentMessage(@RequestBody Student message){

        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued sucessfully as Json");

    }
}
