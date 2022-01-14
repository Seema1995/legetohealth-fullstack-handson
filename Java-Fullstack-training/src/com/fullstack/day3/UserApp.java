package com.fullstack.day3;

import java.util.Scanner;

public class UserApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserServiceFactory usf = new UserServiceFactory();
		User user = usf.getUser();
		user.setId(101);
		user.setUserName("Seema");
		user.setAge(21);

		User user2 = usf.getUser();
		user2.setId(104);
		user2.setUserName("Sanket");
		user2.setAge(24);

		User user3 = usf.getUser();
		user3.setId(119);
		user3.setUserName("Rohan");
		user3.setAge(27);

		UserService us = new UserService();
		User[] usersList = new User[3];
		usersList[0] = user;
		usersList[1] = user2;
		usersList[2] = user3;

		us.addUser(usersList);

		System.out.println("Added 3 users successfully!!!");
		System.out.println("Enter user id you want to search : ");

		int id = sc.nextInt();

		System.out.println("Searching ...");

		try {
			us.searchUser(id, usersList);
		} catch (UserNotFoundException ex) {
			System.out.println("User Not found!");
		} finally {
			sc.close();
		}
	}
}
