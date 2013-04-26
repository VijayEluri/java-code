package com.vgb.fileupload;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Temp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Writer output;
		
		String my_file_name = "/home/vinayb/junk/test.txt";
		File file = new File(my_file_name);
		file.createNewFile();
		output = new BufferedWriter(new FileWriter(my_file_name, true ));
		output.append("New Line!");		
		for (int i = 0; i < 1000000; i++) {
			output.append("LINE "+ i+"\n");
		}
		output.close();
	}

}
