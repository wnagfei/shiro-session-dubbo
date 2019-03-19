package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.domain.Noticeinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.NoticeinfoService;
import com.utils.BaseTools;

public class NoticeAction extends ActionSupport{
	
	private Noticeinfo noticeinfo;
	private NoticeinfoService noticeinfoService;
	private List<Noticeinfo> noticeList;
	private Integer id;
	
	//�ϴ��ļ����·��   
    private final static String UPLOADDIR = "/upload";
    //�ϴ��ļ�����   
    private List<File> file;   
    //�ϴ��ļ�������   
    private List<String> fileFileName;   
    //�ϴ��ļ��������ͼ���   
    private List<String> fileContentType;
	
	
	
  //ִ���ϴ�����   
  	private void uploadFile(int i) throws FileNotFoundException, IOException {   
          try {   
              InputStream in = new FileInputStream(file.get(i));
              String dir = ServletActionContext.getServletContext().getRealPath(UPLOADDIR);
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
              in.close();
              out.close();
          } catch (FileNotFoundException ex) {  
              ex.printStackTrace();
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      }
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	//��ȡ���еĹ���
	public String showAllNotices(){
		noticeList=noticeinfoService.getAllNoticeinfo();
		return "showAllNotices";
	}
	
	//��ȡĳһ���������Ϣ
	public String showNotice(){
		noticeinfo=noticeinfoService.getNoticeinfoById(id);
		return "showNotice";
	}
	//���ݱ��ɾ��������Ϣ
	public String deleteNotice(){
		boolean isDeleteNotice=noticeinfoService.deleteNoticeinfo(id);
		if(isDeleteNotice){
			BaseTools.success("ɾ���ɹ�", null, null);
		}else{
			BaseTools.error("ɾ��ʧ��", null, null);
		}
		return "jump";
	}

	//ɾ�����й�����Ϣ
	public String deleteAllNotice(){
		
		return "";
	}
	
	//��ʾѧ����ҳ�Ĺ���
	public String showIndexNotice() {
		noticeList = noticeinfoService.getIndexNotice();
		System.out.println(noticeList);
		return "show";
	}
	
	//��ӹ�����Ϣ
	public String insertNotice() throws FileNotFoundException, IOException{
        if(file != null) { //���ļ�Ҫ�ϴ�
        	this.uploadFile(0);
        	noticeinfo.setAccessory(this.getFileFileName().get(0).toString());
        }
        
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		noticeinfo.setDate(sdf.format(new Date()));
		int isInsert=noticeinfoService.creatNoticeinfo(noticeinfo);
		if(isInsert==0)
			BaseTools.success("�����ɹ�", null, "show_all_notices");
		else
			BaseTools.error("����ʧ��", null, null);
		return "jump";
	}
	
	public Noticeinfo getNoticeinfo() {
		return noticeinfo;
	}

	public void setNoticeinfo(Noticeinfo noticeinfo) {
		this.noticeinfo = noticeinfo;
	}

	public NoticeinfoService getNoticeinfoService() {
		return noticeinfoService;
	}

	public void setNoticeinfoService(NoticeinfoService noticeinfoService) {
		this.noticeinfoService = noticeinfoService;
	}

	public List<Noticeinfo> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Noticeinfo> noticeList) {
		this.noticeList = noticeList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
