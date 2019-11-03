package com.example.notetag.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class) //
@JsonIgnoreProperties(value = {"createdAt","updatedAt"},allowGetters = true)
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
	private String title;
	
	@OneToMany(mappedBy = "tag")
	private List<Note_Tag> ltag;
	
	@Column(name = "created_at")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updated_at")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


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



	public Tag(@NotBlank String title, List<Note_Tag> ltag, Date createdAt, Date updatedAt) {
		super();
		this.title = title;
		this.ltag = ltag;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public List<Note_Tag> getLtag() {
		return ltag;
	}

	public void setLtag(List<Note_Tag> ltag) {
		this.ltag = ltag;
	}

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
