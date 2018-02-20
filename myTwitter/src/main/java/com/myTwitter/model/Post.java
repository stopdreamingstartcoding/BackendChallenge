package com.myTwitter.model;

import java.time.LocalDateTime;

public class Post {

	private final int MSG_MAX_LENTH = 140;
	private String message;
	private LocalDateTime createdTime;

	public Post() {
		super();
	}

	public Post(String message) {
		super();
		this.createdTime = LocalDateTime.now();
		if (message != null && message.length() > MSG_MAX_LENTH) {
			this.message = message.substring(0, MSG_MAX_LENTH);
		} else {
			this.message = message;
		}

	}

	public void setCreated(LocalDateTime created) {
		this.createdTime = created;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

}
