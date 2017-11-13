package com.cg.uas.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author GroupNo.5 Programs which are on the guideline of University.Contains
 *         who are eligible the duration of the program and which degree will be
 *         given on the completion
 *
 */
@Entity
@Table(name = "Programs_Offered")
public class ProgramsOffered implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "programName")
	protected String programName;
	@Column(name = "description")
	protected String description;
	@Column(name = "applicant_Eligibility")
	protected String applicantEligibility;
	@Column(name = "duration")
	protected int duration;
	@Column(name = "degree_certificate_offered")
	protected String degree;

	public ProgramsOffered(String programName, String description,
			String applicantEligibility, int duration, String degree) {
		super();
		this.programName = programName;
		this.description = description;
		this.applicantEligibility = applicantEligibility;
		this.duration = duration;
		this.degree = degree;
	}

	public ProgramsOffered() {
		super();
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApplicantEligibility() {
		return applicantEligibility;
	}

	public void setApplicantEligibility(String applicantEligibility) {
		this.applicantEligibility = applicantEligibility;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "ProgramsOffered [programName=" + programName + ", description="
				+ description + ", applicantEligibilty=" + applicantEligibility
				+ ", duration=" + duration + ", degree=" + degree + "]";
	}

}
