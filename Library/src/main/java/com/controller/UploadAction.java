package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.utils.BaseTools;

public class UploadAction extends ActionSupport{
	//�ϴ��ļ����·��   
    private final static String UPLOADDIR = "/upload";
    //�ϴ��ļ�����   
    private List<File> file;   
    //�ϴ��ļ�������   
    private List<String> fileFileName;   
    //�ϴ��ļ��������ͼ���   
    private List<String> fileContentType;
    
    public String execute() throws Exception {
    	//System.out.println(file);
        System.out.println(this.getFileFileName());
        if(file != null) { //���ļ�Ҫ�ϴ�
        	for (int i = 0; i < file.size(); i++) {   
                //ѭ���ϴ�ÿ���ļ�   
                this.uploadFile(i);   
            }  
        }
        BaseTools.success("�ϴ��ɹ�", null, null);
        return "jump";
    }
    
  //ִ���ϴ�����   
	private void uploadFile(int i) throws FileNotFoundException, IOException {   
        try {   
            InputStream in = new FileInputStream(file.get(i));   
            String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);
            File fileLocation = new File(dir);  
            //�˴�Ҳ������Ӧ�ø�Ŀ¼�ֶ�����Ŀ���ϴ�Ŀ¼  
            if(!fileLocation.exists()){  
                boolean isCreated  = fileLocation.mkdir();  
                if(!isCreated) {  
                    //Ŀ���ϴ�Ŀ¼����ʧ��,������������,�����׳��Զ����쳣��,һ��Ӧ�ò���������������  
                	System.out.println("Ŀ¼����ʧ��");
                    return;  
                }  
            }  
            String fileName=this.getFileFileName().get(i);  
            File uploadFile = new File(dir, fileName);   
            OutputStream out = new FileOutputStream(uploadFile);   
            byte[] buffer = new byte[1024 * 1024];   
            int length;   
            while ((length = in.read(buffer)) > 0) {   
                out.write(buffer, 0, length);   
            }
            System.out.println("�ļ��ϴ��ɹ�");
            in.close();   
            out.close();   
        } catch (FileNotFoundException ex) {   
            System.out.println("�ϴ�ʧ��!");  
            ex.printStackTrace();   
        } catch (IOException ex) {   
            System.out.println("�ϴ�ʧ��!");  
            ex.printStackTrace();   
        }   
    }   
    
    
	public List<File> getFile() {
		return file;
	}
	public void setFile(List<File> file) {
		this.file = file;
	}
	public List<String> getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}
	public List<String> getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
	public static String getUploaddir() {
		return UPLOADDIR;
	} 

}
