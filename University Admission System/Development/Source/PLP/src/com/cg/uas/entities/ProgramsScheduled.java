package com.cg.uas.entities;

/************************************************************************************
 * File:        ProgramsScheduled.java
 * Package:     com.cg.uas.entities
 * Description: It contains the information regarding the programs that are being 
 * 				scheduled in the current time period
 * Version:     1.0
 * Modifications:
 * Author: Group5      Date: 14th-Nov-2017      Change Description:
 ************************************************************************************/
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Programs_Scheduled")
public class ProgramsScheduled implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "scheduled_program_id")
	private String scheduledProgrammeId;
	@Column(name = "programName")
	private String programName;
	@Column(name = "location")
	private String location;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "sessions_per_week")
	private int sessionsPerWeek;

	public ProgramsScheduled(String scheduledProgrammeId, String programName,
			String location, Date startDate, Date endDate, int sessionsPerWeek) {
		super();
		this.scheduledProgrammeId = scheduledProgrammeId;
		this.programName = programName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionsPerWeek = sessionsPerWeek;
	}

	public ProgramsScheduled() {
		super();
	}

	public String getScheduledProgrammeId() {
		return scheduledProgrammeId;
	}

	public void setScheduledProgrammeId(String scheduledProgrammeId) {
		this.scheduledProgrammeId = scheduledProgrammeId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}

	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}

	@Override
	public String toString() {
		return "ProgramScheduled [scheduledProgrammeId=" + scheduledProgrammeId
				+ ", programName=" + programName + ", location=" + location
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", sessionsPerWeek=" + sessionsPerWeek + "]";
	}

}
