package com.revature.batch.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.revature.batch.model.ActiveDay;

public class DayDaoTest {

	private DayDaoImpl dayDao = new DayDaoImpl();
	
	@Test
	public void testCheckIsDayPresent() {
		ActiveDay activeDay = new ActiveDay();
		activeDay.setDayId(1);
		boolean isDayPresent = dayDao.checkIsDayPresent(activeDay);
		
		assertEquals(true, isDayPresent);
	}
	
	@Test
	public void testCheckIsDayPresentInValid() {
		ActiveDay activeDay = new ActiveDay();
		activeDay.setDayId(8);
		boolean isDayPresent = dayDao.checkIsDayPresent(activeDay);
		
		assertEquals(false, isDayPresent);
	}


}
