package com.revature.batch.model;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;

public class BatchTest {

	@Test
	public void testBatchModel() {
		Batch batch = new Batch();
		
		batch.setActiveHrs(8);
		Date endDate = new Date(2019-12-31);
		batch.setEndDate(endDate);
		batch.setName("Batch1");
		Date startDate = new Date(2019-12-12);
		batch.setStartDate(startDate);
		Time startTime = new Time(10-30-30);
		batch.setStartTime(startTime);
		batch.setTrainerId(1);
		
		batch.getActiveHrs();
		batch.getEndDate();
		batch.getName();
		batch.getStartDate();
		batch.getStartTime();
		batch.getTrainerId();
		
		assertNotNull(batch);
	}

}
