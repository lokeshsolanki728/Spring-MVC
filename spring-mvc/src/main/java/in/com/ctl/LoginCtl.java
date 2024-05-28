package in.com.ctl;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.com.dto.UserDTO;
import in.com.form.LoginForm;
import in.com.service.UserService;


@Controller
@RequestMapping(value = "LoginCtl")
public class LoginCtl {

	@Autowired
	public UserService service;

	@GetMapping
	public String display(@ModelAttribute("form") LoginForm form, Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			session.invalidate();
			model.addAttribute("success", "Logout successfully");
		}
		return "Login";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") @Valid LoginForm form, BindingResult bindingResult,
			@RequestParam(required = false) String operation, Model model, HttpSession session) {

		if (operation.equals("signUp")) {
			return "redirect:UserRegistrationCtl";
		}

		if (bindingResult.hasErrors()) {
			return "Login";
		}

		
		UserDTO dto = service.auth(form.getLoginId(), form.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			return "redirect:/WelcomeCtl";
		} else {
			model.addAttribute("error", "Login & Password Invalid...!!!");
			return "Login";
		}
	}
}