package com.cg.uas.dao;

import java.sql.Date;
import java.util.List;

import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.Users;
import com.cg.uas.exception.UniversityException;

public interface IDAO {

	/**
	 * @param user
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
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsOffered getProgramsOffered(String pname)
			throws UniversityException;

	/**
	 * @param appid
	 * @return
	 * @throws UniversityException
	 */
	public Application getStatus(int appid) throws UniversityException;

	/**
	 * @param app
	 * @return
	 * @throws UniversityException
	 */
	public Application save(Application app) throws UniversityException;

	/**
	 * @param programId
	 * @return
	 * @throws UniversityException
	 */
	public List<Application> getApplicant(String programId)
			throws UniversityException;

	/**
	 * @param application
	 * @param status
	 * @return
	 * @throws UniversityException
	 */
	public Application modify(Application application, String status)
			throws UniversityException;

	/**
	 * @param application
	 * @param dateOfInterview
	 * @return
	 * @throws UniversityException
	 */
	public Application setInterview(Application application,
			Date dateOfInterview) throws UniversityException;

	/**
	 * @param ppt
	 * @return
	 * @throws UniversityException
	 */
	public Participant addParticipant(Participant ppt)
			throws UniversityException;

	/**
	 * @param programId
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsScheduled getProgram(String programId)
			throws UniversityException;

	/**
	 * @param scheduledProgrammeId
	 * @return
	 * @throws UniversityException
	 */
	public int deleteProgram(String scheduledProgrammeId)
			throws UniversityException;

	/**
	 * @param programsScheduled
	 * @return
	 * @throws UniversityException
	 */
	public ProgramsScheduled modify(ProgramsScheduled programsScheduled)
			throws UniversityException;

}
