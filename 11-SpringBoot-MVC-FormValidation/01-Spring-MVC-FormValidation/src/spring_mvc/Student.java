package spring_mvc;

import java.util.HashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private HashMap<String, String> countryOptions;
	private String language;
	private HashMap<String, String> languageOptions;
	private String[] os; 
	
	public Student() {
		// populate the country options
		countryOptions = new HashMap<>();	
		countryOptions.put("Romania", "Romania");
		countryOptions.put("Spain", "Spain");
		countryOptions.put("Dinmark", "Dinmark");
		countryOptions.put("Germany", "Germany");
		countryOptions.put("Austria", "Austria");
		
		// popolate the language options
		languageOptions = new HashMap<>(); 
		languageOptions.put("Java", "Java");
		languageOptions.put("Angular", "Angular");
		languageOptions.put("Python", "Python");
		languageOptions.put("JavaScript", "JavaScript");
		languageOptions.put("PHP", "PHP");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public HashMap<String, String> getCountryOptions() {
		return countryOptions;
	}		

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public HashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public String[] getOs() {
		return os;
	}

	public void setOs(String[] os) {
		this.os = os;
	}
	
}
