package com.myTwitter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.myTwitter.model.Post;
import com.myTwitter.model.User;

public class UserTests {

	@Test
	public void getPostFromFollowedByMeUsersTest() {

		User user = new User("UserName");

		User bob = new User("Bob");
		bob.getPosts().add(new Post("This is magic post from Bob"));
		bob.getPosts().add(new Post("This is super post from Bob"));
		bob.getPosts().add(new Post("This is awesome post from Bob"));
		bob.getPosts().add(new Post("This is special post from Bob"));
		user.addFollower(bob);

		assertEquals(bob.getPosts().size(), user.getPostFromFollowedByMeUsers().size());
	}
	
	@Test
	public void getPostFromFollowedByMeUsersWhenNotAdedTest() {

		User user = new User("UserName");
		assertEquals(0, user.getPostFromFollowedByMeUsers().size());
	}

}
