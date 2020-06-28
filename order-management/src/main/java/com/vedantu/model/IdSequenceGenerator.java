package com.vedantu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class IdSequenceGenerator {
	
	@Id
	@Field("_id")
	private String id;

	@Field("sequence")
	private long sequence;
	
	
	@Field("collection_type")
	private String type;
	
	@Field("locked")
	private boolean locked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "IdSequenceGenerator [id=" + id + ", sequence=" + sequence + ", type=" + type + ", locked=" + locked
				+ "]";
	}

	
	
	
	
	

}
