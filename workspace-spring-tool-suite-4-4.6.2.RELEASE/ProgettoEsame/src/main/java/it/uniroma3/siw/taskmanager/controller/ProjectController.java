package it.uniroma3.siw.taskmanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.taskmanager.controller.session.SessionData;
import it.uniroma3.siw.taskmanager.model.Project;
import it.uniroma3.siw.taskmanager.model.User;
import it.uniroma3.siw.taskmanager.repository.ProjectRepository;
import it.uniroma3.siw.taskmanager.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	public ProjectService projectservice;
	@Autowired
	SessionData sessionData;
	@Autowired
	public ProjectRepository projectrepository;

	@RequestMapping(value = { "/createProject" }, method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute("projectForm", new Project());
		model.addAttribute("user", sessionData.getLoggedUser());
		return "newProject";
	}

	@RequestMapping(value = { "/createProject" }, method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("projectForm") Project project,
			BindingResult projectBindingResult, @Valid @ModelAttribute("user") User user, Model model) {
		project.setOwner(sessionData.getLoggedUser());
		projectservice.saveProject(project);

		return "addSuccesful";
	}

	@RequestMapping(value = { "/showProjectList" }, method = RequestMethod.GET)
	public String showList(Model model) {

		model.addAttribute("projects", projectrepository.findByOwner(sessionData.getLoggedUser()));
		model.addAttribute("user", sessionData.getLoggedUser());
		return "projectList";
	}

	@RequestMapping(value = { "/deleteProject" }, method = RequestMethod.POST)
	public String deleteProject(@ModelAttribute(value = "project") Project project) {
		projectservice.deleteProject(project);

		return "deleted";
	}

	@RequestMapping(value = { "/updateProject/{projectId}" }, method = RequestMethod.GET)
	public String update(Model model, @PathVariable("projectId") Long projectId) {

		model.addAttribute("project", projectservice.getProject(projectId));
		return "updateProject";
	}

	@RequestMapping(value = { "/updateProject/{projectId}" }, method = RequestMethod.POST)
	public String editProject(@ModelAttribute(value = "project") Project project, Model model,
			@PathVariable("projectId") Long projectId) {
		Project edit = projectservice.getProject(projectId);
		edit.setDescription(project.getDescription());
		edit.setName(project.getName());
		projectservice.saveProject(edit);

		return "updated";
	}

}
