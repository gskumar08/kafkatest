package com.customer.service;

import com.customer.pojo.Customer;
import com.customer.pojo.ListenerPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListener {
    Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

    @KafkaListener(topics = "customer-topic", groupId = "customer")
    public void consumeCustomer(Customer customer){
        logger.info("Customer is processed for registration: "+customer.toString());
    }

    @KafkaListener(topics = "trianztest", groupId = "customer")
    public void consumeListener(ListenerPayload listener){
        logger.info("Topic: trianztest || Listner container is created with the detials: "+listener.toString());
    }
}