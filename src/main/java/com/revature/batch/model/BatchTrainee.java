package com.revature.batch.model;

import java.sql.Timestamp;

public class BatchTrainee {
	private int id;
	private int batchId;
	private int candidateId;
	private int activeStatus;
	private Timestamp added_on;
	
	private Candidate candidate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Timestamp getAdded_on() {
		return added_on;
	}

	public void setAdded_on(Timestamp added_on) {
		this.added_on = added_on;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
}
