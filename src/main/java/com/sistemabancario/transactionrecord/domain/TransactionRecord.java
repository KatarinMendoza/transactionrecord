package com.sistemabancario.transactionrecord.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("transactionrecord")
public class TransactionRecord{
	@Id
	private String id;
	private String accountId;
	private String operationTypeId;
	private Double amount;
	private Integer share;
	private Date payDate;
}
