package com.revature.batch.validator;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.batch.dao.CandidateDaoImpl;
import com.revature.batch.dto.BatchDataDto;
import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.dto.RemovedCoTrainerAndDays;
import com.revature.batch.exception.ValidatorException;
import com.revature.batch.model.ActiveDay;
import com.revature.batch.model.Batch;
import com.revature.batch.model.CoTrainer;

public class BatchValidatorTest {
	
	@Test
	public void testBatchTraineeValidatorValid() {
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user1@gmail.com");
		batchTraineeList.add(batchTraineeDto);
		
		BatchTraineeDto batchTraineeDto1 = new BatchTraineeDto();
		batchTraineeDto1.setBatchId(1);
		batchTraineeDto1.setUserMail("user2@gmail.com");
		batchTraineeList.add(batchTraineeDto1);
		
		List<BatchTraineeDto> batchTraineeListTest = new ArrayList<BatchTraineeDto>();
		try {
			batchTraineeListTest = new BatchValidator(new CandidateDaoImpl()).batchTraineeValidator(batchTraineeList);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		assertEquals(batchTraineeList, batchTraineeListTest);
	}

	@Test
	public void testBatchTraineeValidatorInvalid() {
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user1@gmail.com");
		batchTraineeList.add(batchTraineeDto);
		
		BatchTraineeDto batchTraineeDto1 = new BatchTraineeDto();
		batchTraineeDto1.setBatchId(1);
		batchTraineeDto1.setUserMail("user5@gmail.com");
		batchTraineeList.add(batchTraineeDto1);
		
		List<BatchTraineeDto> batchTraineeListTest = new ArrayList<BatchTraineeDto>();
		try {
			batchTraineeListTest = new BatchValidator(new CandidateDaoImpl()).batchTraineeValidator(batchTraineeList);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		assertNotEquals(batchTraineeList, batchTraineeListTest);
	}
	
	@Test(expected = ValidatorException.class)
	public void testBatchTraineeValidatorInvalidAllTrainee() throws ValidatorException {
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user23@gmail.com");
		batchTraineeList.add(batchTraineeDto);
		
		BatchTraineeDto batchTraineeDto1 = new BatchTraineeDto();
		batchTraineeDto1.setBatchId(1);
		batchTraineeDto1.setUserMail("user12@gmail.com");
		batchTraineeList.add(batchTraineeDto1);
		
		new BatchValidator(new CandidateDaoImpl()).batchTraineeValidator(batchTraineeList);
		
	}
	
	@Test(expected = ValidatorException.class)
	public void testCreateBatchValidatorInValidBatchName() throws ValidatorException {
		BatchDataDto batchDataDto = new BatchDataDto(null, null, null);
		Batch batch = new Batch();
		batch.setName(null);
		batch.setActiveHrs(8);
		batch.setTrainerId(1);
		
		batchDataDto.setBatch(batch);
		
		List<ActiveDay> dayList = new ArrayList<ActiveDay>();
		ActiveDay activeDay = new ActiveDay();
		activeDay.setDayId(1);
		dayList.add(activeDay);
		
		batchDataDto.setDayList(dayList);
		
		List<CoTrainer> coTrainerList = new ArrayList<CoTrainer>();
		CoTrainer coTrainer = new CoTrainer();
		coTrainer.setTrainerId(1);
		coTrainerList.add(coTrainer);
		
		batchDataDto.setCoTrainer(coTrainerList);
		
		RemovedCoTrainerAndDays removedCoTrainerAndDays = new RemovedCoTrainerAndDays(); 
		removedCoTrainerAndDays.setCoTrainerList(coTrainerList);
		removedCoTrainerAndDays.setDayList(dayList);
		
			removedCoTrainerAndDays = new BatchValidator(new CandidateDaoImpl()).createBatchValidator(batchDataDto);
	}
	
	@Test(expected = ValidatorException.class)
	public void testCreateBatchValidatorInValidDate() throws ValidatorException {
		BatchDataDto batchDataDto = new BatchDataDto(null, null, null);
		Batch batch = new Batch();
		batch.setName("Batch1");
		batch.setActiveHrs(8);
		batch.setTrainerId(1);
		String str="2019-12-12";
		Date date=Date.valueOf(str);
		batch.setEndDate(date);
		
		String str1="2019-12-31";
		Date date1=Date.valueOf(str1);
		batch.setStartDate(date1);
		
		batchDataDto.setBatch(batch);
		
		List<ActiveDay> dayList = new ArrayList<ActiveDay>();
		ActiveDay activeDay = new ActiveDay();
		activeDay.setDayId(1);
		dayList.add(activeDay);
		
		batchDataDto.setDayList(dayList);
		
		List<CoTrainer> coTrainerList = new ArrayList<CoTrainer>();
		CoTrainer coTrainer = new CoTrainer();
		coTrainer.setTrainerId(1);
		coTrainerList.add(coTrainer);
		
		batchDataDto.setCoTrainer(coTrainerList);
		
		RemovedCoTrainerAndDays removedCoTrainerAndDays = new RemovedCoTrainerAndDays(); 
		removedCoTrainerAndDays.setCoTrainerList(coTrainerList);
		removedCoTrainerAndDays.setDayList(dayList);
		
			removedCoTrainerAndDays = new BatchValidator(new CandidateDaoImpl()).createBatchValidator(batchDataDto);
	}
	
	@Test(expected = ValidatorException.class)
	public void testCreateBatchValidatorInValidCoTrainers() throws ValidatorException {
		BatchDataDto batchDataDto = new BatchDataDto(null, null, null);
		Batch batch = new Batch();
		batch.setName("Batch1");
		batch.setActiveHrs(8);
		batch.setTrainerId(1);
		String str="2019-12-31";
		Date date=Date.valueOf(str);
		batch.setEndDate(date);
		
		String str1="2019-12-12";
		Date date1=Date.valueOf(str1);
		batch.setStartDate(date1);
		
		batchDataDto.setBatch(batch);
		
		List<ActiveDay> dayList = new ArrayList<ActiveDay>();
		ActiveDay activeDay = new ActiveDay();
		activeDay.setDayId(1);
		dayList.add(activeDay);
		
		batchDataDto.setDayList(dayList);
		
		List<CoTrainer> coTrainerList = new ArrayList<CoTrainer>();
		CoTrainer coTrainer = new CoTrainer();
		coTrainer.setTrainerId(1);
		coTrainerList.add(coTrainer);
		
		batchDataDto.setCoTrainer(coTrainerList);
		
		RemovedCoTrainerAndDays removedCoTrainerAndDays = new RemovedCoTrainerAndDays(); 
		removedCoTrainerAndDays.setCoTrainerList(coTrainerList);
		removedCoTrainerAndDays.setDayList(dayList);
		
			removedCoTrainerAndDays = new BatchValidator(new CandidateDaoImpl()).createBatchValidator(batchDataDto);
			
		assertNotNull(removedCoTrainerAndDays);
	}
}
