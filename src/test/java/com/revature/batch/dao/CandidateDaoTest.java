package com.revature.batch.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.model.Candidate;

public class CandidateDaoTest {

	private CandidateDaoImpl CandidateDao = new CandidateDaoImpl();
	
	@Test
	public void testGetCandidate() {
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user1@gmail.com");
		
		batchTraineeList.add(batchTraineeDto);
		
		List<Candidate> isCandidateAvailable = CandidateDao.getCandidate(batchTraineeList);
		System.out.println(isCandidateAvailable);
		assertNotNull(isCandidateAvailable);
	}
	
	@Test
	public void testGetCandidateInvalid() {
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail(null);
		
		batchTraineeList.add(batchTraineeDto);
		
		List<Candidate> isCandidateAvailable = CandidateDao.getCandidate(batchTraineeList);
	}

}
