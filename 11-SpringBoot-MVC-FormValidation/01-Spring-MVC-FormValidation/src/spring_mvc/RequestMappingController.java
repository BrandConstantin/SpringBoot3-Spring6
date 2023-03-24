package spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingController {
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "form";
	}
}
