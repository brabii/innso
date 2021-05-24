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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canal == null) ? 0 : canal.hashCode());
		result = prime * result + ((messageAuthor == null) ? 0 : messageAuthor.hashCode());
		result = prime * result + ((messageContent == null) ? 0 : messageContent.hashCode());
		result = prime * result + ((messageDate == null) ? 0 : messageDate.hashCode());
		result = prime * result + (int) (messageId ^ (messageId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (canal != other.canal)
			return false;
		if (messageAuthor == null) {
			if (other.messageAuthor != null)
				return false;
		} else if (!messageAuthor.equals(other.messageAuthor))
			return false;
		if (messageContent == null) {
			if (other.messageContent != null)
				return false;
		} else if (!messageContent.equals(other.messageContent))
			return false;
		if (messageDate == null) {
			if (other.messageDate != null)
				return false;
		} else if (!messageDate.equals(other.messageDate))
			return false;
		if (messageId != other.messageId)
			return false;
		return true;
	}

}
