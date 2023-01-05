package com.cucumberspringboot.preference.listener;

import com.cucumberspringboot.preference.sourceProperties.Inventory;
import com.cucumberspringboot.preference.utils.EventListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaLisner {

    @Autowired
    EventListener eventListener;

    @KafkaListener(topics = "Item_Inventory", groupId = "Group_id",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consume(Inventory inventoryData) throws JsonProcessingException {
        eventListener.addEvent(inventoryData);
        log.info("Consumed message is " + inventoryData);
    }
}
