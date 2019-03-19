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
	
	//上传文件存放路径   
    private final static String UPLOADDIR = "/upload";
    //上传文件集合   
    private List<File> file;   
    //上传文件名集合   
    private List<String> fileFileName;   
    //上传文件内容类型集合   
    private List<String> fileContentType;
	
	
	
  //执行上传功能   
  	private void uploadFile(int i) throws FileNotFoundException, IOException {   
          try {   
              InputStream in = new FileInputStream(file.get(i));
              String dir = ServletActionContext.getServletContext().getRealPath(UPLOADDIR);
              File fileLocation = new File(dir);
              //此处也可以在应用根目录手动建立目标上传目录  
              if(!fileLocation.exists()){
                  boolean isCreated  = fileLocation.mkdir();
                  if(!isCreated) {
                      //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。  
                  	System.out.println("目录创建失败");
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
	
	//获取所有的公告
	public String showAllNotices(){
		noticeList=noticeinfoService.getAllNoticeinfo();
		return "showAllNotices";
	}
	
	//获取某一个公告的信息
	public String showNotice(){
		noticeinfo=noticeinfoService.getNoticeinfoById(id);
		return "showNotice";
	}
	//根据编号删除公告信息
	public String deleteNotice(){
		boolean isDeleteNotice=noticeinfoService.deleteNoticeinfo(id);
		if(isDeleteNotice){
			BaseTools.success("删除成功", null, null);
		}else{
			BaseTools.error("删除失败", null, null);
		}
		return "jump";
	}

	//删除所有公告信息
	public String deleteAllNotice(){
		
		return "";
	}
	
	//显示学生首页的公告
	public String showIndexNotice() {
		noticeList = noticeinfoService.getIndexNotice();
		System.out.println(noticeList);
		return "show";
	}
	
	//添加公告信息
	public String insertNotice() throws FileNotFoundException, IOException{
        if(file != null) { //有文件要上传
        	this.uploadFile(0);
        	noticeinfo.setAccessory(this.getFileFileName().get(0).toString());
        }
        
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		noticeinfo.setDate(sdf.format(new Date()));
		int isInsert=noticeinfoService.creatNoticeinfo(noticeinfo);
		if(isInsert==0)
			BaseTools.success("发布成功", null, "show_all_notices");
		else
			BaseTools.error("发布失败", null, null);
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
