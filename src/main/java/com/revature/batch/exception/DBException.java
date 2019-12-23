package com.revature.batch.exception;

public class DBException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 7940028551428187302L;
public DBException(String message) 
{
super(message);	
}
public DBException(String message,Throwable throwable) 
{
super(message,throwable);	
}

}
