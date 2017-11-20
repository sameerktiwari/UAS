package com.cg.uas.service;

/************************************************************************************
 * File:        UASServiceImpl.java
 * Package:     com.cg.uas.service
 * Description: Implements the link between presentation layer and dao layer for
 * 				 University Admission System
 * Version:     1.0
 * Modifications:
 * Author: Group5      Date: 14th-Nov-2017      Change Description:
 ************************************************************************************/
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.uas.dao.UASDAO;
import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.User;
import com.cg.uas.exception.UniversityException;

@Service
public class UASServiceImpl implements UASService {
	@Autowired
	UASDAO dao;

	@Override
	public boolean validate(User user) {
		return dao.validate(user);
	}

	@Override
	public List<ProgramsScheduled> viewProgrammes() throws UniversityException {
		return dao.viewProgrammes();
	}

	@Override
	public ProgramsOffered getProgramsOffered(String pname)
			throws UniversityException {
		return dao.getProgramsOffered(pname);
	}

	@Override
	public Application getStatus(int appid) throws UniversityException {
		return dao.getStatus(appid);
	}

	@Override
	public Application save(Application app) throws UniversityException {
		return dao.save(app);
	}

	@Override
	public List<Application> getApplicant(String programId)
			throws UniversityException {
		return dao.getApplicant(programId);
	}

	@Override
	public Application modify(Application application, String status)
			throws UniversityException {
		return dao.modify(application, status);
	}

	@Override
	public Application setInterview(Application application,
			Date dateOfInterview) throws UniversityException {
		return dao.setInterview(application, dateOfInterview);
	}

	@Override
	public Participant addParticipant(Participant ppt)
			throws UniversityException {
		return dao.addParticipant(ppt);
	}

	@Override
	public ProgramsScheduled getProgram(String programId)
			throws UniversityException {
		return dao.getProgram(programId);
	}

	@Override
	public int deleteProgram(String scheduledProgrammeId)
			throws UniversityException {
		return dao.deleteProgram(scheduledProgrammeId);
    }

	@Override
	public ProgramsScheduled modify(ProgramsScheduled programsScheduled)
			throws UniversityException {
		return dao.modify(programsScheduled);
	}

	@Override
	public void checkUser(HttpSession session, String role)
			throws UniversityException {
		dao.checkUser(session, role);
	}
}
