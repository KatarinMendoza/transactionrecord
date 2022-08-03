package com.sistemabancario.transactionrecord.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Account {
    private String id;
    private String clientId;
    private String accountTypeId;
    private String nroCuenta;
    private Double saldo;
    private String representationId;
}
