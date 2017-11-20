package com.cg.uas.dao;

/************************************************************************************
 * File:        UASDAO.java
 * Package:     com.cg.uas.dao
 * Description: Interface of data access object for University Admission System
 * Version:     1.0
 * Modifications:
 * Author: Group5      Date: 14th-Nov-2017      Change Description:
 ************************************************************************************/
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.User;
import com.cg.uas.exception.UniversityException;

/**
 * @author sametiwa
 *
 */
public interface UASDAO {

	/**
	 * Validates the user
	 * @param user
	 *            - Contains user information to be validated
	 * @return
	 * @throws UniversityException
	 */
	public boolean validate(User user);

	/**
	 * Shows the programs scheduled
	 * @return
	 * @throws UniversityException
	 */
	public List<ProgramsScheduled> viewProgrammes() throws UniversityException;

	/**
	 * Shows the programs Offered
	 * @param pname
	 *            - Contains the program name of which details has to be fetched
	 *            from the database
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsOffered getProgramsOffered(String pname)
			throws UniversityException;

	/**
	 * Returns the status of the applicant
	 * @param appid
	 *            - Contains the application id for which status has to be
	 *            fetched from the database
	 * @return
	 * @throws UniversityException
	 */
	public Application getStatus(int appid) throws UniversityException;

	/**
	 * Saves the Application
	 * @param app
	 *            - Contains the applicant information which is to be submitted
	 * @return
	 * @throws UniversityException
	 */
	public Application save(Application app) throws UniversityException;

	/**
	 * Gets the applicant information
	 * @param programId
	 *            - Contains the program id for which applications has to be
	 *            fetched from the database
	 * @return
	 * @throws UniversityException
	 */
	public List<Application> getApplicant(String programId)
			throws UniversityException;

	/**
	 * Modifies the application
	 * @param application
	 *            - Contains the applicant information of which status has to be
	 *            updated
	 * @param status
	 *            - Contains the status to which applicant status is to be
	 *            updated to
	 * @return
	 * @throws UniversityException
	 */
	public Application modify(Application application, String status)
			throws UniversityException;

	/**
	 * Sets Interview Date for an applicant
	 * @param application
	 *            - Contains the applicant information of which date of
	 *            interview has to be set
	 * @param dateOfInterview
	 *            - Contains date of interview to which applicant date of
	 *            interview is to be updated to
	 * @return
	 * @throws UniversityException
	 */
	public Application setInterview(Application application,
			Date dateOfInterview) throws UniversityException;

	/**
	 * Adds the participant
	 * @param ppt
	 *            - Contains participant information which is to be added
	 * @return
	 * @throws UniversityException
	 */
	public Participant addParticipant(Participant ppt)
			throws UniversityException;

	/**
	 * Gets the program information
	 * @param programId
	 *            - Contains scheduled program id of which details has to be
	 *            fetched from the database
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsScheduled getProgram(String programId)
			throws UniversityException;

	/**
	 * Deletes a program schedule
	 * @param scheduledProgrammeId
	 *            - Contains scheduled program id of a program which is to be
	 *            deleted
	 * @return
	 * @throws UniversityException
	 */
	public int deleteProgram(String scheduledProgrammeId)
			throws UniversityException;

	/**
	 * Modifies the program schedule
	 * @param programsScheduled
	 *            - Contains scheduled program id of a program which is to be
	 *            modified
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsScheduled modify(ProgramsScheduled programsScheduled)
			throws UniversityException;

	/**
	 * Checks the user access
	 * @param session- Contains the user information
	 * @param role- Contains the role
	 * @throws UniversityException
	 */
	public void checkUser(HttpSession session, String role)
			throws UniversityException;

}
