package com.example.onetomany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "posts")
public class Post extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // tự độgn tăng id
	private Long id;

	@NotNull
	@Size(max = 100)
	@Column(unique = true) // ràng buộc khóa duy nhất chỉ tương ứng với cột duy nhất
	private String Title;

	@NotNull
	@Size(max = 250)
	private String description;

	@NotNull
	@Lob
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post(@NotNull @Size(max = 100) String title, @NotNull @Size(max = 250) String description,
			@NotNull String content) {
		super();
		Title = title;
		this.description = description;
		this.content = content;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
