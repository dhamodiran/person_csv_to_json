package com.person.app;

import java.util.List;

import com.person.app.beans.Person;
import com.person.app.beans.PersonJsonConfiguration;
import com.person.app.config.CsvToPerson;
import com.person.app.config.JsonToPersonConfigurarion;
import com.person.app.config.PersonToJson;

public class PersonApplication {

	public static void main(String[] args) {
		
		System.out.println("CSV to JSON conversion application");
		
		//parse config.jason file
		JsonToPersonConfigurarion jsonConfig = new JsonToPersonConfigurarion();
		List<PersonJsonConfiguration> jsonConfigList = jsonConfig.readJsonConfig();
		
		//convert person.csv to person java bean
		CsvToPerson  csvtoPerson = new CsvToPerson();
		List<Person> personsList = csvtoPerson.csvToPersonConversion();
		
		//convert java bean to JSON
		PersonToJson personToJson = new PersonToJson();
		personToJson.beanToJson(personsList,jsonConfigList);

	}
	
	

}
