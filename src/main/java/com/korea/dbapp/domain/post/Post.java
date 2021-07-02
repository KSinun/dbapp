package com.korea.dbapp.domain.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.korea.dbapp.domain.user.User;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 프라이머리 키 (기본 키)
	private String title; // varchar(255), 255는 글자수
	@Lob
	private String content;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	// 한명의 유저는 여러게의 포스트를 작성할 수 있다.
	private User user; // ORM 사용 - 하이버네이트 기술 사용 ㄱㄴ
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
