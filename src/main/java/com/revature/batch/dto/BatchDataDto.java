package com.revature.batch.dto;

import java.util.List;

import com.revature.batch.model.ActiveDay;
import com.revature.batch.model.Batch;
import com.revature.batch.model.CoTrainer;

public class BatchDataDto {

	private Batch batch;
	
	private List<ActiveDay> dayList;
	
	private List<CoTrainer> coTrainer;
	
	public BatchDataDto(Batch batch, List<ActiveDay> dayList, List<CoTrainer> coTrainer) {
		super();
		this.batch = batch;
		this.dayList = dayList;
		this.coTrainer = coTrainer;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public List<ActiveDay> getDayList() {
		return dayList;
	}

	public void setDayList(List<ActiveDay> dayList) {
		this.dayList = dayList;
	}

	public List<CoTrainer> getCoTrainer() {
		return coTrainer;
	}

	public void setCoTrainer(List<CoTrainer> coTrainer) {
		this.coTrainer = coTrainer;
	}
	
}


