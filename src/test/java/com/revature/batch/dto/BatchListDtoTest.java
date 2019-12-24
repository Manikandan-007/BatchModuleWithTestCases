package com.revature.batch.dto;

import static org.junit.Assert.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.batch.model.BatchTrainee;
import com.revature.batch.model.Trainer;

public class BatchListDtoTest {

	@Test
	public void testBatchListDto() {

		BatchListDto batchListDto = new BatchListDto();
		
		batchListDto.setActiveHrs(8);
		Timestamp endDate = new Timestamp(2019-12-31);
		batchListDto.setEndDate(endDate);
		batchListDto.setName("Batch1");
		Timestamp startDate = new Timestamp(2019-12-12);
		batchListDto.setStartDate(startDate);
		Time startTime = new Time(10-30-30);
		batchListDto.setStartTime(startTime);
		batchListDto.setTrainerId(1);
		Timestamp createdOn = new Timestamp(2019-12-12);
		batchListDto.setCreatedOn(createdOn);
		batchListDto.setId(1);
		
		Trainer trainer = new Trainer();
		batchListDto.setTrainer(trainer);
		
		List<CoTrainerListDto> coTrainerList = new ArrayList<CoTrainerListDto>();
		batchListDto.setCoTrainerList(coTrainerList);
		
		List<BatchTrainee> batchTraineeList = new ArrayList<BatchTrainee>();
		batchListDto.setBatchTraineeList(batchTraineeList);
		
		batchListDto.getActiveHrs();
		batchListDto.getBatchTraineeList();
		batchListDto.getCoTrainerList();
		batchListDto.getCreatedOn();
		batchListDto.getEndDate();
		batchListDto.getId();
		batchListDto.getName();
		batchListDto.getStartDate();
		batchListDto.getStartTime();
		batchListDto.getTrainer();
		batchListDto.getTrainerId();
		
		assertNotNull(batchListDto);
	}

}
