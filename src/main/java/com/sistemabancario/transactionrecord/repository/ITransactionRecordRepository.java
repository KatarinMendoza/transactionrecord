package com.sistemabancario.transactionrecord.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.sistemabancario.transactionrecord.domain.TransactionRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRecordRepository extends ReactiveCrudRepository<TransactionRecord, String> {

}
