package com.innso.model;

import java.util.Date;
import java.util.List;

public class ClientFolder {

	private long clientFolderId;
	private String clientName;
	private Date openingDate;
	private String reference;
	private List<Message> messages;

	public ClientFolder() {
	}

	public ClientFolder(long clientFolderId, String clientName, Date openingDate, String reference,
			List<Message> messages) {
		this.clientFolderId = clientFolderId;
		this.clientName = clientName;
		this.openingDate = openingDate;
		this.reference = reference;
		this.messages = messages;
	}

	public long getClientFolderId() {
		return clientFolderId;
	}

	public void setClientFolderId(long clientFolderId) {
		this.clientFolderId = clientFolderId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
