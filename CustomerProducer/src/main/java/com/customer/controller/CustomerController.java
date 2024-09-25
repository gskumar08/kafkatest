package com.customer.controller;

import com.customer.pojo.Customer;
import com.customer.pojo.ListenerPayload;
import com.customer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping()
    private ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
        customer = kafkaProducerService.sendTopic(customer);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/listener")
    private ResponseEntity<ListenerPayload> registerlistener(@RequestBody ListenerPayload listenerPayload){
        listenerPayload = kafkaProducerService.createListener(listenerPayload);
        return ResponseEntity.ok(listenerPayload);
    }
}
