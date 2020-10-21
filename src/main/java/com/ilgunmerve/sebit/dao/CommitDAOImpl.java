package com.ilgunmerve.sebit.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ilgunmerve.sebit.model.Commit;

@Repository
public class CommitDAOImpl implements CommitDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CommitDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveCommitList(List<Commit> commitList) {
		jdbcTemplate.batchUpdate("insert into commit (projectId, userId, day, commitCount) values (?,?,?,?)", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, commitList.get(i).getProjectId());
				ps.setInt(2, commitList.get(i).getUserId());
				ps.setDate(3, commitList.get(i).getDay());
				ps.setInt(4, commitList.get(i).getCommitCount());
			}
			
			@Override
			public int getBatchSize() {
				return commitList.size();
			}
		});
	}
}