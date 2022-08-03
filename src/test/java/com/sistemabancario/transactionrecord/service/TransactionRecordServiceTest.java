package com.sistemabancario.transactionrecord.service;

import com.sistemabancario.transactionrecord.domain.TransactionRecord;
import com.sistemabancario.transactionrecord.repository.ITransactionRecordRepository;
import com.sistemabancario.transactionrecord.service.impl.TransactionRecordService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
class TransactionRecordServiceTest {
    Date date = new Date();
    @Mock
    private ITransactionRecordRepository transactionRecordRepository;
    @InjectMocks
    private TransactionRecordService transactionRecordService;

    @DisplayName("Usuario que deseamos crear")


    @Test
    public void pruebacrear(){
        TransactionRecord transaction=new TransactionRecord("2","1","2",1500.0,1,date);

        TransactionRecord objectSimulado = new TransactionRecord ("2","1","2",120.0,20,date);
        TransactionRecord esperado =new TransactionRecord("1","1","2",1220.0,20,date);
        Mockito.when(transactionRecordRepository.save(transaction));
                //.thenReturn(objectSimulado);

        final Mono<TransactionRecord> resultado =
                transactionRecordService.save(transaction);
        Assertions.assertEquals(esperado,resultado,"No son iguales");
        Mockito.verify(transactionRecordRepository).save(transaction);
    }
}