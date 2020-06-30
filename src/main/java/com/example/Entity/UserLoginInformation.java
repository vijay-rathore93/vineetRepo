package com.example.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class UserLoginInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "userjoinId", referencedColumnName = "userId") }, inverseJoinColumns = {
					@JoinColumn(name = "rolejoinId", referencedColumnName = "roleId") })
	private Set<Role> roleList;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userInfoId")
	private UserInfo userInfo;

}
