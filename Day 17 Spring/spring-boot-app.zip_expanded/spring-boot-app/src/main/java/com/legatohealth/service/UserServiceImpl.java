package com.legatohealth.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.legatohealth.beans.User;
import com.legatohealth.dao.UserDao;
import com.legatohealth.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	@Transactional
	public User store(User user) throws UserNotFoundException {
		User userCreated = dao.save(user);
		return userCreated;
	}

	@Override
	public User fetchUser(int id) throws UserNotFoundException {
		Optional<User> optional = dao.findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			return user;
		}else {
			throw new UserNotFoundException("User with id "+id+" not found");
		}
	}

	@Override
	@Transactional
	public void deleteUser(int id) throws UserNotFoundException {
		User user = fetchUser(id);
		dao.delete(user);
	}

	@Override
	@Transactional
	public void updatePassword(int id, String password) throws UserNotFoundException {
		User user = fetchUser(id);
		user.setPassword(password);
		dao.save(user);
	}

	@Override
	@Transactional
	public void updateName(int id, String name) throws UserNotFoundException {
		User user = fetchUser(id);
		user.setName(name);
		dao.save(user);
	}

	@Override
	@Transactional
	public void updateAge(int id, int age) throws UserNotFoundException {
		User user = fetchUser(id);
		user.setAge(age);
		dao.save(user);
	}

	@Override
	public List<User> fetchAllUsers() {
		List<User> users = dao.findAll();
		return users;
	}

}
