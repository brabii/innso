package com.innso.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.innso.builder.MessageBuilder;
import com.innso.model.Canal;
import com.innso.model.Message;

public class Main {
	private static final String MESSAGE_CONTENT = "Bonjour, J'ai un probléme avec mon téléphone";
	private static final String AUTHOR_NAME = "Jérémie Durand";
	private static final Date MESSAGE_DATE = null;
	private static final Canal MESSAGE_CANAL = Canal.SMS;
	private static final long MESSAGE_ID = 1L;
	private static final long FIRST_MESSAGE_ID = 1L;
	private static final long SECOND_MESSAGE_ID = 2L;
	private static final long MESSAGE_NOT_EXISTS_ID = 100L;
	private static final long MESSAGE_EXISTS_ID = 1;
	private static final Message MESSAGE_TO_SAVE = MessageBuilder.aMessage().hasMessageId(MESSAGE_ID)
			.hasAuthor(AUTHOR_NAME).hasContent(MESSAGE_CONTENT).createdOn(MESSAGE_DATE).hasCanal(MESSAGE_CANAL).build();
	private static final Message MESSAGE_NOT_VALID = MessageBuilder.aMessage().hasMessageId(MESSAGE_ID)
			.hasAuthor(AUTHOR_NAME).hasContent(MESSAGE_CONTENT).createdOn(MESSAGE_DATE).hasCanal(null).build();;
	private static final Message MESSAGE_NOT_EXISTS = MessageBuilder.aMessage().hasMessageId(MESSAGE_NOT_EXISTS_ID)
			.hasAuthor(AUTHOR_NAME).hasContent(MESSAGE_CONTENT).createdOn(MESSAGE_DATE).hasCanal(MESSAGE_CANAL).build();
	private static final Message MESSAGE_EXISTS = MessageBuilder.aMessage().hasMessageId(FIRST_MESSAGE_ID)
			.hasAuthor(AUTHOR_NAME).hasContent(MESSAGE_CONTENT).createdOn(MESSAGE_DATE).hasCanal(MESSAGE_CANAL).build();

	public static void main(String[] args) {
		List<Message> messages = new ArrayList<>();
		Message firstMessage = MessageBuilder.aMessage().hasMessageId(FIRST_MESSAGE_ID).hasAuthor(AUTHOR_NAME)
				.hasContent(MESSAGE_CONTENT).createdOn(MESSAGE_DATE).hasCanal(MESSAGE_CANAL).build();
		Message secondMessage = MessageBuilder.aMessage().hasMessageId(SECOND_MESSAGE_ID).hasAuthor(AUTHOR_NAME)
				.hasContent(MESSAGE_CONTENT).createdOn(MESSAGE_DATE).hasCanal(MESSAGE_CANAL).build();
		messages.add(firstMessage);
		messages.add(secondMessage);
		System.out.println("before remove");
		System.out.println(messages);
		System.out.println("after remove");
		messages.remove(MESSAGE_EXISTS);
		System.out.println(messages);

	}
}
