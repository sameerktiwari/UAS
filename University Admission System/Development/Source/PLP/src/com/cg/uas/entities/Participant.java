package com.cg.uas.entities;

/************************************************************************************
 * File:        Participant.java
 * Package:     com.cg.uas.entities
 * Description: Participant details for an enrolled program 
 * Version:     1.0
 * Modifications:
 * Author: Group5      Date: 14th-Nov-2017      Change Description:
 ************************************************************************************/
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participant")
public class Participant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "roll_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollNo;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "application_id")
	private int applicantId;
	@Column(name = "scheduled_Program_Id")
	private int scheduledProgramId;

	public Participant(String emailId, int applicantId, int scheduledProgramId) {
		super();
		this.emailId = emailId;
		this.applicantId = applicantId;
		this.scheduledProgramId = scheduledProgramId;
	}

	public Participant() {
		super();
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public int getScheduledProgramId() {
		return scheduledProgramId;
	}

	public void setScheduledProgramId(int scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}

	@Override
	public String toString() {
		return "Participant [rollNo=" + rollNo + ", emailId=" + emailId
				+ ", applicantId=" + applicantId + ", scheduledProgramId="
				+ scheduledProgramId + "]";
	}

}
