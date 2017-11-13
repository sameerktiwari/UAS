package com.cg.uas.utility;

public interface QueryMapper {

	public static final String users = "Select user from Users user where user.loginId=:ploginid and"
			+ " user.password=:ppwd and role=:prole";
	public static final String programs = "Select programs from ProgramsScheduled programs";

	public static final String programDetails = "SELECT e FROM ProgramsOffered e WHERE e.programName=:pname";

	public static final String application = "SELECT e FROM Application e WHERE e.applicationId=:pappid";

	public static final String applications = "SELECT e FROM Application e WHERE e.scheduledProgramId=:pappid";

	public static final String programsScheduled = "SELECT e FROM ProgramsScheduled e WHERE e.scheduledProgrammeId=:ppid";

	public static final String deletePrograms = "DELETE FROM ProgramsScheduled c WHERE c.scheduledProgrammeId=:p";

}
