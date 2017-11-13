package com.cg.uas.test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.uas.dao.IDAO;
import com.cg.uas.entities.Application;
import com.cg.uas.entities.Users;
import com.cg.uas.exception.UniversityException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("testDao.xml")
public class DAOImplTest {
	@Autowired
	private IDAO dao;
	
	@Test
	public void testValidate() {
		Users user=new Users("akash","akash","mac");
		assertEquals(false, dao.validate(user));
	}
	
	@Test
	public void testGetStatus() throws UniversityException{
		Application application=new Application("Sameer Tiwari", Date.valueOf("1995-04-02"), "Bachelor of Technology", 88, "Successful IT engineer", "sameerkt@gmail.com", "1001","Pending");
		application=dao.save(application);
		assertEquals("Pending", dao.modify(application, "Accepted").getStatus());
	}
}
