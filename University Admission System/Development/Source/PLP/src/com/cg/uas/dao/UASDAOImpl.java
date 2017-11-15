package com.cg.uas.dao;

/************************************************************************************
 * File:        UASDAOImpl.java
 * Package:     com.cg.uas.dao
 * Description: Implementation of data access object interface "UASDAO.java" for
 * 				 University Admission System
 * Version:     1.0
 * Modifications:
 * Author: Group5      Date: 14th-Nov-2017      Change Description:
 ************************************************************************************/
import static com.cg.uas.utility.UASDAOConstants.APPLICATION_NOT_SUBMITTED;
import static com.cg.uas.utility.UASDAOConstants.APPLICATION_SUBMITTED;
import static com.cg.uas.utility.UASDAOConstants.GET_APPLICATION_STATUS;
import static com.cg.uas.utility.UASDAOConstants.INCORRECT_PROGRAM_NAME;
import static com.cg.uas.utility.UASDAOConstants.INTERVIEW_DATE_NOT_SCHEDULED;
import static com.cg.uas.utility.UASDAOConstants.INTERVIEW_DATE_SCHEDULED;
import static com.cg.uas.utility.UASDAOConstants.INVALID_PROGRAMID;
import static com.cg.uas.utility.UASDAOConstants.LOGGED_IN;
import static com.cg.uas.utility.UASDAOConstants.NO_APPLICANT_WITH_GIVEN_ID;
import static com.cg.uas.utility.UASDAOConstants.NO_PROGRAMS_AVAILABLE;
import static com.cg.uas.utility.UASDAOConstants.PARTICIPANT_ADDED;
import static com.cg.uas.utility.UASDAOConstants.PARTICIPANT_NOT_ADDED;
import static com.cg.uas.utility.UASDAOConstants.PROGRAM_DELETED;
import static com.cg.uas.utility.UASDAOConstants.PROGRAM_NOT_DELETED;
import static com.cg.uas.utility.UASDAOConstants.PROGRAM_NOT_UPDATED;
import static com.cg.uas.utility.UASDAOConstants.PROGRAM_UPDATED;
import static com.cg.uas.utility.UASDAOConstants.RETREIEVE_PROGRAMS_SCHEDULED;
import static com.cg.uas.utility.UASDAOConstants.RETREIVE_APPLICATIONS_FOR_A_PROGRAMID;
import static com.cg.uas.utility.UASDAOConstants.STATUS_NOT_UPDATED;
import static com.cg.uas.utility.UASDAOConstants.STATUS_UPDATED;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.User;
import com.cg.uas.exception.UniversityException;
import com.cg.uas.utility.QueryMapper;

@Repository
@Transactional
public class UASDAOImpl implements UASDAO {

	private static Logger logger = Logger
			.getLogger(com.cg.uas.dao.UASDAOImpl.class);
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean validate(User user) {
		TypedQuery<User> query = entityManager.createQuery(QueryMapper.users,
				User.class);
		query.setParameter("ploginid", user.getLoginId());
		query.setParameter("ppwd", user.getPassword());
		query.setParameter("prole", user.getRole());
		List<User> users = query.getResultList();
		logger.info(LOGGED_IN);
		return users.isEmpty();
	}

	@Override
	public List<ProgramsScheduled> viewProgrammes() throws UniversityException {
		try {
			TypedQuery<ProgramsScheduled> query = entityManager.createQuery(
					QueryMapper.programs, ProgramsScheduled.class);
			logger.info(RETREIEVE_PROGRAMS_SCHEDULED);
			return query.getResultList();
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(NO_PROGRAMS_AVAILABLE);
		}
	}

	@Override
	public ProgramsOffered getProgramsOffered(String pname)
			throws UniversityException {

		try {
			TypedQuery<ProgramsOffered> query = entityManager.createQuery(
					QueryMapper.programDetails, ProgramsOffered.class);
			query.setParameter("pname", pname);
			ProgramsOffered programs = query.getSingleResult();
			logger.info("Retrieved Programs Offered");
			return programs;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(INCORRECT_PROGRAM_NAME);
		}
	}

