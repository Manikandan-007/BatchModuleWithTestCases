package com.revature.batch.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.model.Candidate;

@RunWith(MockitoJUnitRunner.class)
class CandidateDaoTest {

	@Autowired
	private CandidateDaoImpl CandidateDao;
	
	@Test
	public void testGetCandidate() {
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		batchTraineeDto.setId(1);
		batchTraineeDto.setBatchId(1);
		batchTraineeList.add(batchTraineeDto);
		
		List<Candidate> isCandidateAvailable = CandidateDao.getCandidate(batchTraineeList);
		
		assertNotNull(isCandidateAvailable);
		
	}
	
//	@Test
//	public void testGetCandidateInvalid() {
//		List<BatchTraineeDto> batchTraineeList = null;
//		List<Candidate> isCandidateAvailable = CandidateDao.getCandidate(batchTraineeList);
//		
//	}

}
