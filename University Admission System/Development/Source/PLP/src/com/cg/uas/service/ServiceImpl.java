package com.cg.uas.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.uas.dao.IDAO;
import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.Users;
import com.cg.uas.exception.UniversityException;

@Service
public class ServiceImpl implements IService {
	@Autowired
	IDAO dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#validate(com.cg.uas.entities.Users)
	 */
	@Override
	public boolean validate(Users user) {
		return dao.validate(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#viewProgrammes()
	 */
	@Override
	public List<ProgramsScheduled> viewProgrammes() throws UniversityException {
		return dao.viewProgrammes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#getProgramsOffered(java.lang.String)
	 */
	@Override
	public ProgramsOffered getProgramsOffered(String pname)
			throws UniversityException {
		return dao.getProgramsOffered(pname);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#getStatus(int)
	 */
	@Override
	public Application getStatus(int appid) throws UniversityException {
		return dao.getStatus(appid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#save(com.cg.uas.entities.Application)
	 */
	@Override
	public Application save(Application app) throws UniversityException {

		return dao.save(app);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#getApplicant(java.lang.String)
	 */
	@Override
	public List<Application> getApplicant(String programId)
			throws UniversityException {

		return dao.getApplicant(programId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#modify(com.cg.uas.entities.Application,
	 * java.lang.String)
	 */
	@Override
	public Application modify(Application application, String status)
			throws UniversityException {
		return dao.modify(application, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cg.uas.service.IService#setInterview(com.cg.uas.entities.Application,
	 * java.sql.Date)
	 */
	@Override
	public Application setInterview(Application application,
			Date dateOfInterview) throws UniversityException {
		return dao.setInterview(application, dateOfInterview);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cg.uas.service.IService#addParticipant(com.cg.uas.entities.Participant
	 * )
	 */
	@Override
	public Participant addParticipant(Participant ppt)
			throws UniversityException {
		return dao.addParticipant(ppt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#getProgram(java.lang.String)
	 */
	@Override
	public ProgramsScheduled getProgram(String programId)
			throws UniversityException {
		return dao.getProgram(programId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.uas.service.IService#deleteProgram(java.lang.String)
	 */
	@Override
	public int deleteProgram(String scheduledProgrammeId)
			throws UniversityException {
		return dao.deleteProgram(scheduledProgrammeId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cg.uas.service.IService#modify(com.cg.uas.entities.ProgramsScheduled)
	 */
	@Override
	public ProgramsScheduled modify(ProgramsScheduled programsScheduled)
			throws UniversityException {
		return dao.modify(programsScheduled);

	}
}
