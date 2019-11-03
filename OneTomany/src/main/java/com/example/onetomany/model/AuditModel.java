package com.example.onetomany.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // tự động điền các trường createAt và updatedAt
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true) // Chú thích cấp lớp (class) này có thể
																					// được sử dụng để loại trừ các
																					// thuộc tính nhất định trong quá
																					// trình Serialization and
																					// Deserialization dữ liệu JSON.
																					// Nghĩa là chúng sẽ không được ánh
																					// xạ tới nội dung JSON

public abstract class AuditModel implements Serializable { // để cho lớp này hoạt động thì nên điền @EnableJPAAuditing
															// trong lớp application
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_At", nullable = false, updatable = true)
	@LastModifiedDate
	private Date updatedAt;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
