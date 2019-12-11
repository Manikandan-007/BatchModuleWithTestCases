package com.revature.batch.model;

import org.junit.jupiter.api.Test;

class CoTrainerTest {

	@Test
	void testCoTrainer() {
		CoTrainer coTrainer = new CoTrainer();
		coTrainer.setTrainerId(1);
		coTrainer.getTrainerId();
	}

}
