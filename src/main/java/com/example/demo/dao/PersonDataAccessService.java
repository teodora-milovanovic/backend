package com.example.demo.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Form;
import com.example.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Person> selectAllPeople() {

		final String sql = "SELECT id, first_name, last_name, role," + " email, password, gender, role, "
				+ "patient_IDs FROM person";

		return jdbcTemplate.query(sql, mapPersonFromDb());
	}

	@Override
	public List<Form> selectAllForms() {

		final String sql = "SELECT formid, date, mood, moodText,"
				+ " activityLevel, morninglow, sleepQuality, sleepDisorder, "
				+ "appetit, otherBodySymptoms, thoughtsOfSuicide, drugs," + " dosesofmedication FROM form";

		return jdbcTemplate.query(sql, mapFormFromDb());
	}

	@SuppressWarnings("null")
	private RowMapper<Form> mapFormFromDb() {
		return (resultSet, i) -> {
			String idStr = resultSet.getString("formId");
			UUID id = UUID.fromString(idStr);
			Date date = resultSet.getDate("date");
			int mood = resultSet.getInt("mood");
			String moodText = resultSet.getString("moodText");
			int activityLevel = resultSet.getInt("activityLevel");
			int morningLow = resultSet.getInt("morningLow");
			int sleepQuality = resultSet.getInt("sleepQuality");
			String sleepDisorder = resultSet.getString("sleepDisorder");
			int appetit = resultSet.getInt("appetit");
			int otherBodySymptoms = resultSet.getInt("otherBodySymptoms");
			int thoughtsOfSuicide = resultSet.getInt("thoughtsOfSuicide");
			List<String> drugs = Arrays
					.asList(resultSet.getString("drugs").replace("{", "").replace("}", "").split("\\s*,\\s*"));
			List<String> dosesOfMedicationString = Arrays.asList(
					resultSet.getString("dosesOfMedication").replace("{", "").replace("}", "").split("\\s*,\\s*"));
			List<Integer> dosesOfMedication = dosesOfMedicationString.stream().map(Integer::parseInt)
					.collect(Collectors.toList());

			return new Form(id, date, mood, moodText, activityLevel, morningLow, sleepQuality, sleepDisorder, appetit,
					otherBodySymptoms, thoughtsOfSuicide, drugs, dosesOfMedication);
		};
	}

	private RowMapper<Person> mapPersonFromDb() {
		return (resultSet, i) -> {
			String idStr = resultSet.getString("id");
			UUID id = UUID.fromString(idStr);
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String roleStr = resultSet.getString("role").toUpperCase();
			Person.Role role = Person.Role.valueOf(roleStr);
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			String genderStr = resultSet.getString("gender").toUpperCase();
			Person.Gender gender = Person.Gender.valueOf(genderStr);
			List<String> pIds = Arrays
					.asList(resultSet.getString("patient_IDs").replace("{", "").replace("}", "").split("\\s*,\\s*"));
			return new Person(id, firstName, lastName, role, email, password, gender, pIds);
		};
	}

	@Override
	public int insertForm(UUID id, Form form) {

		String sql = "INSERT INTO form (" + " formid, date, mood, moodText, " + " activityLevel, morningLow, "
				+ " sleepQuality, sleepDisorder, " + " appetit, otherBodySymptoms, " + " thoughtsOfSuicide, drugs, "
				+ " dosesOfMedication) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		return jdbcTemplate.update(sql, form.getFormId(), form.getDate(), form.getMood(), form.getMoodText(),
				form.getActivityLevel(), form.getMorningLow(), form.getSleepQuality(), form.getSleepDisorder(),
				form.getAppetit(), form.getOtherBodySymptoms(), form.getThoughtsOfSuicide(),
				createSqlStringArray(form.getDrugs()), createSqlIntegerArray(form.getDosesOfMedication()));
	}

	private java.sql.Array createSqlStringArray(List<String> list) {
		java.sql.Array stringArray = null;
		try {
			stringArray = jdbcTemplate.getDataSource().getConnection().createArrayOf("VARCHAR", list.toArray());

		} catch (SQLException ignore) {
		}
		return stringArray;
	}

	private java.sql.Array createSqlIntegerArray(List<Integer> list) {
		java.sql.Array uuidArray = null;
		try {
			uuidArray = jdbcTemplate.getDataSource().getConnection().createArrayOf("Integer", list.toArray());
		} catch (SQLException ignore) {
		}
		return uuidArray;
	}


}
