package com.cg.uas.controller;

import static com.cg.uas.utility.UASConstants.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.Users;
import com.cg.uas.exception.UniversityException;
import com.cg.uas.service.UASService;

@Controller
public class UASController {

	private static Logger logger = Logger
			.getLogger(com.cg.uas.dao.UASDAOImpl.class);

	@Autowired
	private UASService service;

	/**
	 * Gets the role of the user
	 * 
	 * @param role
	 *            - Stores the user's role
	 * @param model
	 *            - Contains user information
	 * @return
	 */
	@RequestMapping("/login")
	public String getRole(@RequestParam("role") String role, Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		users.setRole(role);
		return LOGIN_PAGE;
	}

	/**
	 * Validates the username and password
	 * 
	 * @param model
	 *            - Contains the error message if any
	 * @param users
	 *            - Contains user information passed through the form
	 * @param result
	 *            - Used to handle bean validation errors
	 * @return
	 */
	@RequestMapping("/validate")
	public String validate(Model model, @ModelAttribute("users") Users users,
			BindingResult result) {
		if (result.hasErrors()) {
			return LOGIN_PAGE;
		}
		if (!service.validate(users)) {
			return users.getRole();
		}
		model.addAttribute(ERROR_MESSAGE_NAME, LOGIN_ERROR_MESSAGE);
		return ERROR_PAGE;
	}

	/**
	 * Show the applicant home page
	 * 
	 * @return
	 */
	@RequestMapping("/applicant")
	public String showApplicantHome() {
		return APPLICANT_HOME;
	}

