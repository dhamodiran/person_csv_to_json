package com.person.app.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.person.app.beans.PersonJsonConfiguration;

public class JsonToPersonConfigurarion {
	
	List<PersonJsonConfiguration> jsonConfigList = null;
	
	public List<PersonJsonConfiguration>  readJsonConfig() {
		
		jsonConfigList = new ArrayList<>();
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("resources/config.json"))
        {
        	
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
 
            JSONArray configList = (JSONArray) obj.get("configs");
             
            //Iterate over config array
            configList.forEach( config -> parseConfigObject( (JSONObject) config ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonConfigList;
		
	}
	 private void parseConfigObject(JSONObject config) 
	    {
	         PersonJsonConfiguration personConfig = new PersonJsonConfiguration();
	        //Get config csv attribute
	        String csv_attr = (String) config.get("csv_attr");    
	        personConfig.setCsvAttribute(csv_attr);
	         
	        //Get config type
	        String type = (String) config.get("type");  
	        personConfig.setType(type);
	         
	        //Get config json attribute
	        String json_attr = (String) config.get("json_attr");    
	        personConfig.setJsonAttribute(json_attr);
	        
	        jsonConfigList.add(personConfig);
	    }
	 
	 
}
