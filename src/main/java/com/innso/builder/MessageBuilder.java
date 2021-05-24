package com.innso.builder;

import java.util.Date;

import com.innso.model.Canal;
import com.innso.model.Message;

public class MessageBuilder {
	private long messageId;
	private String messageContent;
	private String authorName;
	private Date messageDate;
	private Canal canal;

	public static MessageBuilder aMessage() {
		return new MessageBuilder();
	}

	public MessageBuilder hasAuthor(String authorName) {
		return setAuthorName(authorName);
	}

	public MessageBuilder hasContent(String messageContent) {
		return setMessageContent(messageContent);
	}

	public MessageBuilder createdOn(Date messageDate) {
		return setMessageDate(messageDate);
	}

	public MessageBuilder hasCanal(Canal messageCanal) {
		return setCanal(messageCanal);
	}

	public MessageBuilder hasMessageId(long messageId) {
		return setMessageId(messageId);
	}

	public Message build() {
		Message msg = new Message();
		addMessageIdTo(msg);
		addAuthorTo(msg);
		addContentTo(msg);
		addDateTo(msg);
		addCanalTo(msg);

		return msg;
	}

	private void addMessageIdTo(Message msg) {
		msg.setMessageId(getMessageId());
	}

	private void addCanalTo(Message msg) {
		msg.setCanal(getCanal());
	}

	private void addDateTo(Message msg) {
		msg.setMessageDate(getMessageDate());
	}

	private void addContentTo(Message msg) {
		msg.setMessageContent(getMessageContent());
	}

	private void addAuthorTo(Message msg) {
		msg.setMessageAuthor(getAuthorName());
	}

	// get set

	public long getMessageId() {
		return messageId;
	}

	public MessageBuilder setMessageId(long messageId) {
		this.messageId = messageId;
		return this;
	}

	public Canal getCanal() {
		return canal;
	}

	public MessageBuilder setCanal(Canal canal) {
		this.canal = canal;
		return this;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public MessageBuilder setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
		return this;
	}

	public String getAuthorName() {
		return authorName;
	}

	public MessageBuilder setAuthorName(String authorName) {
		this.authorName = authorName;
		return this;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public MessageBuilder setMessageContent(String messageContent) {
		this.messageContent = messageContent;
		return this;
	}

}
