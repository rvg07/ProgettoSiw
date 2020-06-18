package it.uniroma3.siw.taskmanager.controller;

import it.uniroma3.siw.taskmanager.controller.session.SessionData;
import it.uniroma3.siw.taskmanager.controller.validation.CredentialsValidator;
import it.uniroma3.siw.taskmanager.controller.validation.UserValidator;
import it.uniroma3.siw.taskmanager.model.Credentials;
import it.uniroma3.siw.taskmanager.model.User;
import it.uniroma3.siw.taskmanager.repository.CredentialsRepository;
import it.uniroma3.siw.taskmanager.repository.UserRepository;
import it.uniroma3.siw.taskmanager.service.CredentialsService;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CredentialsRepository credentialsRepository;


	@Autowired
	UserValidator userValidator;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	SessionData sessionData;

	@Autowired
	CredentialsService credentialsService;


	@Autowired
	CredentialsValidator credentialsValidator;


	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		User loggedUser = sessionData.getLoggedUser();
		model.addAttribute("user", loggedUser);
		return "home";
	}


	@RequestMapping(value = { "/users/me" }, method = RequestMethod.GET)
	public String me(Model model) {
		User loggedUser = sessionData.getLoggedUser();
		Credentials credentials = sessionData.getLoggedCredentials();
		System.out.println(credentials.getPassword());
		model.addAttribute("user", loggedUser);
		model.addAttribute("credentials", credentials);

		return "userProfile";
	}



	@RequestMapping(value = { "/users/update" }, method = RequestMethod.GET)
	public String update(Model model) {
		User loggedUser = sessionData.getLoggedUser();
		Credentials credentials = sessionData.getLoggedCredentials();
		System.out.println(credentials.getPassword());
		model.addAttribute("loggedUser", loggedUser);
		model.addAttribute("credentials", credentials);

		return "updateProfile";
	}

	@RequestMapping(value = { "/users/update" }, method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("loggedUser") User user ,
			BindingResult loggedUserBindingResult,
			@Valid @ModelAttribute("credentials") Credentials credentials,
			BindingResult credentialsBindingResult,
			Model model) {

		// validate user and credentials fields
		this.userValidator.validate(user, loggedUserBindingResult);
		this.credentialsValidator.validate(credentials, credentialsBindingResult);
		Long idCredentials = sessionData.getLoggedCredentials().getId();
		Long idUser = sessionData.getLoggedUser().getId();

		// if neither of them had invalid contents, store the User and the Credentials into the DB
		if(!loggedUserBindingResult.hasErrors() && ! credentialsBindingResult.hasErrors()) {
			// set the user and store the credentials;
			// this also stores the User, thanks to Cascade.ALL policy
			credentials.setId(idCredentials);
			user.setId(idUser);
			credentials.setUser(user);
			credentialsService.saveCredentials(credentials);
			return "updatesuccesful";
		}
		return "updateProfile";
	}



	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String admin(Model model) {
		User loggedUser = sessionData.getLoggedUser();
		model.addAttribute("user", loggedUser);
		return "admin";
	}


}
