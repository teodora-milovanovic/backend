package com.example.demo.model;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private final UUID id;

	@NotBlank
	private final String firstName;

	@NotBlank
	private final String lastName;

	@NotBlank
	private final String email;

	@NotBlank
	private final String password;

	@NotBlank
	private final Role role;

	@NotNull
	private final Gender gender;

	private final List<String> patientIds;

	public Person(@JsonProperty("id") UUID id, @JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName, @JsonProperty("role") Role role,
			@JsonProperty("email") String email, @JsonProperty("password") String password,
			@JsonProperty("gender") Gender gender, @JsonProperty("patientIds") List<String> patientIds) {

		this.patientIds = patientIds;
		this.password = password;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.gender = gender;

	}

	public UUID getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Role getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Gender getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", role='" + role + '\'' + ", email='" + email + '\'' + ", gender=" + gender + '}';
	}

	public List<String> getPatientIds() {
		return patientIds;
	}

	public enum Role {
		D, P
	}

	public enum Gender {
		M, F
	}

}