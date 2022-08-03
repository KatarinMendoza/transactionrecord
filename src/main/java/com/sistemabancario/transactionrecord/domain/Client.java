package com.sistemabancario.transactionrecord.domain;

import lombok.Data;
@Data
public class Client {

	private String id;
	private String name;
	private String lastName;
	private String documentNumber;
	private String phoneNumber;
	private String businessName;
	private String clientTypeId;
	private String documentTypeId;
}
