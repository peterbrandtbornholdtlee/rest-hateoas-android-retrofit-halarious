package com.example.android.scheduler.rest;

import java.math.BigInteger;

import ch.halarious.core.HalResource;

public class Message implements HalResource {

	private BigInteger id;
	private String telefone;
	private String body;
	
	public Message() {
		super();
	}

	public Message(BigInteger id, String telefone, String body) {
		super();
		this.id = id;
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
	
}
