package com.person.app.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.person.app.beans.Person;

public class CsvToPerson {

	public List<Person> csvToPersonConversion() {

		
		Reader reader = null;
		
		try {
			reader= new BufferedReader(new FileReader("resources/persons.csv"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		CsvToBean<Person> csvReader = new CsvToBeanBuilder<Person>(reader)
                .withType(Person.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .build();
		
		List<Person> results = csvReader.parse();
		
		System.out.println("----------CSV to Person Beans");
		 
		results.forEach(r-> System.out.println(r));
		
		return results;

	}

}
