package com.lumia.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mail {
	
	private static final Logger l = LoggerFactory.getLogger( Mail.class );

	private Properties proerty;

	private Session session;

	private Transport transport;

	private Message message;

	/**
	 * 邮件内容和附件
	 */
	private MimeMultipart mimeMultipart;

	public Mail() {
		proerty = new Properties();
		session = null;
		transport = null;
		message = null;
		// 设置邮件由多个部分组成，内容和附件
		mimeMultipart = new MimeMultipart("mixed");
	}

	/**
	 * 邮件服务器设置信息
	 */
	public void prepare() {
		try {
			proerty.put("mail.transport.protocol", "smtp");
			proerty.put("mail.smtp.auth", "true");

			session = Session.getDefaultInstance(proerty);
			session.setDebug(true);
			transport = session.getTransport();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			System.out.println("设置邮件基本信息出错！");
		}
	}

	/**
	 * 设置邮件基本信息
	 * 
	 * @param mailSender
	 *            发件人邮箱地址
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件正文
	 * @param appendFile
	 *            附件路径
	 * @param appendFileName
	 *            附件名称
	 */
	public void setMail(String mailSender, String subject, String content,
			String appendFile, String appendFileName) {
		message = new MimeMessage(session);

		try {
			message.setContent(mimeMultipart); // 设置邮件为多部分组成
			message.setFrom(new InternetAddress(mailSender)); // 设置发件人信息
			message.setSubject(subject); // 设置邮件主题
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.addContent(content);
		this.addAccessory(appendFile, appendFileName);
	}

	/**
	 * 添加邮件正文
	 * 
	 * @param text
	 */
	public void addContent(String text) {
		try {
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(text, "text/html;charset=gb2312");
			mimeMultipart.addBodyPart(mimeBodyPart);
			message.saveChanges();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 添加附件
	 * 
	 * @param appendFile
	 *            附件路径
	 * @param appendFileName
	 *            附件名称
	 */
	public void addAccessory(String appendFile, String appendFileName) {
		DataSource ds = new FileDataSource(appendFile);
		DataHandler dh = new DataHandler(ds);
		MimeBodyPart mbp = new MimeBodyPart();

		try {
			mbp.setDataHandler(dh);
			mbp.setFileName(MimeUtility.encodeText(appendFileName)); // 解决邮件附件名中文乱码
			mimeMultipart.addBodyPart(mbp);
			message.saveChanges();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMain(String server, int port, String fromUserName,
			String fromPassword, String[] mailReciver) {
		try {
			transport.connect(server, port, fromUserName, fromPassword);
			int len = mailReciver.length;
			Address[] address = new Address[len];

			for (int i = 0; i < len; i++) {
				address[i] = new InternetAddress(mailReciver[i]);
			}

			transport.sendMessage(message, address);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Mail mail = new Mail();
		mail.prepare();
		mail.setMail("562857639@qq.com", "heihaiertest", "heihaiertest", "D:\\迅雷下载\\文志超.jpg",
				"文志超.jpg");
	/*	mail.sendMain(
				"smtp.qq.com",
				25,
				"562857639@qq.com",
				"319730wtc888990",
				new String[] { "csgirl562857639@gmail.com",
						"csgirl562857639@126.com",
						"csgirl562857639@outlook.com", "csgirl562857639@msn.cn" });*/
		mail.sendMain(
				"smtp.qq.com",
				25,
				"562857639@qq.com",
				"319730wtc888990",
				new String[] { "csgirl562857639@gmail.com" });
	}
}
