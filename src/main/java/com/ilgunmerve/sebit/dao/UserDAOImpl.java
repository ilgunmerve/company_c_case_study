package com.ilgunmerve.sebit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.ilgunmerve.sebit.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(User user) {
        return jdbcTemplate.update( "insert into user (name, surname, salary) values(?,?,?)", user.getName(), user.getSurname(), user.getSalary());
	}
	
	@Override
	public int update(User user) {
        return jdbcTemplate.update(
                "update user set name = ?, surname = ?, salary = ? where userId = ?",
                user.getName(), user.getSurname(), user.getSalary(), user.getUserId());
	}

	@Override
	public int delete(int userId) {
		return jdbcTemplate.update( "delete user where userId = ?", userId);
	}

	@Override
	public Optional<User> get(int userId)  {
        return jdbcTemplate.queryForObject(
                "select * from user where userId = ?",
                new Object[]{userId},
                (rs, rowNum) ->
                        Optional.of(new User( rs.getInt("userId"), rs.getString("name"), rs.getString("surname"), rs.getInt("salary")))
        );
    }

	@Override
	public List<User> listUser()  {
        return jdbcTemplate.query(
                "select * from user",
                (rs, rowNum) -> new User(rs.getInt("userId"), rs.getString("name"), rs.getString("surname"), rs.getInt("salary"))
        );
    }

}
