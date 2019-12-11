package com.revature.batch.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ActiveDayTest {

	@Test
	public void testActiveDay() {
		
		ActiveDay activeDay = new ActiveDay();
		activeDay.setDayId(1);
		activeDay.getDayId();
		
		assertNotNull(activeDay);
	}

}
