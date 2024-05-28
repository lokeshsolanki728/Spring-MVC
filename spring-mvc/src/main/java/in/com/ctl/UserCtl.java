package in.com.ctl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.com.dto.UserDTO;
import in.com.form.UserForm;
import in.com.service.UserService;

@Controller
@RequestMapping("/ctl/UserCtl")
public class UserCtl {

	@Autowired
	UserService service;

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, Long id, Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		if (id != null && id > 0) {
			UserDTO dto = service.findByPk(id);
			form.setId(dto.getId());
			form.setFirstName(dto.getFirstName());
			form.setLastName(dto.getLastName());
			form.setLoginId(dto.getLoginId());
			form.setPassword(dto.getPassword());
			form.setDob(sdf.format(dto.getDob()));
			form.setAddress(dto.getAddress());
		}
		return "User";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserForm form) {

		UserDTO dto = new UserDTO();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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

		if (form.getId() > 0) {
			dto.setId(form.getId());
			service.update(dto);
		} else {
			service.add(dto);
		}
		return "User";
	}

	@GetMapping("/Search")
	public String display(@ModelAttribute("form") UserForm form, Model model) {
		int pageNo = 1;
		int pageSize = 2;
		List list = service.search(null, pageNo, pageSize);
		model.addAttribute("list", list);
		form.setPazeNo(pageNo);
		return "UserList";
	}

	@PostMapping("/Search")
	public String submit(@ModelAttribute("form") UserForm form, Model model) {
		int pageSize = 2;
		if (form.getOperation().equalsIgnoreCase("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {

				UserDTO delete = new UserDTO();
				form.setPazeNo(1);
				long[] ids = form.getIds();
				for (long id : ids) {
					delete.setId(id);
					service.delete(delete);
				}

			} else {
				model.addAttribute("deletemsg", "Select Atleast one record ");

			}
		}
		if (form.getOperation().equalsIgnoreCase("next")) {
			int pazeNo = form.getPazeNo();
			pazeNo++;
			form.setPazeNo(pazeNo);
		}
		if (form.getOperation().equalsIgnoreCase("previous")) {
			int pazeNo = form.getPazeNo();
			pazeNo--;
			form.setPazeNo(pazeNo);
		}

		UserDTO dto = new UserDTO();
		if (form.getOperation().equalsIgnoreCase("search")) {
			dto.setFirstName(form.getFirstName());
		}
		List list = service.search(dto, form.getPazeNo(), pageSize);
		model.addAttribute("list", list);
		List next = service.search(dto, form.getPazeNo()+1, pageSize);
		model.addAttribute("nextlist", next.size());
		return "UserList";
	}

}
