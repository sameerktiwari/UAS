package com.cg.uas.test;

/************************************************************************************
 * File:        UASTest.java
 * Package:     com.cg.uas.test
 * Description: Performs Unit Testing on DAO layer operations
 * Version:     1.0
 * Modifications:
 * Author: Group5      Date: 14th-Nov-2017      Change Description:
 ************************************************************************************/
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cg.uas.dao.UASDAO;
import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.User;
import com.cg.uas.exception.UniversityException;

@ContextConfiguration("testDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UASTest {
	@Autowired
	private UASDAO dao;

	@Test
	@Transactional
	@Rollback(true)
	public void testValidate() {
		User user = new User("akash", "akash", "mac");
		assertEquals(false, dao.validate(user));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSave() throws UniversityException {
		Application application = new Application("Sameer Tiwari",
				Date.valueOf("1995-04-02"), "BTech", 88,
				"IT engineer", "sameerkt@gmail.com", "1001",
				"Pending");
		Application returnapplication = dao.save(application);
		assertEquals(returnapplication.getFullName(), application.getFullName());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewProgrammes() throws UniversityException {
		List<ProgramsScheduled> programs = dao.viewProgrammes();
		assertEquals(true, (programs.size() > 0));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetProgramsOffered() throws UniversityException {
		ProgramsOffered program = dao.getProgramsOffered("Accounting");
		assertEquals("Accounting", program.getProgramName());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetStatus() throws UniversityException {
		Application application = new Application("Sameer Tiwari",
				Date.valueOf("1995-04-02"), "BTech", 88,
				"IT engineer", "sameerkt@gmail.com", "1001",
				"Pending");
		application = dao.save(application);
		Application returnApplication = dao.getStatus(application
				.getApplicationId());
		assertEquals("Pending", returnApplication.getStatus());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testModifyApplicationStatus() throws UniversityException {
		Application application = new Application("Sameer Tiwari",
				Date.valueOf("1995-04-02"), "BTech", 88,
				"IT engineer", "sameerkt@gmail.com", "1001",
				"Pending");
		application = dao.save(application);
		Application returnApplication = dao.modify(application, "Accepted");
		assertEquals("Accepted", returnApplication.getStatus());
	}

	@Test(expected = UniversityException.class)
	@Transactional
	@Rollback(true)
	public void testDeleteProgram() throws UniversityException {
		dao.deleteProgram("1002");
		dao.getProgram("1002");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSetInterview() throws UniversityException {
		Application application = new Application("Sameer Tiwari",
				Date.valueOf("1995-04-02"), "BTech", 88,
				"IT engineer", "sameerkt@gmail.com", "1001",
				"Pending");
		application = dao.save(application);
		Application returnApplication = dao.setInterview(application,
				Date.valueOf("2018-01-01"));
		assertEquals(Date.valueOf("2018-01-01"),
				returnApplication.getDateOfInterview());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetApplicant() throws UniversityException {
		Application application = new Application("Sameer Tiwari",
				Date.valueOf("1995-04-02"), "BTech", 88,
				"IT engineer", "sameerkt@gmail.com", "1001",
				"Pending");
		application = dao.save(application);
		List<Application> applications = dao.getApplicant("1001");
		assertEquals(true, (applications.size() > 0));
	}
}
