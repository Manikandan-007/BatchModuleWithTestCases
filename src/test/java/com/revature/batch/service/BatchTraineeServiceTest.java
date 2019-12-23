package com.revature.batch.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.batch.dao.BatchTraineeDaoImpl;
import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.dto.BatchTraineeListDto;
import com.revature.batch.exception.DBException;
import com.revature.batch.exception.ServiceException;
import com.revature.batch.exception.ValidatorException;
import com.revature.batch.validator.BatchValidator;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BatchTraineeServiceTest {

	@InjectMocks
	private BatchTraineeService batchTraineeService;
	
	@Mock
	private BatchTraineeDaoImpl batchTraineeDaoImpl;
	
	@Mock
	private BatchValidator batchValidator;
	// Either can use @Before or @Runwith(MockitoJunitRunner.class)
//	@Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
	
	@Test
	public void testAddBatchTraineeService() throws DBException {
		boolean isInserted = false;
		BatchTraineeListDto batchTraineeListDto = new BatchTraineeListDto();
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		
		batchTraineeDto.setId(1);
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user1@gmail.com");
		
		batchTraineeList.add(batchTraineeDto);
		batchTraineeListDto.setBatchTraineeList(batchTraineeList);
		
		try {
			when(batchValidator.batchTraineeValidator(batchTraineeList)).thenReturn(batchTraineeList);
			when(batchTraineeDaoImpl.addTraineeIntoBatch(batchTraineeList)).thenReturn(true);
			
			isInserted = batchTraineeService.addBatchTraineeService(batchTraineeListDto);
		} catch (ValidatorException | ServiceException e) {
			e.printStackTrace();
		}
		assertTrue(isInserted);
	}

	@Test
	public void testAddBatchTraineeServiceInvalidInValidator() throws DBException {
		boolean isInserted = false;
		BatchTraineeListDto batchTraineeListDto = new BatchTraineeListDto();
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		
		batchTraineeDto.setId(1);
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail(null);
		
		batchTraineeList.add(batchTraineeDto);
		batchTraineeListDto.setBatchTraineeList(batchTraineeList);
		
		try {
			when(batchValidator.batchTraineeValidator(batchTraineeList)).thenThrow(ValidatorException.class);
			
			isInserted = batchTraineeService.addBatchTraineeService(batchTraineeListDto);
		} catch (ValidatorException | ServiceException e) {
			e.printStackTrace();
		}
		assertFalse(isInserted);
	}
	
	@Test
	public void testAddBatchTraineeServiceInvalidInDao() {
		boolean isInserted = false;
		BatchTraineeListDto batchTraineeListDto = new BatchTraineeListDto();
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		
		batchTraineeDto.setId(1);
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user1@gmail.com");
		
		batchTraineeList.add(batchTraineeDto);
		batchTraineeListDto.setBatchTraineeList(batchTraineeList);
		
		try {
			when(batchValidator.batchTraineeValidator(batchTraineeList)).thenReturn(batchTraineeList);
			when(batchTraineeDaoImpl.addTraineeIntoBatch(null)).thenThrow(DBException.class);
			
			isInserted = batchTraineeService.addBatchTraineeService(batchTraineeListDto);
		} catch (DBException | ValidatorException | ServiceException e) {
			e.printStackTrace();
		}
		assertFalse(isInserted);
	}
}
