package com.example.demo.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.config.NodeTypeCache;

@Service
public class KafkaConsumer {
	
	@Autowired
	NodeTypeCache getNodeType;

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        System.out.println(getNodeType.getData(message));
        int nexttime = Integer.parseInt(message);
        nexttime += 1; 
        getNodeType.setData(String.valueOf(nexttime), "DC");
    }

}
