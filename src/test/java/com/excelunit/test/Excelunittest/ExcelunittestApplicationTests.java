package com.excelunit.test.Excelunittest;



import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelunittestApplicationTests {
	
	
	private final static Logger logger = Logger.getLogger(ExcelunittestApplication.class.getName());
	 
	private final static String FilePath ="D:\\detail.xls";
	@Test 
	public void postapitest() throws IOException, BiffException  {
	   
	
		
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sheet = wb.getSheet("Sheet1");
	
		 MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
		 List<UserRequest> userlist = new ArrayList<UserRequest>();
		
		 System.out.println("-----------------------"+sheet.getRows());
		 for (int row = 2; row < sheet.getRows(); row++) {
			 Cell[] cells = sheet.getRow(row);
			
					System.out.println(cells[1].getContents());
					System.out.println(cells[2].getContents());
					System.out.println(cells[3].getContents());
					System.out.println(cells[4].getContents());
					
					
					UserRequest request = new UserRequest();
					
							request.setUrl(cells[1].getContents());
							request.setAction(cells[2].getContents());
							request.setParameter(cells[3].getContents());
							request.setConten_type(cells[4].getContents());
							
							userlist.add(request);
							
							String url = request.getUrl();
							String Action = request.getAction();
							String content_type = request.getConten_type();
							String Parameter = request.getParameter();
							String[] param = Parameter.split(",");
							
							System.out.println("i am here at 1");
							for (int i =0;i<param.length; i++) {					
								 String param2 = param[i];
								 
								 if(param2.isEmpty()) {
									 continue;
								 }
								 System.out.println("i am here at 2");
								 System.out.println("parameter lenth"+param.length);
								 System.out.println("this is Split paramter"+ param2);
								 String[] param12 = param2.split("=");
								 String key = param12[0];
								 String value = param12[1];
								
									
							     
							       
							

									
									
								  bodyMap.add(key,value);
							}
							     
						        UploadClient uploadClient = new UploadClient();
								String result = uploadClient.uploadfile(url,bodyMap,Action,content_type);
								System.out.println("body send "+bodyMap);
								System.out.println("My final result "+" "+result);
		 }
		 

		 
		assertEquals("succefully", "succefully");
		
	
		
		
		
	}
			
		}
