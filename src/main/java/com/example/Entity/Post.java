package com.example.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	private String postName;
	private String postDesc;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "post_comment", joinColumns = {
			@JoinColumn(name = "postjoinId", referencedColumnName = "postId") }, inverseJoinColumns = {
					@JoinColumn(name = "commentjoinId", referencedColumnName = "commentId") })
	private List<Comment> commnetList;

	// many to one userLoginInformation

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "post_user", joinColumns = {
			@JoinColumn(name = "postjoinId", referencedColumnName = "postId") }, inverseJoinColumns = {
					@JoinColumn(name = "userjoinId", referencedColumnName = "userId") })
	private UserLoginInformation userLoginInformation;

}
