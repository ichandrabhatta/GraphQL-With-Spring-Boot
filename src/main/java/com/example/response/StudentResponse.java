package com.example.response;

import com.example.entity.Student;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class StudentResponse {

	private Integer id;


	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<SubjectResponse> learningSubjects;

	private Student student;

	private String fullName;


	public StudentResponse (Student student) {
		this.student = student;
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();

		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();

	}

}
