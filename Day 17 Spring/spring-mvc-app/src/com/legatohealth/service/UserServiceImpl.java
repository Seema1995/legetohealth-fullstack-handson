package com.legatohealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legatohealth.beans.User;
import com.legatohealth.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	@Override
	public void storeUser(User user) {
		userdao.storeUser(user);
	}

	@Override
	public User fetchUser(int userId) {
		return userdao.fetchUser(userId);
	}

	@Override
	public List<User> fetchAllUsers() {
		return userdao.fetchAllUsers();
	}

	public void updateName(int id, String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		userdao.updateUser(id, user);
	}
	
	public void updatePassword(int id, String password) {
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		userdao.updateUser(id, user);
	}
	
	public void updateAge(int id, int age) {
		User user = new User();
		user.setId(id);
		user.setAge(age);
		userdao.updateUser(id, user);
	}

	@Override
	public void deleteUser(int userId) {
		userdao.deleteUser(userId);
	}

}
