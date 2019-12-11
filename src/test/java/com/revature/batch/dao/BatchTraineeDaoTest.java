package com.revature.batch.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.batch.dto.BatchTraineeDto;

@RunWith(MockitoJUnitRunner.class)
public class BatchTraineeDaoTest {

	@InjectMocks
	private BatchTraineeDaoImpl batchTraineeDao;
	
	@Test
	public void testAddTraineeIntoBatch() {
		
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		
		batchTraineeDto.setId(1);
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user1@gmail.com");
		
		batchTraineeList.add(batchTraineeDto);
		
		when(batchTraineeDao.addTraineeIntoBatch(batchTraineeList)).thenReturn(true);
		
		boolean isInserted = batchTraineeDao.addTraineeIntoBatch(batchTraineeList);
		assertTrue(isInserted);
		
	}

}
