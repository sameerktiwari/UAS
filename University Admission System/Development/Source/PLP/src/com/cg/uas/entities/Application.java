package com.cg.uas.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

/**
 * @author GroupNo. 5 Application by a participant for a scheduled program
 *         available by the university/ Every attribute needed for the
 *         application will be present here and depending on the progress of the
 *         Application they will get updated.
 *
 */
@Entity
@Table(name = "application")
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "application_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int applicationId;

	@Column(name = "full_name")
	@Pattern(regexp = "[A-Za-z ]{2,}", message = " Enter only alphabets")
	private String fullName;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "highest_Qualification")
	private String highestQualification;

	@Column(name = "marks_Obtained")
	@Min(value = 0, message = " Must be greater than or equal to 0")
	@Max(value = 100, message = " Must be smaller than or equal to 100")
	private int marksObtained;

	@Email
	@Column(name = "email_id")
	private String email;

	@Column(name = "goals")
	private String goals;

	@Column(name = "scheduled_Program_Id")
	private String scheduledProgramId;

	@Column(name = "status")
	public String status;

	@Column(name = "date_of_interview")
	public Date dateOfInterview;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Date getDateOfInterview() {
		return dateOfInterview;
	}

	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}

	public Application(String fullName, Date dateOfBirth,
			String highestQualification, int marksObtained, String goals,
			String email, String scheduledProgramId, String status) {
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.email = email;
		this.goals = goals;
		this.scheduledProgramId = scheduledProgramId;
		this.status = status;
	}

	public Application(int applicationId, String fullName, Date dateOfBirth,
			String highestQualification, int marksObtained, String goals,
			String email, String scheduledProgramId) {
		this.applicationId = applicationId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.email = email;
		this.goals = goals;
		this.scheduledProgramId = scheduledProgramId;
	}

	public Application() {
		super();
	}

	/**/

	public String getFullName() {
		return fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public String getEmail() {
		return email;
	}

	public String getGoals() {
		return goals;
	}

	public String getScheduledProgramId() {
		return scheduledProgramId;
	}

	public int genId() {
		return applicationId;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", fullName="
				+ fullName + ", dateOfBirth=" + dateOfBirth
				+ ", highestQualification=" + highestQualification
				+ ", marksObtained=" + marksObtained + ", email=" + email
				+ ", goals=" + goals + ", scheduledProgramId="
				+ scheduledProgramId + ", status=" + status
				+ ", dateOfInterview=" + dateOfInterview + "]";
	}

}
