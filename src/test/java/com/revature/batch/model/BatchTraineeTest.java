package com.revature.batch.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class BatchTraineeTest {

	@Test
	void testBatchTrainee() {
		BatchTrainee batchTrainee = new BatchTrainee();
		batchTrainee.setCandidateId(1);
		batchTrainee.setActiveStatus(1);
		Date date = new Date(1);  
        Timestamp ts=new Timestamp(date.getTime());  
		batchTrainee.setAdded_on(ts);
		batchTrainee.setBatchId(1);
		
		Candidate candidate = new Candidate();
		batchTrainee.setCandidate(candidate);
		batchTrainee.setId(1);
		
		batchTrainee.getCandidateId();
		batchTrainee.getActiveStatus();
		batchTrainee.getAdded_on();
		batchTrainee.getBatchId();
		batchTrainee.getCandidate();
		batchTrainee.getId();
		
	}

}
