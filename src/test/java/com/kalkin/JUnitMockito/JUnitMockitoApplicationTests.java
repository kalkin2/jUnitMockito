package com.kalkin.JUnitMockito;

import com.kalkin.JUnitMockito.api.dao.UserRepository;
import com.kalkin.JUnitMockito.api.service.User;
import com.kalkin.JUnitMockito.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class JUnitMockitoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;


	@Test
	public void getUsersTest(){
		when(repository.findAll())
				.thenReturn(Stream.of(new User(376,"kalkin",31,"korea"),
						new User(52,"zard",35,"japan")).collect(Collectors.toList())
				);

		assertEquals(2,service.getUsers().size());
	}

	@Test
	public void getUserByAddressTest(){
		String address="seoul";
		when(repository.findByAddress(address))
				.thenReturn(
						Stream.of(new User(376,"kalkin",31,"korea"))
						.collect(Collectors.toList())
				);
		assertEquals(1,service.getUserByAddress(address).size());
	}


	@Test
	public void saveUserTest(){
		User user = new User(999,"sana",22,"seoul");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.addUser(user));

	}

	@Test
	public void deletUserTest(){
		User user = new User(999,"sana",22,"seoul");
		service.deleteUser(user);
		verify(repository,times(1)).delete(user);
	}


}
