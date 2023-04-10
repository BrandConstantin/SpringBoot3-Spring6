package com.spring.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Driver {

	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON and convert to java pojo
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print the data
			System.out.println("First name: " + theStudent.getFirstName());
			System.out.println("Last name: " + theStudent.getLastName());
			System.out.println("Address: " + theStudent.getAddress().getCity());
			
			Address tempAddress = theStudent.getAddress();
			System.out.println("Country: " + tempAddress.getCountry());
			
			for(String tempLang: theStudent.getLanguages()) {
				System.out.print(tempLang + ",");
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
