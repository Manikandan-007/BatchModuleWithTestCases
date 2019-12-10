package com.revature.batch.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.model.Candidate;

@RunWith(MockitoJUnitRunner.class)
class CandidateDaoTest {

	@InjectMocks
	private CandidateDaoImpl CandidateDao;
	
	@Test
	public void testGetCandidate() {
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		
		List<Candidate> isCandidateAvailable = CandidateDao.getCandidate(batchTraineeList);
		
		assertNull(isCandidateAvailable);
	}
	
//	@Test
//	public void testGetCandidateInvalid() {
//		List<BatchTraineeDto> batchTraineeList = null;
//		List<Candidate> isCandidateAvailable = CandidateDao.getCandidate(batchTraineeList);
//		
//	}

}
