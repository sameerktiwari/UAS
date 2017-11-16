package com.cg.uas.controller;

/************************************************************************************
 * File:        UASController.java
 * Package:     com.cg.uas.controller
 * Description: Controller class for University Admission System that handles all 
 * 				client requests and responses after performing necessary operations
 * Version:     1.0
 * Modifications:
 * Author: Group5      Date: 14th-Nov-2017      Change Description:
 ************************************************************************************/
import static com.cg.uas.utility.UASConstants.ADMIN_HOME;
import static com.cg.uas.utility.UASConstants.ADMIN_ROLE;
import static com.cg.uas.utility.UASConstants.APPLICANT_HOME;
import static com.cg.uas.utility.UASConstants.APPLICATION;
import static com.cg.uas.utility.UASConstants.ERROR_MESSAGE_NAME;
import static com.cg.uas.utility.UASConstants.ERROR_PAGE;
import static com.cg.uas.utility.UASConstants.HOME_PAGE;
import static com.cg.uas.utility.UASConstants.LOGIN_ERROR_MESSAGE;
import static com.cg.uas.utility.UASConstants.LOGIN_PAGE;
import static com.cg.uas.utility.UASConstants.MAC_ROLE;
import static com.cg.uas.utility.UASConstants.SUCCESS_PAGE;
import static com.cg.uas.utility.UASConstants.UPDATE_PROGRAM;
import static com.cg.uas.utility.UASConstants.VIEW_ALL_PROGRAMS;
import static com.cg.uas.utility.UASConstants.VIEW_APPLICATION;
import static com.cg.uas.utility.UASConstants.VIEW_APPLICATIONS_FOR_A_PROGRAM;
import static com.cg.uas.utility.UASConstants.VIEW_PROGRAMS_FOR_ADMIN;
import static com.cg.uas.utility.UASConstants.VIEW_PROGRAMS_FOR_MAC;
import static com.cg.uas.utility.UASConstants.VIEW_PROGRAM_DETAILS;
import static com.cg.uas.utility.UASConstants.VIEW_STATUS;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.User;
import com.cg.uas.exception.UniversityException;
import com.cg.uas.service.UASService;

