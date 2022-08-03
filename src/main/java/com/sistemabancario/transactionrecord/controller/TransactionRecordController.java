package com.sistemabancario.transactionrecord.controller;

import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sistemabancario.transactionrecord.service.impl.TransactionEventsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemabancario.transactionrecord.domain.TransactionRecord;
import com.sistemabancario.transactionrecord.service.ITransactionRecordService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/transactionrecord")
public class TransactionRecordController {

    @Autowired
    private ITransactionRecordService transactionRecordService;

    private  TransactionEventsService transactionEventsService;
    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping
    public Flux<TransactionRecord> findAll(){
        LOGGER.info("getAll" + "OK");
        return transactionRecordService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionRecord> getById(@PathVariable("id") String id){
        LOGGER.info("getById" + "OK");
        return transactionRecordService.findById(id);
    }

    @PostMapping
    public Mono<TransactionRecord> create(@RequestBody TransactionRecord transactionRecord){
        LOGGER.info("create" + "OK");
        return transactionRecordService.save(transactionRecord);
    }
    @PutMapping
    public Mono<TransactionRecord> update(@RequestBody TransactionRecord transactionRecord){
        LOGGER.info("update" + "OK");
        return  transactionRecordService.save(transactionRecord);
    }

    @DeleteMapping
    public Mono<Void> deleteById(@PathVariable("id") String id){
        LOGGER.info("deleteById" + "OK");
        return transactionRecordService.deleteById(id);
    }

    @GetMapping("/Reporte/{document}")
    public Flux<TransactionRecord> findByDocument(@PathVariable("document") String document){
        LOGGER.info("findByDocument" + "OK");
        return transactionRecordService.findByDocument(document);
    }
}
