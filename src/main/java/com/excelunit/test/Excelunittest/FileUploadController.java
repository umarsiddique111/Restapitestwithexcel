package com.excelunit.test.Excelunittest;


import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.server.PathParam;

import org.apache.tomcat.jni.File;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class FileUploadController {
	
	private static final Logger logger = Logger.getLogger(SpringBootApplication.class.getName());
	
    @RequestMapping(value="/upload", method = RequestMethod.POST )
    public String handleFileUpload(@RequestParam("user-file") MultipartFile multipartFile,
    		                       @RequestParam(value = "asOfDate") String asOfDate ,
    							   @RequestParam(value = "name") String name) 
    				throws IOException {

        String name1 = multipartFile.getOriginalFilename();
        
        logger.log(Level.INFO,"File name: "+name1);
        
        //todo save to a file via multipartFile.getInputStream()
        byte[] bytes = multipartFile.getBytes();
        logger.log(Level.INFO,"File uploaded content:\n"+ new String(bytes));
       
        return "file uploaded";
    }
    
    @RequestMapping(value="/test/{user-name}", method = RequestMethod.GET )
    public String getcheckapi(@PathVariable(value ="user-name") String name)  {
									
    	
    	
    	
    	
    	return "get succeful run parameter!!!"+name;
    	
    }
    @RequestMapping(value="/check", method = RequestMethod.GET  )
    public String getcheck() {
		
    	
    	
    	return "Check Get Controller";
    	
    	
    }
    
}


