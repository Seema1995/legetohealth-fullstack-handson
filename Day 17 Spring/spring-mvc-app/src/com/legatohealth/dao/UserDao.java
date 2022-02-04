package com.legatohealth.dao;

import java.util.List;

import com.legatohealth.beans.User;

public interface UserDao {
	
	public void storeUser(User user);
	public User fetchUser(int userId);
	public List<User> fetchAllUsers();
	public void updateUser(int id,User user);
	public void deleteUser(int userId);
	
}
