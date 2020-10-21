package com.ilgunmerve.sebit.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ilgunmerve.sebit.model.User;

@Repository
public class ProjectUserDAOImpl implements ProjectUserDAO {

    @Autowired
	private JdbcTemplate jdbcTemplate;

	public ProjectUserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int assignUser(int projectId, int userId) {
		// TODO Error handling when project_user already exists
		return jdbcTemplate.update("insert into project_user (projectId, userId) values (?, ?)", projectId, userId );
	}

	@Override
	public int delete(int projectId, int userId) {
		// TODO Error handling when project_user does not exist
		return jdbcTemplate.update( "delete project_user where projectId = ? and userId = ?", projectId, userId);
	}

	@Override
	public List<User> listUsersbyProject(int projectId) {
		return jdbcTemplate.query(
                "select user.* from project_user "
                + "JOIN user "
                + "ON project_user.userId = user.userId "
                + "where project_user.projectId = ?" , new Object[]{projectId},
                (rs, rowNum) -> new User(rs.getInt("userId"), rs.getString("name"), rs.getString("surname"), rs.getInt("salary"))
        );
	}
	


}
