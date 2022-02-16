package com.legatohealth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legatohealth.beans.User;

public interface UserDao extends JpaRepository<User, Integer> {

}

/* There is no need to implement UserDao since it would be implemented by Jpa Repository
 * It automatically uses Generic types User which gets mapped to users table and take Integer as primary key
 *
*/