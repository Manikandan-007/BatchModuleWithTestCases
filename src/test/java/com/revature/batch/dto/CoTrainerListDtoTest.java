package com.revature.batch.dto;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.batch.model.Trainer;

public class CoTrainerListDtoTest {

	@Test
	public void testCoTrainerListDto() {
		CoTrainerListDto coTrainerListDto = new CoTrainerListDto();
		coTrainerListDto.setBatchId(1);
		coTrainerListDto.setId(1);
		Trainer trainer = new Trainer();
		coTrainerListDto.setTrainer(trainer );
		coTrainerListDto.setTrainerId(1);
		
		coTrainerListDto.getBatchId();
		coTrainerListDto.getId();
		coTrainerListDto.getTrainer();
		coTrainerListDto.getTrainerId();
		
		assertNotNull(coTrainerListDto);
	}

}
