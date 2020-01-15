package com.mongdb.mongodbTest.domain;

import java.io.Serializable;
import java.time.Instant;

public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Instant date;
	private String title;
	private String body;
	
	public Post() {
	}
	public Post(String id, Instant date, String title, String body) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public Instant getDate() {
		return date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getBody() {
		return body;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
