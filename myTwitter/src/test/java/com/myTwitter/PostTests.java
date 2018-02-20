package com.myTwitter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.myTwitter.model.Post;

public class PostTests {

	@Test
	public void maxLengthForMessageThatIsLongerThanMaxTest() {

		Post post = new Post(
				"This message in longer than 140 signs. This message in longer than 140 signs. This message in longer than 140 signs. This message in longer than 140 signs.");

		assertEquals(140, post.getMessage().length());
	}
	
	@Test
	public void maxLengthForProperMessage() {

		String msg = new String("This is short message");
		Post post = new Post("This is short message");

		assertEquals(msg.length(), post.getMessage().length());
	}

}
