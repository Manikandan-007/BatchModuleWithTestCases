package com.revature.batch.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BatchTraineeListDtoTest {

	@Test
	public void testBatchTraineeListDto() {
		BatchTraineeListDto batchTraineeListDto = new BatchTraineeListDto();
		List<BatchTraineeDto> batchTraineeList =  new ArrayList<BatchTraineeDto>();
		batchTraineeListDto.setBatchTraineeList(batchTraineeList );
		
		batchTraineeListDto.getBatchTraineeList();
		
		assertNotNull(batchTraineeListDto);
	}

}
