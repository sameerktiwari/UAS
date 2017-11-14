package com.cg.uas.controller;

import static com.cg.uas.utility.UASConstants.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.log4j.Logger;

import com.cg.uas.entities.Application;
import com.cg.uas.entities.Participant;
import com.cg.uas.entities.ProgramsOffered;
import com.cg.uas.entities.ProgramsScheduled;
import com.cg.uas.entities.Users;
import com.cg.uas.exception.UniversityException;
import com.cg.uas.service.IService;

@Controller
public class UASController {

	private static Logger logger = Logger
			.getLogger(com.cg.uas.dao.DAOImpl.class);

	@Autowired
	private IService service;

	/**
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(@RequestParam("role") String role, Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		users.setRole(role);
		return LOGIN_PAGE;
	}

	/**
	 * @param model
	 * @param users
	 * @param result
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
		model.addAttribute(ERROR_MESSAGE, LOGIN_ERROR_MESSAGE);
		return ERROR_PAGE;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/applicant")
	public String applicant(Model model) {
		return APPLICANT_HOME;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewprgrms")
	public String viewprgrms(Model model) {

		try {
			List<ProgramsScheduled> programsScheduled = service
					.viewProgrammes();
			model.addAttribute("programList", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_ALL_PROGRAMS;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * @param pName
	 * @param pId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/programDetails", method = RequestMethod.GET)
	public String programDetails(@RequestParam("pName") String pName,
			@RequestParam("pId") String pId, Model model) {
		try {
			ProgramsOffered pos = service.getProgramsOffered(pName);
			model.addAttribute("prog", pos);
			model.addAttribute("pId", pId);
			return VIEW_PROGRAM_DETAILS;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * @param pId
	 * @param model
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
	 * @param app
	 * @param result
	 * @param model
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
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * @return
	 */
	@RequestMapping("/viewstatus")
	public String viewstatus() {
		return VIEW_STATUS;
	}

	/**
	 * @param appId
	 * @param model
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
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewapps")
	public String viewapps(Model model) {
		try {
			List<ProgramsScheduled> programsScheduled = service
					.viewProgrammes();
			model.addAttribute("programList", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_PROGRAMS_FOR_MAC;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * @param model
	 * @param ProgramsScheduled
	 * @param result
	 * @return
	 */
	@RequestMapping("/viewApplications")
	public String viewapplications(
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
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;
		}
	}

	/**
	 * @param model
	 * @param app
	 * @param result
	 * @return
	 */
	@RequestMapping("/viewApplication")
	public String viewapplication(Model model,
			@ModelAttribute("Application") Application app, BindingResult result) {
		model.addAttribute("applicant", app);
		return VIEW_APPLICATION;
	}

	/**
	 * @param appId
	 * @param status
	 * @param model
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
	 * @param model
	 * @param app
	 * @param result
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
			model.addAttribute("applicant", app);
			return VIEW_APPLICATION;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewAdminPrgrms")
	public String viewAdminPrgrms(Model model) {
		try {
			List<ProgramsScheduled> programsScheduled = service
					.viewProgrammes();
			model.addAttribute("programList", programsScheduled);
			ProgramsScheduled programs = new ProgramsScheduled();
			model.addAttribute("ProgramsScheduled", programs);
			return VIEW_PROGRAMS_FOR_ADMIN;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * @param pId
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatePrgrm")
	public String updatePrgrm(@RequestParam("pId") String pId, Model model) {
		try {
			ProgramsScheduled programsScheduled = service.getProgram(pId);
			model.addAttribute("prog", programsScheduled);
			ProgramsScheduled program = new ProgramsScheduled();
			model.addAttribute("programsScheduled", program);
			return UPDATE_PROGRAM;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;

		}
	}

	/**
	 * @param programsScheduled
	 * @param model
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
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;

		}

	}

	/**
	 * @param pId
	 * @param model
	 * @return
	 */
	@RequestMapping("/deletePrgrm")
	public String deletePrgrm(@RequestParam("pId") String pId, Model model) {
		try {
			int status = service.deleteProgram(pId);
			if (status == 1) {
				model.addAttribute("message", "Program with Id " + pId
						+ " successfully deleted");
			}
			return ADMIN_HOME;
		} catch (UniversityException e) {
			logger.error(e);
			model.addAttribute(ERROR_MESSAGE, e.getMessage());
			return ERROR_PAGE;

		}
	}

}
