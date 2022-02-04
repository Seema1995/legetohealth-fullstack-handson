package com.legatohealth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.legatohealth.beans.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void storeUser(User user) {
		String query = "insert into users (name, password, age) values(?, ?, ?)";
		jdbc.update(query,user.getName(),user.getPassword(),user.getAge());
	}

	@Override
	public void updateUser(int id, User user) {
		String query = "update users set name=? , password=? , age=? where id= ?";
		jdbc.update(query, user.getName(),user.getPassword(),user.getAge(),id);
	}

	@Override
	public void deleteUser(int userId) {
		String query = "delete from users where id= ?";
		jdbc.update(query,userId);
	}

	@Override
	public User fetchUser(int userId) {
		String query = "select * from users where id=?";        
		 User user2 = jdbc.queryForObject(query, (rs,index) ->{
			 User u = new User();
             u.setId(rs.getInt("id"));
             u.setAge(rs.getInt("age"));
             u.setPassword(rs.getString("password"));
             u.setName(rs.getString("name"));
             return u;
		 }, userId);
		 return user2;
		
	}

	@Override
	public List<User> fetchAllUsers() {
		String sql = "select * from users";
        
        return jdbc.query(sql,(rs,index)->{
        	User u = new User();
            u.setId(rs.getInt("id"));
            u.setAge(rs.getInt("age"));
            u.setPassword(rs.getString("password"));
            u.setName(rs.getString("name"));
            return u;
        });

	}

}
