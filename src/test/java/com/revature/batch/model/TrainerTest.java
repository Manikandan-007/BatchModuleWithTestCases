package com.revature.batch.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class TrainerTest {

	@Test
	void testTrainer() {
		Trainer trainer = new Trainer();
		trainer.setId(1);
		Date date = new Date(1);  
        Timestamp ts=new Timestamp(date.getTime());
		trainer.setCreated_on(ts);
		trainer.setEmail("m@gmail.com");
		trainer.setMobile(9876545673L);
		trainer.setName("Mani");
		
		trainer.getId();
		trainer.getCreated_on();
		trainer.getEmail();
		trainer.getMobile();
		trainer.getName();
	}

}
