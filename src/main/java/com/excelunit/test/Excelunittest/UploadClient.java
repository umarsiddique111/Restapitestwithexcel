package com.excelunit.test.Excelunittest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UploadClient {

	private static final Logger logger = Logger.getLogger(SpringBootApplication.class.getName());
	public String uploadfile(String url,MultiValueMap<String, Object> bodyMap ) throws IOException{
	
		
	 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        final   HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        logger.log(Level.INFO, "response status: [" + response.getStatusCode()+"] response body: [" + response.getBody()+"]");
		return "File uploaded succefully";
    }


//	public Resource getUserFileResource() throws IOException {
//   
//		Path tempFile = Files.createTempFile("upload-test-file", ".txt");
//        Files.write(tempFile, "some test content...\nline1\nline2".getBytes());
//        File file = tempFile.toFile();
//        System.out.println(file);
//        //to upload in-memory bytes use ByteArrayResource instead
//        return new FileSystemResource(file);
//    }

}