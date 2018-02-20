package com.myTwitter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

	private String name;
	private List<Post> posts;
	private List<User> followedByMeUsers;

	public User(String name) {
		super();
		this.name = name;
		this.posts = new ArrayList<Post>();
		this.followedByMeUsers = new ArrayList<User>();
	}

	public User() {
		super();
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<User> getFollowedByMeUsers() {
		return followedByMeUsers;
	}

	public String getName() {
		return name;
	}

	public void addFollower(User user) {
		this.followedByMeUsers.add(user);
	}

	public List<Post> getPostFromFollowedByMeUsers() {
		List<Post> postsList = new ArrayList<Post>();
		for (User user : followedByMeUsers) {
			postsList.addAll(user.getPosts());
		}
		return postsList.stream().collect(Collectors.toList());
	}

}