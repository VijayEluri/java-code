package com.vgb.fileupload;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ApplicationTest {

	public static void main(String[] args) {
		testFileUpload("/home/vinayb/junk/test.txt");
	}

	private static void testFileUpload(final String pathname) {
		final RestOperations operations = new RestTemplate();		
		final File file = new File(pathname);
		MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>(); 
		form.add("Content-Type", "text/plain");
		form.add("success_action_status", "201");		
		form.add("file", new FileSystemResource(file));

		String endpoint = "http://localhost:8080/FileUpload/file/upload";
		operations.postForLocation(endpoint, form);
	}


}
