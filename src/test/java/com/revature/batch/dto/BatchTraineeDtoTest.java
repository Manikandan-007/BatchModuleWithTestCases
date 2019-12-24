package com.revature.batch.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class BatchTraineeDtoTest {

	@Test
	public void testBatchTraineeDto() {
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setId(1);
		batchTraineeDto.setUserMail("m@gmail.com");
		batchTraineeDto.getBatchId();
		batchTraineeDto.getId();
		batchTraineeDto.getUserMail();
		
		assertNotNull(batchTraineeDto);
	}

}
