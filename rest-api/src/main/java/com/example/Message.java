package com.example;

import java.math.BigInteger;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message {

	@Id
	private BigInteger id;
	private String telefone;
	private String body;
	
	public Message() {
		super();
	}

	public Message(String telefone, String body) {
		super();
		this.telefone = telefone;
		this.body = body;
	}
	
	public BigInteger getId() {
		return id;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

	
}
