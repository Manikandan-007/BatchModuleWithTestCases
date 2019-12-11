package com.revature.batch.model;

import org.junit.jupiter.api.Test;

class DayTest {

	@Test
	void testDay() {
		Day day = new Day();
		day.setDay("Sunday");
		day.setId(1);
		
		day.getDay();
		day.getId();
	}

}
