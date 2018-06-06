package com.excelunit.test.Excelunittest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UploadClient {

	private static final Logger logger = Logger.getLogger(SpringBootApplication.class.getName());
	public String uploadfile(String url,MultiValueMap<String, Object> bodyMap,String Action,String Content_type ) throws IOException{
	
		
	 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(Content_type));
        final   HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.valueOf(Action), requestEntity, String.class);
        
        logger.log(Level.INFO, "response status: [" + response.getStatusCode()+"] response body: [" + response.getBody()+"]");
		return "API REturn VAlue "+response.getBody();
    }

}
