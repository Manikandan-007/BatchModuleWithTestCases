package com.revature.batch.model;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Test;

public class CandidateTest {

	@Test
	public void testCandidate() {
		Candidate candidate = new Candidate();
		Date date = new Date(1);  
        Timestamp ts=new Timestamp(date.getTime());  
		candidate.setCreated_on(ts);
		candidate.setEmail("user1@gmail.com");
		candidate.setId(1);
		candidate.setMobile(98765432345L);
		candidate.setName("user1");
		
		candidate.getCreated_on();
		candidate.getEmail();
		candidate.getId();
		candidate.getMobile();
		candidate.getName();
		
		assertNotNull(candidate);
		
	}

}
