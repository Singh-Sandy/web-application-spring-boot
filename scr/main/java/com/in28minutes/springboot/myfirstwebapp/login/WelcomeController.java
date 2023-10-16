package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
//Change the name of class from LoginController to WelcomeController	
//	private AuthenticationService authenticationService;
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

//	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@RequestMapping("login")
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		logger.debug("Request param is {}", name);
//		logger.info("I want this printerd at info level {}", name);
//		logger.warn("I want this printerd at warning level {}", name);
//		System.out.println("Request param is " +  name);
//		return "login";
//	}

	
//  Remove this because we want Spring security to handle login functionality
	
//	@RequestMapping(value="login", method = RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}
	
	//Changed the name of method from gotoLoginPage to gotoWelcomePage
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
//	@RequestMapping(value="login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);
////			model.put("password", password);
//			return "welcome";
//		}
//		
//		model.put("errorMessage", "Invalid Credentials! Please try again.");
//		return "login";
//	}
}
