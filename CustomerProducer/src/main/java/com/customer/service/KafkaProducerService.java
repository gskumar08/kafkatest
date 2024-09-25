package com.customer.service;

import com.customer.pojo.Customer;
import com.customer.pojo.ListenerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Customer> template;

    @Autowired
    private KafkaTemplate<String, ListenerPayload> ListnerTemplate;

    public Customer sendTopic(Customer customer){
        try {
            CompletableFuture<SendResult<String, Customer>> status = template.send("customer-topic", customer );
            status.whenComplete((result,ex)->{
                if(ex==null){
                    System.out.println("Sent Message = ["+customer.toString()+ result.getRecordMetadata().offset()+"}");
                }else{
                    System.out.println("Unable to send the message "
                            +customer.toString()+" due to : "+ex.getMessage());
                    throw new RuntimeException("Unable to send the message "
                            +customer.toString()+" due to : "+ex.getMessage());
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    public ListenerPayload createListener(ListenerPayload listenerPayload){
        try {
            CompletableFuture<SendResult<String, ListenerPayload>> status = ListnerTemplate.send("trianztest", listenerPayload );
            status.whenComplete((result,ex)->{
                if(ex==null){
                    System.out.println("Sent Message = ["+listenerPayload.toString()+ result.getRecordMetadata().offset()+"}");
                }else{
                    System.out.println("Unable to send the message "
                            +listenerPayload.toString()+" due to : "+ex.getMessage());
                    throw new RuntimeException("Unable to send the message "
                            +listenerPayload.toString()+" due to : "+ex.getMessage());
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listenerPayload;
    }

}
