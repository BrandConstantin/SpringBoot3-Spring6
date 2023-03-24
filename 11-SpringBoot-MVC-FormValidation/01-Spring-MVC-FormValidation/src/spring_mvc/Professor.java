package spring_mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import spring_mvc.validation.CourseCode;

public class Professor {
	@NotNull(message="Name is required")
	@Size(min=4, message="Name most have more than 4 caracters")
	private String firstName;
	
	@NotNull(message="Surname is required")
	@Size(min=4, message="Surname most have more than 4 caracters")
	private String lastName;
	
	@NotNull(message="Cualification is required")
	@Min(value=1, message="Must be gratear than or equal to 1")
	@Max(value=10, message="Must be less than or igual to 10")
	private Integer cualification;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Only 5 chars/digits")
	private String postalCode;
	
	@CourseCode
	private String courseCode;
	
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
	public Integer getCualification() {
		return cualification;
	}
	public void setCualification(Integer cualification) {
		this.cualification = cualification;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}	
	
}
