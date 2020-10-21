package com.ilgunmerve.sebit.dao;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ilgunmerve.sebit.model.Project;

public class ProjectDAOImpl implements ProjectDAO {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Project project) {
		jdbcTemplate.update("insert into project (projectName) values (?)", project.getProjectName());
	}

	@Override
	public Optional<Project> get(int projectId) {
        return jdbcTemplate.queryForObject(
                "select * from project where id = ?",
                new Object[]{projectId},
                (rs, rowNum) -> Optional.of(new Project(rs.getInt("projectId"), rs.getString("projectName")))
        );
	}

	@Override
	public List<Project> listProject(){
		return jdbcTemplate.query(
				"select * from project",
				(rs, rowNum) ->
				new Project( rs.getInt("projectId"), rs.getString("projectName")));
    }

}
