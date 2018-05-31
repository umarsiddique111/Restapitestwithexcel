package com.excelunit.test.Excelunittest;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Stringsplitmethod {

	
	public String[] splitstr (String parametr){
		
	
		String[] params = parametr.split(",");
		String part1 = params[0];
		String part2 = params[1];
		String part3 = params[2];
		
		String[] path = part1.split("=");
		String pathreal= path[1];
	
		

		String[] date1 = part2.split("=");
		String asOfDate= date1[1];
	
		
		String[] name = part3.split("=");
		String realname= name[1];
	

		String[] array = {pathreal,asOfDate,realname};
		
		return array;
		
		
		
	}
	

}
