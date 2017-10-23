package com.imooc.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private File upload;
	private String uploadContenttype;
	private String uploadFileName;
	private String result;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContenttype() {
		return uploadContenttype;
	}
	public void setUploadContenttype(String uploadContenttype) {
		this.uploadContenttype = uploadContenttype;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("hello-===");
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		
		FileUtils.copyFile(upload, new File(file,uploadFileName));
		
		result = "上传成功";
		
		return SUCCESS;
	}

}
