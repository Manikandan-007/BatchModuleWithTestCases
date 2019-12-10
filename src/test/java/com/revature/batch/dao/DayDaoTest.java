package com.revature.batch.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.batch.model.ActiveDay;

@RunWith(MockitoJUnitRunner.class)
public class DayDaoTest {

	@InjectMocks
	public DayDaoImpl dayDao;
	
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
