package com.revature.batch.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.dto.BatchTraineeListDto;
import com.revature.batch.service.BatchTraineeService;

@RunWith(MockitoJUnitRunner.class)
class BatchTraineeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private BatchTraineeController batchTraineeController;
	
	@Mock
	private BatchTraineeService batchTraineeService;
	
	@Test
	void testBatchTraineeControllerValid() throws Exception {
		
		BatchTraineeListDto batchTraineeListDto = new BatchTraineeListDto();
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		batchTraineeListDto.setBatchTraineeList(batchTraineeList);
		
		when(batchTraineeService.addBatchTraineeService((BatchTraineeListDto) any(BatchTraineeListDto.class))).thenReturn(true);
		
		String userJson = new ObjectMapper().writeValueAsString(batchTraineeListDto);
		
		 ResultActions mvcResult = this.mockMvc.perform(get("/batchTrainee/add_trainee"))
			      .andDo(print()).andExpect(status().isOk());
		
	}

}
