package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Form;
import com.example.demo.model.Person;

public interface PersonDao {

	int insertForm(UUID id, Form form);

	default int insertForm(Form form) {
		UUID id = form.getFormId();
		return insertForm(id, form);
	}

	List<Person> selectAllPeople();

	List<Form> selectAllForms();
}
