package com.fullstack.day3;

public class UserService {

	User[] users = new User[5];

	public void addUser(User[] u) {
		for (int i = 0; i < u.length; i++)
			users[i] = u[i];
	}

	public void searchUser(int id, User userList[]) throws UserNotFoundException {
		boolean found = false;
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId() == id) {
				System.out.println("User found!!");
				System.out.println(userList[i].toString());
				found = true;
				break;
			}
		}
		if (!found)
			throw new UserNotFoundException();

	}

}
