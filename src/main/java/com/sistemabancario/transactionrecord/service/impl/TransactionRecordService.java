package com.sistemabancario.transactionrecord.service.impl;

import com.sistemabancario.transactionrecord.domain.Account;
import com.sistemabancario.transactionrecord.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sistemabancario.transactionrecord.domain.TransactionRecord;
import com.sistemabancario.transactionrecord.repository.ITransactionRecordRepository;
import com.sistemabancario.transactionrecord.service.ITransactionRecordService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class TransactionRecordService implements ITransactionRecordService {

    @Autowired
    private final ITransactionRecordRepository transactionRecordRepository;

    private final TransactionEventsService transactionEventsService;

    private KafkaTemplate<String, TransactionRecord> kafkaTemplate;
    //private final IAccountRepository accountRepository;
    @Override
    public Flux<TransactionRecord> findAll() {return transactionRecordRepository.findAll();}

    @Override
    public Mono<TransactionRecord> findById(String id) {return transactionRecordRepository.findById(id);}

    SimpleDateFormat format=new SimpleDateFormat();
    Date date = new Date(System.currentTimeMillis());
    @Override
    public Mono<TransactionRecord> save(TransactionRecord transactionRecord){
        transactionRecordRepository.findAll()
                .filter(x-> x.getPayDate().before(date));
        transactionEventsService.publish(transactionRecord);
        return transactionRecordRepository.save(transactionRecord);

    }

    @Override
    public Mono<TransactionRecord> update(TransactionRecord transactionRecord) {
        transactionEventsService.Update(transactionRecord);
        return transactionRecordRepository.save(transactionRecord);
    }

    @Override
    public Mono<Void> deleteById(String id) {return transactionRecordRepository.deleteById(id);}

    @Override
    public Flux<TransactionRecord> findByDocument(String document) {
        RestTemplate temp=new RestTemplate();
        Client client = temp.getForObject("http://localhost:8030/client/Consultas/" + document, Client.class);
        Account account=temp.getForObject("http://localhost:8010/account/Consultas/" + client.getId(),Account.class);
        return transactionRecordRepository.findAll()
                .filter(x->x.getAccountId().equals(account.getId()));
    }



}
