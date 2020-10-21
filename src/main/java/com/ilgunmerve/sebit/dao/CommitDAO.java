package com.ilgunmerve.sebit.dao;

import java.util.List;

import com.ilgunmerve.sebit.model.Commit;

public interface CommitDAO {

	void saveCommitList(List<Commit> commitList);
	
}
