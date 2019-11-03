package com.example.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank(message = " name bat buoc")
	@Size(min= 10 , max = 20)
	private String name ;
	
	@Email
	@NotBlank(message = "email bat buoc")
	private String email;
	
	 @Column(name = "phone_no")
    private long phoneNo;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(@NotBlank(message = " name bat buoc") @Size(min = 10, max = 20) String name,
			@Email @NotBlank(message = "email bat buoc") String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	
	

}
