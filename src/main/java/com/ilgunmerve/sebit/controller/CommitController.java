package com.ilgunmerve.sebit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ilgunmerve.sebit.dao.CommitDAO;
import com.ilgunmerve.sebit.model.Commit;
import com.ilgunmerve.sebit.model.CommitFilter;
import com.ilgunmerve.sebit.model.CommitSummary;

@RestController
public class CommitController {
	
	@Autowired
	CommitDAO commitDAO;
		
    @PostMapping("/commit")
    void newCommit(@RequestBody CommitSummary newCommit) {
    	ArrayList<Commit> commitList = new ArrayList<Commit> ();
    	
    	HashMap<Integer, Integer> userCommitCnt = new HashMap<Integer, Integer>();
    	
    	int[] userIds = newCommit.getUserList();
    	
    	for(int userId: userIds) {
    		userCommitCnt.put(userId, userCommitCnt.getOrDefault(userId, 0) + 1);
    	}
    	
        Iterator<Entry<Integer, Integer>> it = userCommitCnt.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Integer> pair = (Entry<Integer, Integer>)it.next();
            Commit commit = new Commit(pair.getKey(), newCommit.getProjectId(), newCommit.getDay(),pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
            commitList.add(commit);
        }
        commitDAO.saveCommitList(commitList);        	
    }
    
    @PostMapping("/commitFilter")
    void commitFilter(@RequestBody CommitFilter commitFilter) {
    	long diffInMillies = commitFilter.getEndDate().getTime() - commitFilter.getStartDate().getTime();
    	if(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) < 4)
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Short time interval");
    }
}
