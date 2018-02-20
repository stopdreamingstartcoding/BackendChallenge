package com.myTwitter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.myTwitter.model.Post;
import com.myTwitter.model.User;
import com.myTwitter.service.DataBaseService;
import java.time.LocalDateTime;

@RestController
public class MyTweeterController {

	@Autowired
	private DataBaseService dataBaseService;

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public List<Post> posts() {
		return dataBaseService.getPostsMessageDsc();
	}

	@RequestMapping(value = "/postsFromFollowedByMe", method = RequestMethod.GET)
	public List<Post> postsFromFollowedByMe() {
		return dataBaseService.getLoggedUser().getPostFromFollowedByMeUsers();
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<String> users() {
		return dataBaseService.getUsers();
	}

	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public ResponseEntity<?> addPost(@RequestBody Post post) {

		final String canNotCreate = new String("Can not create message.");

		if (post == null) {
			return new ResponseEntity<String>(canNotCreate, HttpStatus.EXPECTATION_FAILED);
		} else {

			if (post.getMessage() == null) {
				return new ResponseEntity<String>(canNotCreate, HttpStatus.EXPECTATION_FAILED);
			}
			if (post.getCreatedTime() == null) {
				post.setCreated(LocalDateTime.now());
			}
			dataBaseService.getLoggedUser().getPosts().add(post);
			return new ResponseEntity<Post>(post, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/follow", method = RequestMethod.POST)
	public ResponseEntity<?> follow(@RequestBody User user) {

		final String canNotFind = new String("Can not find user.");

		if (user == null) {
			return new ResponseEntity<String>(canNotFind, HttpStatus.NOT_FOUND);
		} else {

			if (user.getName() == null) {
				return new ResponseEntity<String>(canNotFind, HttpStatus.NOT_FOUND);
			}
			if (dataBaseService.findUserByName(user.getName()).isPresent()) {

				dataBaseService.getLoggedUser().getFollowedByMeUsers()
						.add(dataBaseService.findUserByName(user.getName()).get());
				return new ResponseEntity<String>("OK", HttpStatus.CREATED);
			}
			return new ResponseEntity<String>(canNotFind, HttpStatus.EXPECTATION_FAILED);
		}

	}

}