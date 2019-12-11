package com.revature.batch.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DayTest {

	@Test
	public void testDay() {
		Day day = new Day();
		day.setDay("Sunday");
		day.setId(1);
		
		day.getDay();
		day.getId();
		
		assertNotNull(day);
	}

}
