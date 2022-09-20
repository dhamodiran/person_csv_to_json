package com.person.app.config;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.person.app.beans.Person;
import com.person.app.beans.PersonJsonConfiguration;

public class PersonToJson {

	private static final String INT = "Int";
	private static final String STRING = "String";
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String AGE = "age";

	public void beanToJson(List<Person> persons, List<PersonJsonConfiguration> configList) {

		JSONArray jsonArray = new JSONArray();
		
		jsonArray.add("Persons:");

		JSONObject jsonObj = null;

		for (Person p : persons) {

			jsonObj = new JSONObject();

			for (PersonJsonConfiguration c : configList) {

				String csvAttribute = c.getCsvAttribute().toLowerCase().replace(" ", "_");

				switch (csvAttribute) {

				case FIRST_NAME -> {
					if (c.getType().equals(STRING))
						jsonObj.put(c.getJsonAttribute(), p.getFirstName());
				}
				case LAST_NAME -> {
					if (c.getType().equals(STRING))
						jsonObj.put(c.getJsonAttribute(), p.getLastName());
				}
				case AGE -> {
					if (c.getType().equals(INT))
						jsonObj.put(c.getJsonAttribute(), p.getAge());
				}

				};

			}

			jsonArray.add(jsonObj);

		}
		
		try {
			jsonArray.writeJSONString(new FileWriter("resources/persons.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("------------JSON OUTPUT-------------");
		System.out.println(jsonArray);
	}


}
