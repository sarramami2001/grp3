package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.util.RoleEnum;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_ID")
	private Long id;
	
	@NotBlank
	private String name;
<<<<<<< HEAD
	private String cin;
=======
	private String lastname;
>>>>>>> ba13f49a7ec7f7d1ac37d52d991320ef0a324399

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(RoleEnum role) {
		super();
		this.name = role.getName();
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public String getCIN() {
		return cin;
	}
	public void setName(String name) {
		this.name = name;
	}

}
