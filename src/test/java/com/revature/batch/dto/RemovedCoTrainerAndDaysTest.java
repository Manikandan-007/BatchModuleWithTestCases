package com.revature.batch.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.batch.model.ActiveDay;
import com.revature.batch.model.CoTrainer;

public class RemovedCoTrainerAndDaysTest {

	@Test
	public void testRemovedCoTrainerAndDays() {
		RemovedCoTrainerAndDays removedCoTrainerAndDays = new RemovedCoTrainerAndDays();
		List<CoTrainer> coTrainerList = new ArrayList<CoTrainer>();
		removedCoTrainerAndDays.setCoTrainerList(coTrainerList);
		List<ActiveDay> dayList = new ArrayList<ActiveDay>();
		removedCoTrainerAndDays.setDayList(dayList);
		
		removedCoTrainerAndDays.getCoTrainerList();
		removedCoTrainerAndDays.getDayList();
		
		assertNotNull(removedCoTrainerAndDays);
	}

}
