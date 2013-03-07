package com.demo.mail.util;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;

/**
 * 模版工具类
 * @author Tandaly
 * @date 2013-3-7 下午1:52:38
 */
@Component
public class TemplateUtility {

	@Resource
	private FreeMarkerConfigurer freeMarkerConfigurer;//FreeMarker的技术类  
	
	
	 /**
     * 生成html模板字符串
     * @param root 存储动态数据的map
     * @return
     */
	public String getMailText(Map<String,Object> model,String templateName){
		 String htmlText="";  
	        try {  
	            //通过指定模板名获取FreeMarker模板实例  
	            Template tpl=freeMarkerConfigurer.getConfiguration().getTemplate(templateName);  
	            htmlText=FreeMarkerTemplateUtils.processTemplateIntoString(tpl, model);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return htmlText;  
	}
}