	/**
	 * Views all the programs
	 * 
	 * @param model
	 *            - Contains the programs scheduled list or error message
	 * @return
	 */
	@RequestMapping("/viewprgrms")
	public String viewPrograms(Model model) {

		try {
			List<ProgramsScheduled> programsScheduled = service
					.viewProgrammes();
			model.addAttribute("programList", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_ALL_PROGRAMS;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * View Program details
	 * 
	 * @param pName
	 *            - Contains the scheduled program name
	 * @param pId
	 *            - Contains the scheduled program id
	 * @param model
	 *            - Contains the program details and scheduled program id
	 * @return
	 */
	@RequestMapping(value = "/programDetails", method = RequestMethod.GET)
	public String viewProgramDetails(@RequestParam("pName") String pName,
			@RequestParam("pId") String pId, Model model) {
		try {
			ProgramsOffered pos = service.getProgramsOffered(pName);
			model.addAttribute("prog", pos);
			model.addAttribute("pId", pId);
			return VIEW_PROGRAM_DETAILS;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * Applying for a program
	 * 
	 * @param pId
	 *            - Contains the program id to which applicant is applying
	 * @param model
	 *            - Passing the applicant details, program id and domains
	 *            available to another page
	 * @return
	 */
	@RequestMapping("/apply")
	public String apply(@RequestParam("pId") String pId, Model model) {
		Application app = new Application();
		model.addAttribute("pId", pId);
		model.addAttribute("domainlist", DOMAINS);
		model.addAttribute("Application", app);
		return APPLICATION;
	}

	/**
	 * Adds an applicant for a program
	 * 
	 * @param app
	 *            - Contains the applicant information entered by applicant
	 * @param result
	 *            - Used to handle bean validation errors
	 * @param model
	 *            - Passing the applicant details or error message to next page
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("Application") @Valid Application app,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("Application", app);
			return APPLICATION;
		}
		try {
			Application ap = service.save(app);
			model.addAttribute("applicant", ap);
			return SUCCESS_PAGE;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * Shows the status of an application
	 * 
	 * @return
	 */
	@RequestMapping("/viewstatus")
	public String showStatus() {
		return VIEW_STATUS;
	}

	/**
	 * Gets the status of the application
	 * 
	 * @param appId
	 *            - Contains the application id of the applicant
	 * @param model
	 *            - Passing the applicant details or error message to the next
	 *            page
	 * @return
	 */
	@RequestMapping("/getStatus")
	public String getStatus(@RequestParam("appId") String appId, Model model) {
		try {
			Application app = service.getStatus(Integer.parseInt(appId));
			model.addAttribute("applicant", app);
			return VIEW_STATUS;

		} catch (UniversityException | NumberFormatException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * Show programs for MAC
	 * 
	 * @param model
	 *            - Passing the list of programs scheduled or error message to
	 *            the next page
	 * @return
	 */
	@RequestMapping("/viewapps")
	public String showPrograms(Model model) {
		try {
			List<ProgramsScheduled> programsScheduled = service
					.viewProgrammes();
			model.addAttribute("programList", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_PROGRAMS_FOR_MAC;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * Shows applications for a Program Scheduled
	 * 
	 * @param model
	 *            - Passing the list of applications or error message to the
	 *            next page
	 * @param ProgramsScheduled
	 *            - Contains the program details of which applications have to
	 *            be viewed
	 * @param result
	 *            - Used to handle bean validation errors
	 * @return
	 */
	@RequestMapping("/viewApplications")
	public String showApplications(
			Model model,
			@ModelAttribute("ProgramsScheduled") ProgramsScheduled ProgramsScheduled,
			BindingResult result) {

		try {
			List<Application> applications = service
					.getApplicant(ProgramsScheduled.getScheduledProgrammeId());
			model.addAttribute("appList", applications);
			if (applications.isEmpty())
				throw new UniversityException("No applications submitted");
			Application app = new Application();
			model.addAttribute("Application", app);
			return VIEW_APPLICATIONS_FOR_A_PROGRAM;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * Shows an application
	 * 
	 * @param model
	 *            - Passing the applicant details to the next page
	 * @param app
	 *            - Contains the applicant details
	 * @param result
	 *            - Used to handle bean validation errors
	 * @return
	 */
	@RequestMapping("/viewApplication")
	public String showApplication(Model model,
			@ModelAttribute("Application") Application app, BindingResult result) {
		model.addAttribute("applicant", app);
		return VIEW_APPLICATION;
	}

	/**
	 * Updates the status of an applicant
	 * 
	 * @param appId
	 *            - Contains the application id of which application status has
	 *            to be updated
	 * @param status
	 *            - Contains the status to which status should be updated to
	 * @param model
	 *            - Passing the applicant details or error message to the next
	 *            page
	 * @return
	 */
	@RequestMapping("/updateStatus")
	public String updateStatus(@RequestParam("appId") int appId,
			@RequestParam("status") String status, Model model) {
		try {
			Application app = service.getStatus(appId);
			if (("Pending").equals(app.getStatus())) {
				if (("Accepted").equals(status)) {
					model.addAttribute("showDOI", "y");
					model.addAttribute("applicant", app);
					Application application = new Application();
					model.addAttribute("Application", application);
					return "viewApplication";
				} else if (("Rejected").equals(status)) {
					app = service.modify(app, status);
					model.addAttribute("msg", "Application " + appId
							+ " rejected");
					model.addAttribute("applicant", app);
					return "viewApplication";
				} else {
					model.addAttribute("msg", "Not Applicable");
					model.addAttribute("applicant", app);
					return "viewApplication";
				}
			} else if (("Accepted").equals(app.getStatus())) {
				if (("Confirmed").equals(status)) {
					if (app.getDateOfInterview().before(
							Date.valueOf(LocalDate.now()))) {
						Participant ppt = new Participant(app.getEmail(),
								app.getApplicationId(), Integer.parseInt(app
										.getScheduledProgramId()));
						service.addParticipant(ppt);
						app = service.modify(app, status);
						model.addAttribute("applicant", app);
						model.addAttribute("msg", "Applicant Confirmed");
						model.addAttribute("applicant", app);
						return "viewApplication";
					} else {
						model.addAttribute("msg", "Pending Interview Results");
						model.addAttribute("applicant", app);
						return "viewApplication";
					}
				} else if (("Rejected").equals(status)) {
					if (app.getDateOfInterview().before(
							Date.valueOf(LocalDate.now()))) {
						app = service.modify(app, status);
						model.addAttribute("msg", "Application " + appId
								+ " rejected");
						model.addAttribute("applicant", app);
						return "viewApplication";
					} else {
						model.addAttribute("msg", "Pending Interview Results");
						model.addAttribute("applicant", app);
						return "viewApplication";
					}
				} else {
					model.addAttribute("msg", "Not Applicable");
					model.addAttribute("applicant", app);
					return "viewApplication";
				}
			} else {
				model.addAttribute("msg", "Not Applicable");
				model.addAttribute("applicant", app);
				return "viewApplication";
			}
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}

	/**
	 * Sets the interview date of an applicant
	 * 
	 * @param model
	 *            - Passing the applicant details or error message to the next
	 *            page
	 * @param app
	 *            - Contains the applicant details of which interview date has
	 *            to be set
	 * @param result
	 *            - Used to handle bean validation errors
	 * @return
	 */
	@RequestMapping(value = "/setInterview", method = RequestMethod.POST)
	public String setInterview(Model model,
			@ModelAttribute("Application") @Valid Application app,
			BindingResult result) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("applicant", app);
				model.addAttribute("showDOI", "y");
				return VIEW_APPLICATION;
			}
			app = service.modify(app, "Accepted");
			model.addAttribute("applicant", app);
			model.addAttribute("msg", "Application " + app.getApplicationId()
					+ " accepted and Interview Scheduled");
			return VIEW_APPLICATION;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * Shows programs for Admin
	 * 
	 * @param model
	 *            - Passing the list of programs scheduled or error message to
	 *            the next page
	 * @return
	 */
	@RequestMapping("/viewAdminPrgrms")
	public String showAdminPrograms(Model model) {
		try {
			List<ProgramsScheduled> programsScheduled = service
					.viewProgrammes();
			model.addAttribute("programList", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_PROGRAMS_FOR_ADMIN;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * Loads the update program schedule page
	 * 
	 * @param pId
	 *            - Contains the scheduled program id on which updation is to be
	 *            done
	 * @param model
	 *            - Passing the scheduled program details to the next page
	 * @return
	 */
	@RequestMapping("/updatePrgrm")
	public String loadUpdateProgram(@RequestParam("pId") String pId, Model model) {
		try {
			ProgramsScheduled programsScheduled = service.getProgram(pId);
			model.addAttribute("prog", programsScheduled);
			ProgramsScheduled program = new ProgramsScheduled();
			model.addAttribute("programsScheduled", program);
			return UPDATE_PROGRAM;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * Updates the program schedule
	 * 
	 * @param programsScheduled
	 *            - Contains the updated scheduled program details
	 * @param model
	 *            - Passing the message to the next page
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("programsScheduled") @Valid ProgramsScheduled programsScheduled,
			Model model) {
		try {
			ProgramsScheduled programs = service.modify(programsScheduled);
			model.addAttribute("message",
					"Program with Id " + programs.getScheduledProgrammeId()
							+ " successfully modified");
			return ADMIN_HOME;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;

		}

	}

	/**
	 * Delete a program schedule
	 * 
	 * @param pId
	 *            - Contains the scheduled program id which is to be deleted
	 * @param model
	 *            - Passing the message to the next page
	 * @return
	 */
	@RequestMapping("/deletePrgrm")
	public String deleteProgram(@RequestParam("pId") String pId, Model model) {
		try {
			int status = service.deleteProgram(pId);
			if (status == 1) {
				model.addAttribute("message", "Program with Id " + pId
						+ " successfully deleted");
			}
			return ADMIN_HOME;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE_NAME, e.getMessage());
			return ERROR_PAGE;

		}
	}

}
