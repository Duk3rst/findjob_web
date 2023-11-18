package com.dto;

import org.springframework.web.multipart.MultipartFile;

public class applypostDTO {
	private MultipartFile multipartFile;
	private String file;
	private String text;
	private int idu;
	private int idrec;

	public applypostDTO(MultipartFile multipartFile, String file, String text, int idu, int idrec) {
		super();
		this.multipartFile = multipartFile;
		this.file = file;
		this.text = text;
		this.idu = idu;
		this.idrec = idrec;
	}
	
	public int getIdu() {
		return idu;
	}
	public void setIdu(int idu) {
		this.idu = idu;
	}
	public int getIdrec() {
		return idrec;
	}
	public void setIdrec(int idrec) {
		this.idrec = idrec;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
