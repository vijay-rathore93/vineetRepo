package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // mandatory
@Table(name = "role") // Optional
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id // mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	private String roleName;
}
