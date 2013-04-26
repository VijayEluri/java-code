package com.vgb.fileupload.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FilesToUpload implements Serializable{
	private List<MultipartFile> files = new ArrayList<MultipartFile>();
	
	public FilesToUpload() {
		
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	public void addFile(MultipartFile file) {
		this.files.add(file);
	}
	
	

}
