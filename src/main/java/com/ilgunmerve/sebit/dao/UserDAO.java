package com.ilgunmerve.sebit.dao;

import java.util.List;
import java.util.Optional;

import com.ilgunmerve.sebit.model.User;

public interface UserDAO {

	int save(User user);
	int update(User user);	
	int delete(int userId);	
	Optional<User> get(int userId);
	List<User> listUser();

}
