package com.revature.batch.controller;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.dto.BatchTraineeListDto;
import com.revature.batch.service.BatchTraineeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BatchTraineeControllerTest {
	
	@Rule
	  public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
	
	@InjectMocks
	private BatchTraineeController batchTraineeController;
	
	@Mock
	private BatchTraineeService batchTraineeService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(batchTraineeController)
				.apply(documentationConfiguration(this.restDocumentation))
				.build();
		
	}
	@Test
	public void testBatchTraineeControllerValid() throws Exception {
		
		BatchTraineeListDto batchTraineeListDto = new BatchTraineeListDto();
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user1@gmail.com");
		batchTraineeList.add(batchTraineeDto);
		
		BatchTraineeDto batchTraineeDto1 = new BatchTraineeDto();
		batchTraineeDto1.setBatchId(1);
		batchTraineeDto1.setUserMail("user2@gmail.com");
		batchTraineeList.add(batchTraineeDto1);
		
		batchTraineeListDto.setBatchTraineeList(batchTraineeList);
		
		when(batchTraineeService.addBatchTraineeService(batchTraineeListDto)).thenReturn(true);
		
		String userJson = new ObjectMapper().writeValueAsString(batchTraineeListDto);
		mockMvc.perform(post("/batchTrainee/add_trainee")
					.contentType(MediaType.APPLICATION_JSON_UTF8).content(userJson))
					.andDo(print())
					.andDo(document("BatchTraineeController/add_trainee", preprocessRequest(prettyPrint()),
				            preprocessResponse(prettyPrint())));
		
	}

}
