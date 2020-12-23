package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Form;

@Service
public class FormService {

	@Autowired
	public FormService(@Qualifier("postgres") PersonDao personDao) {
		this.personDao = personDao;

	}

	private final PersonDao personDao;

	public int addForm(Form form) {
		return personDao.insertForm(form);
	}

	public List<Form> getAllForms() {
		return personDao.selectAllForms();
	}
}
