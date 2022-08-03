package com.sistemabancario.transactionrecord.service.impl;

import com.sistemabancario.transactionrecord.domain.TransactionRecord;
import com.sistemabancario.transactionrecord.events.Event;
import com.sistemabancario.transactionrecord.events.EventType;
import com.sistemabancario.transactionrecord.events.TransactionrecordCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TransactionEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("@${topic.transactionrecord.name:transactionrecords}")
    private String topicTransaction;

    public void publish(TransactionRecord transactionRecord){
        TransactionrecordCreatedEvent created=new TransactionrecordCreatedEvent();
        created.setData(transactionRecord);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());
        this.producer.send(topicTransaction,created);
    }

    public  void Update(TransactionRecord transactionRecord){
        TransactionrecordCreatedEvent update=new TransactionrecordCreatedEvent();
        update.setData(transactionRecord);
        update.setId(UUID.randomUUID().toString());
        update.setType(EventType.UPDATED);
        update.setDate(new Date());
        this.producer.send(topicTransaction,update);
    }
}
