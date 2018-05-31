package com.excelunit.test.Excelunittest;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import jxl.Sheet;
import jxl.read.biff.BiffException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelunittestApplicationTests {
	
	
	private final static Logger logger = Logger.getLogger(ExcelunittestApplication.class.getName());
	 
	
	@Test 
	public void postapitest() throws BiffException, IOException {
	    String FilePath ="D:\\detail.xls";
	    ReadExcelFile readExcelFile = new ReadExcelFile();
		Sheet resd = readExcelFile.readExcel(FilePath);
		String url = resd.getCell(1, 1).getContents();
		String parametr = resd.getCell(3, 1).getContents();
		Stringsplitmethod stringsplitmethod = new Stringsplitmethod();
		stringsplitmethod.splitstr(parametr);
		String[] array = stringsplitmethod.splitstr(parametr);
	
MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        File file = new File(array[0]);
        bodyMap.add("user-file",new FileSystemResource(file));
        bodyMap.add("asOfDate",array[1]);
        bodyMap.add("name",array[2]);
		
		UploadClient uploadClient = new UploadClient();
		String result = uploadClient.uploadfile(url,bodyMap);
		
		logger.log(Level.INFO, "check reuslt"+result);
		assertEquals("File uploaded succefully", result);

}		
	@Test
	public void getapitestparam() throws BiffException, IOException {
		String FilePath ="D:\\detail.xls";
		ReadExcelFile readExcelFile1 = new ReadExcelFile();
		Sheet res = readExcelFile1.readExcel(FilePath);
		String url = res.getCell(1, 2).getContents();
		RestTemplate resttemplate = new RestTemplate();
		String name = "saleem";
		String result1 = resttemplate.getForObject(url, String.class, name);
		logger.log(Level.INFO, "check getapitestparam reuslt"+result1);
		assertEquals("get succeful run parameter!!!"+name, result1);
		
	}
	@Test 
	public void getapitest() throws BiffException, IOException {
		String FilePath ="D:\\detail.xls";
		ReadExcelFile readExcelFile1 = new ReadExcelFile();
		Sheet res = readExcelFile1.readExcel(FilePath);
		String url = res.getCell(1, 3).getContents();
		RestTemplate resttemplate = new RestTemplate();
		String result2 = resttemplate.getForObject(url, String.class);
		logger.log(Level.INFO, "check getapitest result"+result2);
		assertEquals("Check Get Controller", result2);
	}
		

}
