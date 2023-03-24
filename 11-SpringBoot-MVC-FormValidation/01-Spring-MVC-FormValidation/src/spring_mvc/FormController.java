package spring_mvc;

import javax.servlet.http.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class FormController {

//	 method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "form";
	}
	
	// proccess the form
	@RequestMapping("/processedForm")
	public String processedForm(){
		return "processed-form";
	}
	
	//////////////////////////////////////////////////////
	@RequestMapping("/showForm2")
	public String showForm2() {
		return "form2";
	}
	
	// read form data and add to model
	@RequestMapping("/processedFormV2")
	public String letsCapitalizeName(HttpServletRequest request, Model model) {
		// read the request parameter from the html form
		String theName = request.getParameter("studentName");
		// convert the data
		if(theName != null || theName != "") {
			theName = theName.toUpperCase();
		}
		// create the message
		String result = "Result : " + theName;
		// add model to the model
		model.addAttribute("message", result);
		
		return "processed-form2";
	}
	
	////////////////////////////////////////////////////////
	@RequestMapping("/showForm3")
	public String showForm3() {
		return "form3";
	}
	
	// request param
	@RequestMapping("/processedFormV3")
	public String processFormV3(@RequestParam("studentName") String theName, Model model) {
		// convert the data
		if(theName != null || theName != "") {
			theName = theName.toLowerCase();
		}
		// create the message
		String result = "Result 3: " + theName;
		// add model to the model
		model.addAttribute("message", result);
		
		return "processed-form3";
	}
}
