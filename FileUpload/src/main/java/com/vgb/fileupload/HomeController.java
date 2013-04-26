package com.vgb.fileupload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vgb.fileupload.data.FileToUpload;
import com.vgb.fileupload.data.FilesToUpload;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is " + locale.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/files/upload", method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadData") FilesToUpload uploadData) {
		final List<MultipartFile> files = uploadData.getFiles();
		if (files == null || files.isEmpty()) {
			System.err.println("No file");
			return "home";
		}

		for (MultipartFile file : files) {
			System.out.printf("Handling file: %s:%s with size %d\n", file.getName(), file.getOriginalFilename(), file.getSize());
		}

		return "home";
	}

	@RequestMapping(value = "/file/upload", method = RequestMethod.POST)
	public @ResponseBody Long save(@RequestParam("file") MultipartFile file) throws IOException {
		if (file == null) {
			System.err.println("No file passed in");
			return -1L;
		}
		
		System.out.printf("Handling file: %s:%s with size %d\n", file.getName(), file.getOriginalFilename(), file.getSize());
		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"), 1);
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println("Read line: " + line);
		}
		
		return file.getSize();
	}

}
