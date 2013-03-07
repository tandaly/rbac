package com.demo.mail;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.mail.util.MailUtility;
import com.demo.mail.util.TemplateUtility;

/**
 * 封装 Spring 集成的邮件发送服务实现类
 * 
 * 支持异步发送 利用Spring框架封装的JavaMail现实同步或异步邮件发送
 * spring 会负责每次发送后正确关闭 transport
 * @author Tandaly
 * @date 2013-3-7 下午1:59:03
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

	@Resource
	private MailUtility mailUtility;//邮件工具类
	
	@Resource
	TemplateUtility templateUtility;//模版工具类
	
	
	/*
	 * (non-Javadoc) 发送邮件的具体实现, 目前是异步发送
	 * 
	 * @see
	 * com.haohui.b2b.service.mail.MailService#sendHtmlEmails(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public void sendHtmlEmails(String receivers, String subject, String content) {
		//this.sendMailByAsynchronousMode(receivers, subject, content);
		this.mailUtility.sendMail(receivers, subject, content);
	}

	@Override
	public void sendTemplateHtmlEmails(Map<String, Object> model,String templateName, 
			String receivers, String subject) {
		String content = templateUtility.getMailText(model, templateName);
		this.mailUtility.sendMail(receivers, subject, content);
	}

	@Override
	public void sendAsync(String receivers, String subject, String content)
			throws Exception {
		this.mailUtility.sendMailByAsynchronousMode(receivers, subject, content);
	}
}
