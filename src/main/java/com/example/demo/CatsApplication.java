package com.example.demo;

import com.example.demo.model.CatPost;
import com.example.demo.model.CatUser;
import com.example.demo.storage.catpost.InMemoryPostStorage;
import com.example.demo.storage.catuser.InMemoryUserStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatsApplication.class, args);
	}

//	public static void main(String[] args) {
//		InMemoryUserStorage userStorage = new InMemoryUserStorage();
//		InMemoryPostStorage catPost = new InMemoryPostStorage();
//
//		CatUser firstUser = new CatUser("Thomas C. Andersun", "neoc@t");
//		CatUser secondUser = new CatUser("Альфред Хичкот", "sca_a_a_ry");
//		CatUser thirdUser = new CatUser("Basileus Felis F.", "under_wood");
//		CatUser updateUser = new CatUser(1,"Update Cat", "updated");
//
//		userStorage.createUser(firstUser);
//		userStorage.createUser(secondUser);
//		userStorage.createUser(thirdUser);
//
//		CatPost firstPost = new CatPost(firstUser.getId(), "description first post", "some url"
//				, "2026-01-25");
//
//		catPost.createPost(firstPost);
//		CatPost catPost1 = catPost.getPostById(firstPost.getId());
//
//
//		catPost.deletePostById(firstPost.getId());
//		List<CatPost> posts = catPost.getAllPosts();
//
//		for (CatPost post : posts) {
//			System.out.println(post);
//		}





//		userStorage.deleteUserById(3);

//		List<CatUser> users = userStorage.getAllUsers();
//		for (CatUser user : users) {
//			System.out.println(user);
//		}


//	}

}
