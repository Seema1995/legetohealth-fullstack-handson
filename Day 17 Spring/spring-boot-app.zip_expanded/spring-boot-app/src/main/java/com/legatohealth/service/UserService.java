package com.legatohealth.service;

import java.util.List;

import com.legatohealth.beans.User;
import com.legatohealth.exceptions.UserNotFoundException;

public interface UserService {
	public User store(User user) throws UserNotFoundException;
	public User fetchUser(int id) throws UserNotFoundException;
	public void deleteUser(int id) throws UserNotFoundException;
	public void updatePassword(int id, String password) throws UserNotFoundException;
	public void updateName(int id, String name) throws UserNotFoundException ;
	public void updateAge(int id,int age) throws UserNotFoundException;
	public List<User> fetchAllUsers(); 
}
