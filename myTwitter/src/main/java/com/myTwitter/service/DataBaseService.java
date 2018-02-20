package com.myTwitter.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.myTwitter.model.User;
import com.myTwitter.model.Post;

@Component
public class DataBaseService {

	private static List<User> users = new ArrayList<User>();

	static {

		User loggedUInser = new User("LoggedInUser");
		loggedUInser.getPosts().add(new Post("This is magic post"));
		loggedUInser.getPosts().add(new Post("This is super post"));
		loggedUInser.getPosts().add(new Post("This is awesome post"));
		loggedUInser.getPosts().add(new Post("This is special post"));
		users.add(loggedUInser);

		User alice = new User("Alice");
		alice.getPosts().add(new Post("This is magic post from Alice"));
		alice.getPosts().add(new Post("This is super post from Alice"));
		alice.getPosts().add(new Post("This is awesome post from Alice"));
		alice.getPosts().add(new Post("This is special post from Alice"));
		users.add(alice);

		User bob = new User("Bob");
		bob.getPosts().add(new Post("This is magic post from Bob"));
		bob.getPosts().add(new Post("This is super post from Bob"));
		bob.getPosts().add(new Post("This is awesome post from Bob"));
		bob.getPosts().add(new Post("This is special post from Bob"));
		users.add(bob);

		loggedUInser.addFollower(alice);
	}

	public User getLoggedUser() {
		return users.get(0);
	}

	public List<String> getUsers() {
		return users.stream().map(User::getName).collect(Collectors.toList());
	}

	public Optional<User> findUserByName(String name) {
		return users.stream().filter(user -> user.getName().equals(name)).findFirst();
	}
	
	public List<Post> getPosts() {
		return this.getLoggedUser().getPosts();
	}

	public List<Post> getPostsMessageDsc() {
		return this.getLoggedUser().getPosts().stream().sorted(Comparator.comparing(Post::getCreatedTime).reversed())
				.collect(Collectors.toList());
	}

}
