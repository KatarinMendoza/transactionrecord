package com.sistemabancario.transactionrecord.service;

import com.sistemabancario.transactionrecord.domain.TransactionRecord;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionRecordService {

    Flux<TransactionRecord> findAll();

    Mono<TransactionRecord> findById(String id);

    Mono<TransactionRecord> save(TransactionRecord transactionRecord);

    Mono<TransactionRecord> update(TransactionRecord transactionRecord);

    public Mono<Void> deleteById(String id);

    public Flux<TransactionRecord> findByDocument(String document);
}
