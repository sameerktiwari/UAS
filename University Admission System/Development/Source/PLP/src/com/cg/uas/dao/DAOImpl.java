package com.cg.uas.dao;

import static com.cg.uas.utility.UASDAOConstants.*;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.Users;
import com.cg.uas.exception.UniversityException;
import com.cg.uas.utility.QueryMapper;

@Repository
@Transactional
public class DAOImpl implements IDAO {

	private static Logger logger = Logger
			.getLogger(com.cg.uas.dao.DAOImpl.class);
	@PersistenceContext
	EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#validate(com.cg.uas.entities.Users)
	 */
	@Override
	public boolean validate(Users user) {
		TypedQuery<Users> query = entityManager.createQuery(QueryMapper.users,
				Users.class);
		query.setParameter("ploginid", user.getLoginId());
		query.setParameter("ppwd", user.getPassword());
		query.setParameter("prole", user.getRole());
		List<Users> users = query.getResultList();
		logger.info(LOGGED_IN);
		return users.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#viewProgrammes()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#getProgramsOffered(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#getStatus(int)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#save(com.cg.uas.entities.Application)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#getApplicant(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#modify(com.cg.uas.entities.Application,
	 * java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#setInterview(com.cg.uas.entities.Application,
	 * java.sql.Date)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#addParticipant(com.cg.uas.entities.Participant)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#getProgram(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#deleteProgram(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.dao.IDAO#modify(com.cg.uas.entities.ProgramsScheduled)
	 */
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

}
