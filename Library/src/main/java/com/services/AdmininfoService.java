package com.services;

import com.domain.Admininfo;

public interface AdmininfoService {
	
	String getPwd(String usr);
	
	int creatAdmininfo(Admininfo admininfo);
	
	public Admininfo getAdmininfoById(String username);
	
	boolean updateAdmininfo(Admininfo admininfo);

}
