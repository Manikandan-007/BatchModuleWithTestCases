package com.revature.batch.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.batch.dao.CandidateDaoImpl;
import com.revature.batch.dao.DayDaoImpl;
import com.revature.batch.dto.BatchDataDto;
import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.dto.RemovedCoTrainerAndDays;
import com.revature.batch.exception.ValidatorException;
import com.revature.batch.model.ActiveDay;
import com.revature.batch.model.Candidate;
import com.revature.batch.model.CoTrainer;

@Service
public class BatchValidator {

	@Autowired
	private CandidateDaoImpl candidateDaoImpl;
	
	@Autowired
	private DayDaoImpl dayDaoImpl;
	
	public RemovedCoTrainerAndDays createBatchValidator(BatchDataDto batchDataDto) throws ValidatorException {
		
		if (batchDataDto.getBatch().getName() == null || "".equals(batchDataDto.getBatch().getName().trim())) 
			throw new ValidatorException("Invalid Name, Please try again");
		
		//Date Validation (compare startDate and endDate)
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	      Date d1 = null;
	      Date d2 = null;
		try {
			d1 = sdformat.parse(""+batchDataDto.getBatch().getStartDate()+"");
			d2 = sdformat.parse(""+batchDataDto.getBatch().getEndDate()+"");
			if(d1.compareTo(d2) > 0) {
		         System.out.println("Date 1 occurs after Date 2");
		         throw new ValidatorException("Start date should not exceed End date..");
		      }
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		//Remove CoTrainer object which has been same TrainerId as in-charge from CoTrainerList 
	    List<CoTrainer> coTrainerList = batchDataDto.getCoTrainer();
	    List<CoTrainer> coTrainerListCopy = new ArrayList<CoTrainer>();
			for (CoTrainer coTrainer : coTrainerList) {
				if(batchDataDto.getBatch().getTrainerId() == coTrainer.getTrainerId()) {
					coTrainerListCopy.add(coTrainer);
				}
			}
			coTrainerList.removeAll(coTrainerListCopy);
		System.out.println(coTrainerList);
		
		//Remove Day object from DayList, if it is not there in days table 
		List<ActiveDay> dayList = batchDataDto.getDayList();
		List<ActiveDay> dayListCopy = new ArrayList<ActiveDay>();
		for (ActiveDay activeDay : dayList) {
			boolean isDayPresent = dayDaoImpl.checkIsDayPresent(activeDay);
			if(isDayPresent != true) {
				dayListCopy.add(activeDay);
			}
		}
		dayList.removeAll(dayListCopy);
		System.out.println(dayList);
		//Store Removed list into RemovedCoTrainerAndDays dto class
		RemovedCoTrainerAndDays removedCoTrainerAndDays = new RemovedCoTrainerAndDays(); 
		removedCoTrainerAndDays.setCoTrainerList(coTrainerListCopy);
		removedCoTrainerAndDays.setDayList(dayListCopy);
		return removedCoTrainerAndDays;	
	}

	public List<BatchTraineeDto> batchTraineeValidator(List<BatchTraineeDto> batchTraineeList) throws ValidatorException {

		System.out.println("======>"+batchTraineeList);
		
			List<Candidate> candidateList = candidateDaoImpl.getCandidate(batchTraineeList);
			List<String> availableCandidateEmails= candidateList.stream()
					.map(candidate -> candidate.getEmail())
					.collect(Collectors.toList());
			
			List<BatchTraineeDto> availableCandidates = batchTraineeList.stream()
					.filter(batchTrainee -> availableCandidateEmails.contains(batchTrainee.getUserMail()))
					.collect(Collectors.toList()); // use this availableCandidateEmails
			// use optional in streams
			availableCandidates.stream().forEach((availableCandidate) ->{
						candidateList.forEach(
								(candidate) -> {
									availableCandidate.setId(candidate.getId());
								}
								);
					}
					);
			
		System.out.println(availableCandidates);
		return availableCandidates;
	}

}

/*
 * for (BatchTraineeDto batchTraineeDto : batchTraineeList1) { for (Candidate
 * candidate : candidateList) { if(candidate.getEmail() !=
 * batchTraineeDto.getUserMail()) {
 * 
 * } } }
 */
