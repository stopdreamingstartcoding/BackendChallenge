package com.myTwitter;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import com.myTwitter.service.DataBaseService;

public class DataBaseServiceTests {

	private static DataBaseService dbs;

	@BeforeClass
	public static void generateTestDat() {
		dbs = new DataBaseService();
	}

	@Test
	public void getLoggedUserTest() {

		assertNotNull(dbs.getLoggedUser());
	}

	@Test
	public void getUsersTest() {

		assertEquals(3, dbs.getUsers().size());
	}

	@Test
	public void getPostsTest() {

		assertEquals(4, dbs.getPosts().size());
	}

	@Test
	public void findUserByName() {

		assertEquals("Bob", dbs.findUserByName("Bob").get().getName());
	}

}
