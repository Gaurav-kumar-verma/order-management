package com.vedantu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class BaseEntity {
	
	@Id
	@Field("_id")
	private Long id;
	
	@Field("created_at")
	private long createAt;
	
	@Field("updated_at")
	private long updatedAt;
	
	@Field("created_by")
	private Long createdBy;
	
	@Field("updated_by")
	private Long updatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(long createAt) {
		this.createAt = createAt;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
