package com.baraka.social.dataservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.baraka.social.dao.User;

@Component
public class UserDataService {

	private static List<User> users = new ArrayList<User>();
	private static int userCount = 0;
	static {
		users.add(new User(++userCount, "User1", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "User1", LocalDate.now().minusYears(29)));
		users.add(new User(++userCount, "User1", LocalDate.now().minusYears(28)));
	}

	public List<User> getUsers() {
		return users;
	}

	public User getUser(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}

	public void save(User user) {
		user.setId(++userCount);
		users.add(user);
	}
}
