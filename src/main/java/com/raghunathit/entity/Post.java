package com.raghunathit.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="POST_TBL")
@Getter
@Setter
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	@Lob
	private String content;
	@CreationTimestamp
	private LocalDate createdOn;
	private String description;
	private String title;
	@UpdateTimestamp
	private LocalDate updatedOn;
	
	//one post can have multiple comments
	//when we delete one post then all the comment will also be deleted.
	@OneToMany(mappedBy="post",cascade=CascadeType.REMOVE)
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	//here user table primary key will be inserted into a post table as a foren key
	

}
