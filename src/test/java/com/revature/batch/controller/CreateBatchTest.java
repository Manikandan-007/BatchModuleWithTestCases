package com.revature.batch.controller;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.batch.dto.BatchDataDto;
import com.revature.batch.dto.BatchListDto;
import com.revature.batch.dto.CoTrainerListDto;
import com.revature.batch.dto.RemovedCoTrainerAndDays;
import com.revature.batch.model.ActiveDay;
import com.revature.batch.model.Batch;
import com.revature.batch.model.BatchTrainee;
import com.revature.batch.model.Candidate;
import com.revature.batch.model.CoTrainer;
import com.revature.batch.model.Trainer;
import com.revature.batch.service.BatchService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CreateBatchTest {

	@Rule
	  public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
	
	@InjectMocks
	private CreateBatch createBatchController;
	
	@Mock
	private BatchService batchService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(createBatchController)
				.apply(documentationConfiguration(this.restDocumentation))
				.build();
	}
	
	@Test
	public void testBatchList() throws Exception {
		
		List<BatchListDto> batchList = new ArrayList<BatchListDto>();
		//batchListDto
		BatchListDto batchListDto = new BatchListDto();
		batchListDto.setId(2);
		batchListDto.setName("Ramesh");
		batchListDto.setTrainerId(2);
		
		Trainer trainer = new Trainer();
		trainer.setName("Ramesh");
		trainer.setEmail("r@gmail.com");
		trainer.setId(2);
		
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
		
		//batchListDto1
		BatchListDto batchListDto1 = new BatchListDto();
		batchListDto1.setId(1);
		batchListDto1.setName("Mani");
		batchListDto1.setTrainerId(1);
		
		Trainer trainer1 = new Trainer();
		trainer1.setName("Mani");
		trainer1.setEmail("m@gmail.com");
		trainer1.setId(1);
		
		batchListDto1.setTrainer(trainer1);
		
		List<CoTrainerListDto> coTrainerList1 = new ArrayList<CoTrainerListDto>();
		CoTrainerListDto coTrainerListDto1 = new CoTrainerListDto();
		coTrainerListDto1.setBatchId(1);
		coTrainerListDto1.setTrainerId(1);
		coTrainerList1.add(coTrainerListDto1);
		
		batchListDto1.setCoTrainerList(coTrainerList1);
		
		List<BatchTrainee> batchTraineeList1 = new ArrayList<BatchTrainee>();
		BatchTrainee batchTrainee1 = new BatchTrainee();
		batchTrainee1.setBatchId(2);
		batchTrainee1.setCandidateId(2);
		Candidate candidate1 = new Candidate();
		candidate1.setEmail("user2@gmail.com");
		candidate1.setName("user2");
		batchTrainee1.setCandidate(candidate1);
		batchTraineeList1.add(batchTrainee1);
		
		batchListDto1.setBatchTraineeList(batchTraineeList1);
		batchList.add(batchListDto1);
		
		when(batchService.batchListService()).thenReturn(batchList);
		
		mockMvc.perform(get("/batch/batch_list")
					.contentType("application/json"))
					.andExpect(status().isOk())
					.andDo(print())
					.andDo(document("CreateBatch/batch_list", preprocessRequest(prettyPrint()),
				            preprocessResponse(prettyPrint())));		
	}
	
	@Test
	public void testBatchCreation() throws Exception {
		
		BatchDataDto batchDataDto = new BatchDataDto(null, null, null);
		Batch batch = new Batch();
		batch.setName("Batch-2019");
		batch.setActiveHrs(8);
		batch.setTrainerId(1);
		
		batchDataDto.setBatch(batch);
		
		List<ActiveDay> dayList = new ArrayList<ActiveDay>();
		ActiveDay activeDay = new ActiveDay();
		activeDay.setDayId(1);
		dayList.add(activeDay);
		
		ActiveDay activeDay1 = new ActiveDay();
		activeDay1.setDayId(8);
		dayList.add(activeDay1);
		
		batchDataDto.setDayList(dayList);
		
		List<CoTrainer> coTrainerList = new ArrayList<CoTrainer>();
		CoTrainer coTrainer = new CoTrainer();
		coTrainer.setTrainerId(1);
		coTrainerList.add(coTrainer);
		
		CoTrainer coTrainer1 = new CoTrainer();
		coTrainer1.setTrainerId(2);
		coTrainerList.add(coTrainer1);
		
		batchDataDto.setCoTrainer(coTrainerList);
		
		RemovedCoTrainerAndDays removedCoTrainerAndDays = new RemovedCoTrainerAndDays(); 
		List<CoTrainer> coTrainerListRemoved = new ArrayList<CoTrainer>();
		CoTrainer coTrainerRemoved = new CoTrainer();
		coTrainerRemoved.setTrainerId(1);
		coTrainerListRemoved.add(coTrainerRemoved);
		
		List<ActiveDay> dayListRemoved = new ArrayList<ActiveDay>();
		ActiveDay activeDayRemoved = new ActiveDay();
		activeDayRemoved.setDayId(8);
		dayListRemoved.add(activeDayRemoved);
		
		removedCoTrainerAndDays.setCoTrainerList(coTrainerListRemoved);
		removedCoTrainerAndDays.setDayList(dayListRemoved);
		
		when(batchService.batchCreationService(batchDataDto)).thenReturn(removedCoTrainerAndDays);
		
		String userJson = new ObjectMapper().writeValueAsString(batchDataDto);
		mockMvc.perform(post("/batch/create_new")
					.contentType("application/json").content(userJson)
					.characterEncoding("utf-8"))
					.andDo(print())
					.andDo(document("CreateBatch/create_new", preprocessRequest(prettyPrint()),
				            preprocessResponse(prettyPrint())));		
	}

}
