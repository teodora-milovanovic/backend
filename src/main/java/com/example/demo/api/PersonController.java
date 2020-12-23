package com.example.demo.api;

import java.sql.Date;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Form;
import com.example.demo.model.Person;
import com.example.demo.service.FormService;
import com.example.demo.service.PersonService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	private final PersonService personService;
	private final FormService formService;

	@Autowired
	public PersonController(PersonService personService, FormService formService) {
		this.personService = personService;
		this.formService = formService;
	}

	@PostMapping("form")
	public void addForm(@RequestBody Form form) {
		Date date = Date.valueOf(LocalDate.now());
		form.setDate(date);
		formService.addForm(form);
	}

	@GetMapping
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}

	@GetMapping("form")
	public List<Form> getAllForms() {
		System.out.print("forms" + formService.getAllForms().size());
		return formService.getAllForms();
	}

}
