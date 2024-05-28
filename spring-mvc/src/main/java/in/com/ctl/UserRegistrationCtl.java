package in.com.ctl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.com.dto.UserDTO;
import in.com.form.UserRegistrationForm;
import in.com.service.UserService;

@Controller
@RequestMapping("UserRegistrationCtl")
public class UserRegistrationCtl {

	@Autowired
	UserService service;
	
	@GetMapping
	public String display(@ModelAttribute("form")UserRegistrationForm form) {
		return "UserRegistration";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("form")UserRegistrationForm form) {
		UserDTO dto = new UserDTO();
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		try {
			dto.setDob(sdf.parse(form.getDob()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setAddress(form.getAddress());
		service.add(dto);
		return "UserRegistration";
	}
	
}

