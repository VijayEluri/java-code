package com.vgb.fileupload.data;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FileToUpload implements Serializable {
	private MultipartFile file;

	public FileToUpload() {
	}

	public FileToUpload(MultipartFile file) {
		super();
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
