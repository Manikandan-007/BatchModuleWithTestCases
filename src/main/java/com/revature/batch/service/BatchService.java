package com.revature.batch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.batch.dao.BatchImplDao;
import com.revature.batch.dao.BatchTraineeDaoImpl;
import com.revature.batch.dto.BatchDataDto;
import com.revature.batch.dto.BatchListDto;
import com.revature.batch.dto.CoTrainerListDto;
import com.revature.batch.dto.RemovedCoTrainerAndDays;
import com.revature.batch.exception.DBException;
import com.revature.batch.exception.ServiceException;
import com.revature.batch.exception.ValidatorException;
import com.revature.batch.model.ActiveDay;
import com.revature.batch.model.BatchTrainee;
import com.revature.batch.model.CoTrainer;
import com.revature.batch.validator.BatchValidator;

@Service
public class BatchService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchService.class);
	
	@Autowired
	private BatchImplDao batchImplDao;
	
	@Autowired
	private BatchValidator batchValidator;
	
	@Autowired
	private BatchTraineeDaoImpl batchTraineeDaoImpl;

	/** 
	 * batchCreationService in BatchService
	 * @Param BatchDataDto object
	 * 
	 * return RemovedCoTrainerAndDays
	 * 
	 * If the credential is Invalid or if DB issue occur in DAO,
	 *  Here it will throw ServiceException
	 */
	public RemovedCoTrainerAndDays batchCreationService(BatchDataDto batchDataDto) throws ServiceException {

		RemovedCoTrainerAndDays removedCoTrainerAndDays = null;
		try {
			
			removedCoTrainerAndDays = batchValidator.createBatchValidator(batchDataDto);
			
			List<ActiveDay> dayList = batchDataDto.getDayList();
			List<CoTrainer> coTrainerList = batchDataDto.getCoTrainer();
			
			//Remove failed data in validation from CoTrainerList and DayList 
			coTrainerList.removeAll(removedCoTrainerAndDays.getCoTrainerList());
			dayList.removeAll(removedCoTrainerAndDays.getDayList());
			
			batchDataDto.setCoTrainer(coTrainerList);
			batchDataDto.setDayList(dayList);
			
			LOGGER.info("--->", batchDataDto);
			LOGGER.debug("--->", removedCoTrainerAndDays);
			batchImplDao.createBatchDao(batchDataDto);
			
		} catch (DBException e) {
			LOGGER.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (ValidatorException e) {
			LOGGER.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		
		return removedCoTrainerAndDays;
	}

	/** 
	 * batchListService in BatchService
	 * @Param No parameter
	 * 
	 * return List<BatchListDto>
	 * 
	 * if DB issue occur in DAO, Here it will throw ServiceException
	 */
	public List<BatchListDto> batchListService() throws ServiceException {
		
		List<BatchListDto> batchList;
		try {
			batchList = batchImplDao.getBatchList();
			
			for (BatchListDto batchListDto : batchList) {
				List<CoTrainerListDto> coTrainerListDto = batchImplDao.getCoTrainerList(batchListDto.getId());
				batchListDto.setCoTrainerList(coTrainerListDto);
				
				List<BatchTrainee> batchTraineeList = batchTraineeDaoImpl.getBatchTraineeList(batchListDto.getId());
				batchListDto.setBatchTraineeList(batchTraineeList);
			}
		} catch (DBException e) {
			LOGGER.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		
		return batchList;
	}

}
