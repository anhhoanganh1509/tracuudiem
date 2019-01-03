package vn.springhibernate.hoanganh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.springhibernate.hoanganh.model.Student;
import vn.springhibernate.hoanganh.model.Users;
import vn.springhibernate.hoanganh.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(value = {"/","login"}, method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}
	
	@RequestMapping(value="/jsp/index")
	public String adminPages(Authentication authentication, Model model) {
		Student info = uService.finbyStudentId(authentication.getName());
		
		if(info.getDaxoa() == 1) {
			model.addAttribute("infoStudent",info);
			return "jsp/index";
		}else {
			return "jsp/changePass";
		}		
	}

	@RequestMapping(value = "/registerAccount", method = RequestMethod.GET)
    public String Register(Model model){	
		model.addAttribute("createNewUser", new Users());
        return "register";
    }

	@RequestMapping(value = "/createNewUser", method = RequestMethod.POST)
    public String CreateNewUser(Users u, Model model){
		Long email = uService.countCheckMail(u.getEmail());
		Long userName = uService.countCheckMaSo(u.getUsername());
		if(email == 0 && userName == 0) {
			uService.CreateNewUser(u);
			model.addAttribute("msg", "Please check your email.");
	        return "login";
		}else {
			model.addAttribute("error", "Invalid email or student number!");
			model.addAttribute("createNewUser", new Users());
	        return "register";
		}
    }
	
	@RequestMapping(value = "/activeUser/{id}", method = RequestMethod.GET)
    public String ActiveUser(@PathVariable String id, Model model){
		Users u = uService.finbyId(id);
		uService.ActiveUser(u);
		model.addAttribute("msg", "Activation account success.");
        return "login";
    }
	
	@RequestMapping(value = "/checkEmail")
	public void ajaxCheckEmail(Model model,
				@RequestParam("emailname") String emailname, HttpServletResponse response) throws IOException{
		Long email = uService.countCheckMail(emailname);
		try {
			if(email == 0) {
				response.getWriter().write("available");
			}else {
				response.getWriter().write("not-available");
			}
		}catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	@RequestMapping(value = "/changePass", method = RequestMethod.GET)
    public String ChangePass(){			
        return "jsp/changePass";
    }

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String ChangePassword(@RequestParam(value = "newPass", defaultValue = "") String newPass,Authentication au,
    		@RequestParam(value = "repeatPass", defaultValue = "") String repeatPass, Model model){		
		if(newPass.equals(repeatPass) && newPass != null) {
			uService.UpdatePass(newPass, au.getName());
	        return "redirect:/jsp/index";
		}else {
			model.addAttribute("error", "Invalid email or student number!");
	        return "jsp/changePass";
		}
    }
}