	@Override
	public Application getStatus(int appid) throws UniversityException {
		try {
			TypedQuery<Application> query = entityManager.createQuery(
					QueryMapper.application, Application.class);
			query.setParameter("pappid", appid);
			Application app = query.getSingleResult();
			logger.info(GET_APPLICATION_STATUS);
			return app;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(e.getMessage());

		}
	}

	@Override
	public Application save(Application app) throws UniversityException {

		try {
			entityManager.persist(app);
			entityManager.flush(); // required to reflect changes on database
			logger.info(APPLICATION_SUBMITTED);
			return app;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(APPLICATION_NOT_SUBMITTED);
		}
	}

	@Override
	public List<Application> getApplicant(String programId)
			throws UniversityException {

		try {
			TypedQuery<Application> query = entityManager.createQuery(
					QueryMapper.applications, Application.class);
			query.setParameter("pappid", programId);
			List<Application> applications = query.getResultList();
			logger.info(RETREIVE_APPLICATIONS_FOR_A_PROGRAMID);
			return applications;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new UniversityException(NO_APPLICANT_WITH_GIVEN_ID);
		}
	}

	@Override
	public Application modify(Application application, String status)
			throws UniversityException {
		try {
			application.setStatus(status);
			application = entityManager.merge(application);
			entityManager.flush(); // required to reflect changes on database
			logger.info(STATUS_UPDATED);
			return application;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(STATUS_NOT_UPDATED);
		}
	}

	@Override
	public Application setInterview(Application application,
			Date dateOfInterview) throws UniversityException {
		try {
			application.setDateOfInterview(dateOfInterview);
			application = entityManager.merge(application);
			entityManager.flush(); // required to reflect changes on database
			logger.info(INTERVIEW_DATE_SCHEDULED);
			return application;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(INTERVIEW_DATE_NOT_SCHEDULED);
		}
	}

	@Override
	public Participant addParticipant(Participant ppt)
			throws UniversityException {

		try {
			entityManager.persist(ppt);
			entityManager.flush(); // required to reflect changes on database
			logger.info(PARTICIPANT_ADDED);
			return ppt;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(PARTICIPANT_NOT_ADDED);
		}

	}

	@Override
	public ProgramsScheduled getProgram(String programId)
			throws UniversityException {

		try {
			TypedQuery<ProgramsScheduled> query = entityManager.createQuery(
					QueryMapper.programsScheduled, ProgramsScheduled.class);
			query.setParameter("ppid", programId);
			ProgramsScheduled prgrms = query.getSingleResult();
			logger.info(RETREIVE_APPLICATIONS_FOR_A_PROGRAMID);
			return prgrms;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(INVALID_PROGRAMID);
		}
	}

	@Override
	public int deleteProgram(String scheduledProgrammeId)
			throws UniversityException {

		try {
			Query query = entityManager.createQuery(QueryMapper.deletePrograms);
			int deletedCount = query.setParameter("p", scheduledProgrammeId)
					.executeUpdate();
			logger.info(PROGRAM_DELETED);
			return deletedCount;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(PROGRAM_NOT_DELETED);
		}
	}

	@Override
	public ProgramsScheduled modify(ProgramsScheduled programsScheduled)
			throws UniversityException {
		try {

			programsScheduled = entityManager.merge(programsScheduled);
			entityManager.flush(); // required to reflect changes on database
			logger.info(PROGRAM_UPDATED);
			return programsScheduled;
		} catch (Exception e) {
			logger.error(e);
			throw new UniversityException(PROGRAM_NOT_UPDATED);
		}
	}

	@Override
	public void checkUser(HttpSession session, String role)
			throws UniversityException {
		User user = (User) session.getAttribute("users");
		if (!(role).equals(user.getRole())) {
			throw new UniversityException("Unauthorized access");
		}
	}

}
