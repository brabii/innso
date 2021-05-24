package com.innso.service;

import java.util.Date;
import java.util.List;

import com.innso.builder.MessageBuilder;
import com.innso.exception.MessageNotFoundException;
import com.innso.model.Canal;
import com.innso.model.Message;

public class MessageServiceImpl implements MessageService {

	private static final String MESSAGE_CONTENT = "Bonjour, J'ai un probléme avec mon téléphone";
	private static final String AUTHOR_NAME = "Jérémie Durand";
	private static final Date MESSAGE_DATE = null;
	private static final Canal MESSAGE_CANAL = Canal.SMS;
	private static final long MESSAGE_ID = 1L;

	@Override
	public Message findById(long id) throws MessageNotFoundException {
		// @formatter:off
		Message message = MessageBuilder.aMessage()
				                 .hasMessageId(MESSAGE_ID)
								 .hasAuthor(AUTHOR_NAME)
								 .hasContent(MESSAGE_CONTENT)
								 .createdOn(MESSAGE_DATE)
								 .hasCanal(MESSAGE_CANAL)
						   		.build();
		// @formatter:off
		if(message.getMessageId()==id) {
			return message;
		}
		throw new MessageNotFoundException();
	}

	@Override
	public List<Message> findAll() {
		return null;
	}

	@Override
	public Message save(Message message) {
		return null;
	}

	@Override
	public void delete(Message message) {
	}
}
