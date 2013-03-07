package com.demo.mail;

import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;

/**
 * 发送邮件 可以自己编写html模板
 * @author ajun
 * @email zhaojun2066@gmail.com
 * @blog http://blog.csdn.net/ajun_studio
 * 2011-12-6 下午04:49:01
 */
@Service
public class TemplateEmail {

	@Resource
	private JavaMailSender sender;  // 注入Spring封装的javamail，Spring的xml中已让框架装配
	
	@Resource
    private FreeMarkerConfigurer freeMarkerConfigurer=null;//FreeMarker的技术类  
    
    /**
     * 生成html模板字符串
     * @param root 存储动态数据的map
     * @return
     */
	private String getMailText(Map<String,Object> root,String templateName){
		 String htmlText="";  
	        try {  
	            //通过指定模板名获取FreeMarker模板实例  
	            Template tpl=freeMarkerConfigurer.getConfiguration().getTemplate(templateName);  
	            htmlText=FreeMarkerTemplateUtils.processTemplateIntoString(tpl,root);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return htmlText;  
	}
	
	/**
	 * 同步发送邮件
	 * @param root 存储动态数据的map
	 * @param toEmail 邮件地址
	 * @param subject 邮件主题
	 * @return
	 */
    public boolean sendTemplateMail(Map<String,Object> root,String toEmail,String subject,String templateName){  
    	String htmlText=getMailText(root,templateName);//使用模板生成html邮件内容  
    	return sendMail(htmlText, toEmail, subject, templateName);
    }  
    
    /**
     * 发送邮件
     * @param content
     * @param toEmail
     * @param subject
     * @param templateName
     * @return
     */
    public boolean sendMail(String content, String toEmail,String subject,String templateName){
    	try {
    		if (toEmail == null || "".equals(toEmail.trim())) {
    			throw new IllegalArgumentException("收件人不能为空");
    		}
    		
        	System.out.println("开始发送邮件...");
        	// 建立邮件消息,发送简单邮件和html邮件的区别
			MimeMessage msg=sender.createMimeMessage();  
			MimeMessageHelper helper=new MimeMessageHelper(msg,false,"utf-8");//由于是html邮件，不是mulitpart类型
			
			/*********群发处理start********/
			toEmail = toEmail.replaceAll("\\;", ",");
			// 设置收件人，寄件人
			InternetAddress[] toAddress = InternetAddress.parse(toEmail);
			msg.setRecipients(Message.RecipientType.TO, toAddress); // 发送给多个账号
			/*********群发处理end********/
			
			helper.setFrom("619606426@qq.com");  
			//helper.setTo(toEmail); //发送给一个帐号  
			helper.setSubject(subject);  
			helper.setText(content, true);  
			sender.send(msg);
			System.out.println("成功发送模板邮件");  
			return true;
		} catch (MailException e) {
		    System.out.println("失败发送模板邮件"); 
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			System.out.println("失败发送模板邮件"); 
			e.printStackTrace();
			return false;
		}  catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
    }
    
    @Resource 
    TaskExecutor taskExecutor;// 注入Spring封装的异步执行器
    /**
     * 异步发送
     * @param root
     * @param toEmail
     * @param subject
     * @param templateName
     */
    public void asySendTemplateMail(Map<String,Object> root, final String toEmail, final String subject, final String templateName)
    {
    	final String content = getMailText(root,templateName);//使用模板生成html邮件内容  
    	try
    	{
	    	taskExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println("--异步发送");
						sendMail(content, toEmail, subject, templateName);
						System.out.println("邮件发送耗时任务完成");
					} catch (Exception e) {
						e.printStackTrace();
					}
					//System.exit(1);//当邮件发送完成时退出程序
				}
			});
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
