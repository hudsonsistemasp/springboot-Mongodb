package com.mongdb.mongodbTest.dto;

import java.io.Serializable;

import com.mongdb.mongodbTest.domain.User;

public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public AuthorDTO() {		
	}
	public AuthorDTO(String id, String nome, String email) {
		this.id = id;
		this.nome = nome;
	}
	public AuthorDTO(User objUser) {
		this.id = objUser.getId();
		this.nome = objUser.getName();
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
