package com.revature.batch.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.batch.dao.BatchImplDao;
import com.revature.batch.dao.BatchTraineeDaoImpl;
import com.revature.batch.dto.BatchListDto;
import com.revature.batch.dto.CoTrainerListDto;
import com.revature.batch.exception.DBException;
import com.revature.batch.exception.ServiceException;
import com.revature.batch.model.BatchTrainee;
import com.revature.batch.model.Candidate;
import com.revature.batch.model.Trainer;
import com.revature.batch.validator.BatchValidator;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BatchServiceTest {

	@InjectMocks
	private BatchService batchService;
	
	@Mock
	private BatchImplDao batchImplDao;
	
	@Mock
	private BatchValidator batchValidator;
	
	@Mock
	private BatchTraineeDaoImpl batchTraineeDaoImpl;
	
	@Test
	public void testBatchListServiceValid(){
		
		List<BatchListDto> batchList = new ArrayList<BatchListDto>();
		BatchListDto batchListDto = new BatchListDto();
		batchListDto.setId(1);
		batchListDto.setName("Ramesh");
		batchListDto.setTrainerId(1);
		
		Trainer trainer = new Trainer();
		trainer.setEmail("m@gmail.com");
		trainer.setId(1);
		
		batchListDto.setTrainer(trainer);
		
		List<CoTrainerListDto> coTrainerList = new ArrayList<CoTrainerListDto>();
		CoTrainerListDto coTrainerListDto = new CoTrainerListDto();
		coTrainerListDto.setBatchId(1);
		coTrainerListDto.setTrainerId(1);
		coTrainerList.add(coTrainerListDto);
		
		batchListDto.setCoTrainerList(coTrainerList);
		
		List<BatchTrainee> batchTraineeList = new ArrayList<BatchTrainee>();
		BatchTrainee batchTrainee = new BatchTrainee();
		batchTrainee.setBatchId(1);
		batchTrainee.setCandidateId(1);
		Candidate candidate = new Candidate();
		candidate.setEmail("user1@gmail.com");
		candidate.setName("user1");
		batchTrainee.setCandidate(candidate);
		batchTraineeList.add(batchTrainee);
		
		batchListDto.setBatchTraineeList(batchTraineeList);
		batchList.add(batchListDto);
		
		List<BatchListDto> BatchListDtoList = null;
		try {
			Mockito.when(batchImplDao.getBatchList()).thenReturn(batchList);
			
			when(batchImplDao.getCoTrainerList(batchListDto.getId())).thenReturn(coTrainerList);
			
			when(batchTraineeDaoImpl.getBatchTraineeList(batchListDto.getId())).thenReturn(batchTraineeList);
			
			BatchListDtoList = batchService.batchListService();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(BatchListDtoList);
	}
	
	@Test
	public void testBatchListServiceInValid (){
		
		BatchListDto batchListDto = new BatchListDto();
		batchListDto.setId(1);
		batchListDto.setName("Ramesh");
		batchListDto.setTrainerId(1);
		
		List<BatchListDto> BatchListDtoList = null;
		try {
			Mockito.when(batchImplDao.getBatchList()).thenThrow(DBException.class);
			
			when(batchImplDao.getCoTrainerList(batchListDto.getId())).thenThrow(DBException.class);
			
			when(batchTraineeDaoImpl.getBatchTraineeList(batchListDto.getId())).thenThrow(DBException.class);
			
			BatchListDtoList = batchService.batchListService();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertNull(BatchListDtoList);
	}

}
