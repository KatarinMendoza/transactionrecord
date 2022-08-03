package com.sistemabancario.transactionrecord.events;

import com.sistemabancario.transactionrecord.domain.TransactionRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransactionrecordCreatedEvent extends Event<TransactionRecord>{
}
