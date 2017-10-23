package com.imooc.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MoreFileUploadAction extends ActionSupport {
	private List<File> upload;
	private List<String> uploadContenttype;
	private List<String> uploadFileName;
	private String result;
	
	
	
	public List<File> getUpload() {
		return upload;
	}



	public void setUpload(List<File> upload) {
		this.upload = upload;
	}



	public List<String> getUploadContenttype() {
		return uploadContenttype;
	}



	public void setUploadContenttype(List<String> uploadContenttype) {
		this.uploadContenttype = uploadContenttype;
	}



	public List<String> getUploadFileName() {
		return uploadFileName;
	}



	public void setUploadFileName(List<String> uploadFileName) {
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
		
		for(int i=0;i<upload.size();i++){
			FileUtils.copyFile(upload.get(i), new File(file,uploadFileName.get(i)));
		}
		
		result = "上传成功";
		
		return SUCCESS;
	}

}
