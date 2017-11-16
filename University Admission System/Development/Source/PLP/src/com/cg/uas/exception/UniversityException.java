package com.cg.uas.exception;
/************************************************************************************
 * File:        UniversityException.java
 * Package:     com.cg.uas.exception
 * Description: User defined exception to handle all other exceptions occurring in the
 * 				 application
 * Version:     1.0
 * Modifications:
 * Author: Group5      Date: 14th-Nov-2017      Change Description:
 ************************************************************************************/
public class UniversityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UniversityException() {
		super();
	}

	public UniversityException(String arg0) {
		super(arg0);
	}

	public UniversityException(Throwable arg0) {
		super(arg0);
	}

	public UniversityException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UniversityException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
