package com.revature.batch.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CoTrainerTest {

	@Test
	public void testCoTrainer() {
		CoTrainer coTrainer = new CoTrainer();
		coTrainer.setTrainerId(1);
		coTrainer.getTrainerId();
		
		assertNotNull(coTrainer);
	}

}
