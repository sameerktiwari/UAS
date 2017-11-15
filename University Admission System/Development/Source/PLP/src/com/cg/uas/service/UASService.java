package com.cg.uas.service;

import java.sql.Date;
import java.util.List;

import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.Users;
import com.cg.uas.exception.UniversityException;

public interface UASService {

	/**
	 * @param user
	 *            - Contains user information to be validated
	 * @return
	 * @throws UniversityException
	 */
	public boolean validate(Users user);

	/**
	 * @return
	 * @throws UniversityException
	 */
	public List<ProgramsScheduled> viewProgrammes() throws UniversityException;

	/**
	 * @param pname
	 *            - Contains the program name of which details has to be fetched
	 *            from the database
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsOffered getProgramsOffered(String pname)
			throws UniversityException;

	/**
	 * @param appid
	 *            - Contains the application id for which status has to be
	 *            fetched from the database
	 * @return
	 * @throws UniversityException
	 */
	public Application getStatus(int appid) throws UniversityException;

	/**
	 * @param app
	 *            - Contains the applicant information which is to be submitted
	 * @return
	 * @throws UniversityException
	 */
	public Application save(Application app) throws UniversityException;

	/**
	 * @param programId
	 *            - Contains the program id for which applications has to be
	 *            fetched from the database
	 * @return
	 * @throws UniversityException
	 */
	public List<Application> getApplicant(String programId)
			throws UniversityException;

	/**
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
	 * @param ppt
	 *            - Contains participant information which is to be added
	 * @return
	 * @throws UniversityException
	 */
	public Participant addParticipant(Participant ppt)
			throws UniversityException;

	/**
	 * @param programId
	 *            - Contains scheduled program id of which details has to be
	 *            fetched from the database
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsScheduled getProgram(String programId)
			throws UniversityException;

	/**
	 * @param scheduledProgrammeId
	 *            - Contains scheduled program id of a program which is to be
	 *            deleted
	 * @throws UniversityException
	 */
	public int deleteProgram(String scheduledProgrammeId)
			throws UniversityException;

	/**
	 * @param programsScheduled
	 *            - Contains scheduled program id of a program which is to be
	 *            modified
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsScheduled modify(ProgramsScheduled programsScheduled)
			throws UniversityException;
}
