package de.helloworld.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDto implements Serializable {

	private static final long serialVersionUID = -8821130744182800028L;

	public PersonDto(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PersonDto [firstName=" + firstName + ", "
				+ "lastName=" + lastName + "]";
	}
	
	
}
