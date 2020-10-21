package com.ilgunmerve.sebit.dao;

import java.util.List;
import java.util.Optional;

import com.ilgunmerve.sebit.model.User;

public interface UserDAO {

	public int save(User user);
	
	public int update(User user);
	
	public int delete(int userId);
	
	public Optional<User> get(int userId);

	public List<User> listUser();

}
