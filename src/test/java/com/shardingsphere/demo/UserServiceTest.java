package com.shardingsphere.demo;

import com.shardingsphere.demo.entity.User;
import com.shardingsphere.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testProcessUsers() throws Exception {
		List<User>  x=userService.getUsers();
		System.out.println();
	}
}
