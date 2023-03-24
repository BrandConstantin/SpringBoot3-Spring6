package spring_mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	// eliminate white space from inputs
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimm = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimm);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("professor", new Professor());
		
		return "professor-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("professor") Professor theProfessor, BindingResult theBindingRes) {
		if(!theBindingRes.hasErrors()) {
			return "professor-confirmation";
		}else {
			return "professor-form";
		}
		
	}
}
