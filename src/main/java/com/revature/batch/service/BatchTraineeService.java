package com.revature.batch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.batch.dao.BatchTraineeDaoImpl;
import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.dto.BatchTraineeListDto;
import com.revature.batch.exception.DBException;
import com.revature.batch.exception.ServiceException;
import com.revature.batch.exception.ValidatorException;
import com.revature.batch.validator.BatchValidator;

@Service
public class BatchTraineeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchTraineeService.class);
	
	@Autowired
	private BatchTraineeDaoImpl batchTraineeDaoImpl;
	
	@Autowired
	private BatchValidator batchValidator;
	
	/** 
	 * addBatchTraineeService in BatchTraineeService
	 * @Param BatchTraineeListDto
	 * 
	 * return boolean
	 * 
	 * If the credential is Invalid or if DB issue occur in DAO, Here it will throw ServiceException
	 */
	public boolean addBatchTraineeService(BatchTraineeListDto batchTraineeListDto) throws ServiceException{

		List<BatchTraineeDto> batchTraineeList = batchTraineeListDto.getBatchTraineeList();
		boolean isInserted = false;
		try {
			//Validation for add trainee in batch
			batchTraineeList = batchValidator.batchTraineeValidator(batchTraineeList);
			
			//If validation success means it will Add
			isInserted =  batchTraineeDaoImpl.addTraineeIntoBatch(batchTraineeList);
		} catch (ValidatorException e) {
			LOGGER.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return isInserted;
	}

}
