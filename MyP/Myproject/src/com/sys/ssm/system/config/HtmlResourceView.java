package com.sys.ssm.system.config;

import java.io.File;
import java.util.Locale;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceView;
@Component
public class HtmlResourceView extends InternalResourceView{
	
	@Override  
    public boolean checkResource(Locale locale) {  
     File file = new File(this.getServletContext().getRealPath("/") + getUrl());  
     return file.exists();// 判断该页面是否存在  
    } 
	
	

}
