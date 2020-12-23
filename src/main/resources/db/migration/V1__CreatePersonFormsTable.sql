


CREATE TABLE person (
 id UUID NOT NULL PRIMARY KEY,
 first_name VARCHAR(100) NOT NULL,
 last_name VARCHAR(100) NOT NULL,
 role VARCHAR(2) NOT NULL,
 email VARCHAR(100) NOT NULL UNIQUE,
 password VARCHAR(100) NOT NULL,
 gender VARCHAR(2) NOT NULL,
 patient_IDs TEXT[]
);

CREATE TABLE form (
 formId UUID NOT NULL,
 date DATE NOT NULL,
 mood INTEGER NOT NULL,
 moodText VARCHAR(100) NOT NULL,
 activityLevel INTEGER NOT NULL,
 morningLow INTEGER NOT NULL,
 sleepQuality INTEGER NOT NULL,
 sleepDisorder VARCHAR(100) NOT NULL,
 appetit INTEGER NOT NULL,
 otherBodySymptoms INTEGER NOT NULL,
 thoughtsOfSuicide INTEGER NOT NULL,
 drugs TEXT[],
 dosesOfMedication INTEGER[]
);