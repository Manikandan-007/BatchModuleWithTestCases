package com.revature.batch.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.batch.model.ActiveDay;
import com.revature.batch.model.Batch;
import com.revature.batch.model.CoTrainer;

public class BatchDataDtoTest {

	@Test
	public void testBatchDataDto() {
		
		Batch batch = new Batch();
		
		List<ActiveDay> activeDayList = new ArrayList<ActiveDay>();
		
		List<CoTrainer> coTrainerList =  new ArrayList<CoTrainer>();
		
		BatchDataDto BatchDataDto = new BatchDataDto(batch, activeDayList, coTrainerList);
		
		BatchDataDto.setBatch(batch);
		BatchDataDto.setCoTrainer(coTrainerList);
		BatchDataDto.setDayList(activeDayList);
		
		BatchDataDto.getBatch();
		BatchDataDto.getCoTrainer();
		BatchDataDto.getDayList();
		
		assertNotNull(BatchDataDto);
	}

}
