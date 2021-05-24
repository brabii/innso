package com.innso.model;

import java.util.Date;

public class Message {

	private long messageId;
	private Date messageDate;
	private String messageAuthor;
	private String messageContent;
	private Canal canal;

	public Message() {
	}

	public Message(long messageId, Date messageDate, String messageAuthor, String messageContent, Canal canal) {
		this.messageId = messageId;
		this.messageDate = messageDate;
		this.messageAuthor = messageAuthor;
		this.messageContent = messageContent;
		this.canal = canal;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessageAuthor() {
		return messageAuthor;
	}

	public void setMessageAuthor(String messageAuthor) {
		this.messageAuthor = messageAuthor;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

}