@SessionAttributes("users")
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
	public String getRole(Model model, HttpSession session) {
		session.invalidate();
		User users = new User();
		model.addAttribute("users", users);
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
	public String validate(Model model, @ModelAttribute("users") User users,
			HttpSession session, BindingResult result) {
		if (result.hasErrors()) {
			return LOGIN_PAGE;
		}
		if (!service.validate(users)) {
			session.setAttribute("users", users);
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
			model.addAttribute("programs", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_ALL_PROGRAMS;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
		if (!pId.isEmpty())
			model.addAttribute("pId", pId);
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
			service.getProgram(app.getScheduledProgramId());
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
			return APPLICATION;
		}
		try {
			Application ap = service.save(app);
			model.addAttribute("applicant", ap);
			return SUCCESS_PAGE;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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

		} catch (UniversityException | NumberFormatException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
	public String showPrograms(Model model, HttpSession session) {

		try {
			service.checkUser(session, MAC_ROLE);
			List<ProgramsScheduled> programsScheduled = service
					.viewProgrammes();
			model.addAttribute("programs", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_PROGRAMS_FOR_MAC;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
			HttpSession session, BindingResult result) {

		try {
			service.checkUser(session, MAC_ROLE);
			List<Application> applications = service
					.getApplicant(ProgramsScheduled.getScheduledProgrammeId());
			model.addAttribute("apps", applications);
			if (applications.isEmpty())
				throw new UniversityException("No applications submitted");
			Application app = new Application();
			model.addAttribute("Application", app);
			return VIEW_APPLICATIONS_FOR_A_PROGRAM;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
			@ModelAttribute("Application") Application app,
			BindingResult result, HttpSession session) {
		try {
			service.checkUser(session, MAC_ROLE);
			model.addAttribute("applicant", app);
			return VIEW_APPLICATION;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
			return ERROR_PAGE;
		}
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
			@RequestParam("status") String status, HttpSession session,
			Model model) {
		try {
			service.checkUser(session, MAC_ROLE);
			Application app = service.getStatus(appId);
			if (("Pending").equals(app.getStatus())) {
				if (("Accepted").equals(status)) {
					model.addAttribute("showDOI", "y");
					model.addAttribute("applicant", app);
					Application application = new Application();
					model.addAttribute("Application", application);
					return VIEW_APPLICATION;
				} else if (("Rejected").equals(status)) {
					app = service.modify(app, status);
					model.addAttribute(ERROR_MESSAGE_NAME, "Application "
							+ appId + " rejected");
					model.addAttribute("applicant", app);
					return VIEW_APPLICATION;
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
						model.addAttribute(ERROR_MESSAGE_NAME,
								"Applicant Confirmed");
						model.addAttribute("applicant", app);
						return VIEW_APPLICATION;
					}
				} else if (("Rejected").equals(status)) {
					if (app.getDateOfInterview().before(
							Date.valueOf(LocalDate.now()))) {
						app = service.modify(app, status);
						model.addAttribute(ERROR_MESSAGE_NAME, "Application "
								+ appId + " rejected");
						model.addAttribute("applicant", app);
						return VIEW_APPLICATION;
					}
				}
				model.addAttribute(ERROR_MESSAGE_NAME,
						"Pending Interview Results");
				model.addAttribute("applicant", app);
				return VIEW_APPLICATION;
			}
			model.addAttribute(ERROR_MESSAGE_NAME, "Not Applicable");
			model.addAttribute("applicant", app);
			return VIEW_APPLICATION;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
			return ERROR_PAGE;
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
			BindingResult result, HttpSession session) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("applicant", app);
				model.addAttribute("showDOI", "y");
				return VIEW_APPLICATION;
			}
			service.checkUser(session, MAC_ROLE);
			app = service.modify(app, "Accepted");
			model.addAttribute("applicant", app);
			model.addAttribute("msg", "Application " + app.getApplicationId()
					+ " accepted and Interview Scheduled");
			return VIEW_APPLICATION;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
	public String showAdminPrograms(Model model, HttpSession session) {
		try {
			service.checkUser(session, ADMIN_ROLE);
			List<ProgramsScheduled> programsScheduled = service
					.viewProgrammes();
			model.addAttribute("programs", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_PROGRAMS_FOR_ADMIN;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
	public String loadUpdateProgram(@RequestParam("pId") String pId,
			HttpSession session, Model model) {
		try {
			service.checkUser(session, ADMIN_ROLE);
			ProgramsScheduled programsScheduled = service.getProgram(pId);
			model.addAttribute("prog", programsScheduled);
			ProgramsScheduled program = new ProgramsScheduled();
			model.addAttribute("programsScheduled", program);
			return UPDATE_PROGRAM;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
			@ModelAttribute("programsScheduled") ProgramsScheduled programsScheduled,
			HttpSession session, Model model) {
		try {
			service.checkUser(session, ADMIN_ROLE);
			ProgramsScheduled programs = service.modify(programsScheduled);
			model.addAttribute("message",
					"Program with Id " + programs.getScheduledProgrammeId()
							+ " successfully modified");
			return ADMIN_HOME;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
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
	public String deleteProgram(@RequestParam("pId") String pId,
			HttpSession session, Model model) {
		try {
			service.checkUser(session, ADMIN_ROLE);
			int deleted = service.deleteProgram(pId);
			if (1 == deleted) {
				model.addAttribute("message", "Program with Id " + pId
						+ " successfully deleted");
			}
			return ADMIN_HOME;
		} catch (UniversityException exception) {
			logger.error(exception);
			model.addAttribute(ERROR_MESSAGE_NAME, exception.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * @param session
	 *            Contains the current session
	 * @return
	 */
	@RequestMapping("/index")
	public String home(HttpSession session) {
		session.invalidate();
		return HOME_PAGE;
	}

	/**
	 * @param session
	 *            Contains the current session
	 * @return
	 */
	@RequestMapping("/returnHome")
	public String returnHome(HttpSession session) {
		String role = ((User) session.getAttribute("users")).getRole();
		return role;
	}

}
