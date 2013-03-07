package com.demo.mail;

import java.util.Map;

/**
 * 邮件发送接口
 * 
 * @author Tandaly
 * @date 2013-3-7 下午1:59:21
 */
public interface MailService {

	/**
	 * 发送 HTML 邮件
	 * 
	 * @param receivers
	 *            多个收件箱地址用 ,分隔
	 * @param subject
	 * @param text
	 */
	public abstract void sendHtmlEmails(String receivers, String subject,
			String content);

	/**
	 * 模版发送
	 * 
	 * @param model
	 * @param templateName
	 * @param receivers
	 * @param subject
	 */
	public abstract void sendTemplateHtmlEmails(Map<String, Object> model,
			String templateName, String receivers, String subject);

	/**
	 * 
	 * @param receivers
	 * @param subject
	 * @param content
	 * @throws Exception
	 */
	public void sendAsync(String receivers, String subject, String content)
			throws Exception;
}
