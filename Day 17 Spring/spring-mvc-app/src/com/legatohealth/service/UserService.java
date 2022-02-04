package com.legatohealth.service;

import java.util.List;

import com.legatohealth.beans.User;

public interface UserService {

	public void storeUser(User user);
	public User fetchUser(int userId);
	public List<User> fetchAllUsers();
	public void updateName(int id, String name);
	public void updatePassword(int id, String password);
	public void updateAge(int id, int age);
	public void deleteUser(int userId);
}
