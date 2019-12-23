package com.revature.batch.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.batch.dto.BatchTraineeDto;
import com.revature.batch.exception.DBException;
import com.revature.batch.util.ConnectionUtil;

@RunWith(MockitoJUnitRunner.class)
public class BatchTraineeDaoTest {

	@InjectMocks
	private BatchTraineeDaoImpl batchTraineeDao;
	
	@Mock
	private Connection con;
	
	@Mock
	private PreparedStatement preStmt;
	
	@Mock
	private ConnectionUtil connection;
	
	@Mock
    private ResultSet mockResultSet;
	
	@Before
	public void setup() throws SQLException, DBException {
		when (ConnectionUtil.getConnection()).thenReturn(con);
		doNothing().when(con).commit();
		when(preStmt.execute()).thenReturn(Boolean.TRUE);
		when(preStmt.getGeneratedKeys()).thenReturn(mockResultSet);
		when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
	}
	@Test
	public void testAddTraineeIntoBatch() throws DBException {
		
		List<BatchTraineeDto> batchTraineeList = new ArrayList<BatchTraineeDto>();
		BatchTraineeDto batchTraineeDto = new BatchTraineeDto();
		
		batchTraineeDto.setId(1);
		batchTraineeDto.setBatchId(1);
		batchTraineeDto.setUserMail("user1@gmail.com");
		
		batchTraineeList.add(batchTraineeDto);
		
		when(batchTraineeDao.addTraineeIntoBatch(batchTraineeList)).thenReturn(true);
		
		boolean isInserted = batchTraineeDao.addTraineeIntoBatch(batchTraineeList);
		assertTrue(isInserted);
		
	}

}
