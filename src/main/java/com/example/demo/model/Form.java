package com.example.demo.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class Form {

	private final UUID formId;
	private Date date;
	private Integer mood;
	private String moodText;
	private Integer activityLevel;
	private Integer morningLow;
	private String sleepDisorder;
	private Integer sleepQuality;
	private Integer appetit;
	private Integer otherBodySymptoms;
	private Integer thoughtsOfSuicide;
	private List<String> drugs;
	private List<Integer> dosesOfMedication;

	public Form(UUID formId, Date date, Integer mood, String moodText, Integer activityLevel, Integer morningLow,
			Integer sleep_quality, String sleepDisorder, Integer appetit, Integer otherBodySymptoms,
			Integer thoughtsOfSuicide, List<String> drugs, List<Integer> dosesOfMedication) {

		this.formId = formId;
		this.date = date;
		this.moodText = moodText;
		this.activityLevel = activityLevel;
		this.mood = mood;
		this.morningLow = morningLow;
		this.sleepQuality = sleep_quality;
		this.sleepDisorder = sleepDisorder;
		this.appetit = appetit;
		this.otherBodySymptoms = otherBodySymptoms;
		this.thoughtsOfSuicide = thoughtsOfSuicide;
		this.drugs = drugs;
		this.dosesOfMedication = dosesOfMedication;

	}

	public Date getDate() {
		return date;

	}

	public void setDate(Date date) {
		this.date = date;

	}

	public UUID getFormId() {
		return formId;
	}

	public String getSleepDisorder() {
		return sleepDisorder;
	}

	public void setSleepDisorder(String sleepDisorder) {
		this.sleepDisorder = sleepDisorder;
	}

	public String getMoodText() {
		return moodText;
	}

	public Integer getMood() {
		return mood;
	}

	public Integer getActivityLevel() {
		return activityLevel;
	}

	public Integer getMorningLow() {
		return morningLow;
	}

	public Integer getSleepQuality() {
		return sleepQuality;
	}

	public Integer getAppetit() {
		return appetit;
	}

	public Integer getThoughtsOfSuicide() {
		return thoughtsOfSuicide;
	}

	public Integer getOtherBodySymptoms() {
		return otherBodySymptoms;
	}

	public List<String> getDrugs() {
		return drugs;
	}

	public List<Integer> getDosesOfMedication() {
		return dosesOfMedication;
	}

}
