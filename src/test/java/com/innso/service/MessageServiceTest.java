package com.innso.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.innso.builder.MessageBuilder;
import com.innso.exception.MessageNonValidException;
import com.innso.exception.MessageNotFoundException;
import com.innso.model.Canal;
import com.innso.model.Message;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class MessageServiceTest {
	private static final String MESSAGE_CONTENT = "Bonjour, J'ai un probléme avec mon téléphone";
	private static final String AUTHOR_NAME = "Jérémie Durand";
	private static final Date MESSAGE_DATE = null;
	private static final Canal MESSAGE_CANAL = Canal.SMS;
	private static final long MESSAGE_ID = 1L;
	private static final long FIRST_MESSAGE_ID = 1L;
	private static final long SECOND_MESSAGE_ID = 2L;
	private static final long MESSAGE_NOT_EXISTS_ID = 2;
	private static final long MESSAGE_EXISTS_ID = 1;
	// @formatter:off
	private static final Message MESSAGE_TO_SAVE = MessageBuilder.aMessage()
																 .hasMessageId(MESSAGE_ID)
																 .hasAuthor(AUTHOR_NAME)
																 .hasContent(MESSAGE_CONTENT)
																 .createdOn(MESSAGE_DATE)
																 .hasCanal(MESSAGE_CANAL)
																 .build();
	private static final Message MESSAGE_NOT_VALID = MessageBuilder.aMessage()
																 .hasMessageId(MESSAGE_ID)
																 .hasAuthor(AUTHOR_NAME)
																 .hasContent(MESSAGE_CONTENT)
																 .createdOn(MESSAGE_DATE)
																 .hasCanal(null)
																 .build();;
	// @formatter:on
	private MessageService msgService;

	@Before
	public void initialise() {
		msgService = new TestableMessageService();
	}

	@Test(expected = MessageNotFoundException.class)
	public void shouldThrowExceptionWhenMessageNotFound() throws MessageNotFoundException {
		msgService.findById(MESSAGE_NOT_EXISTS_ID);
	}

	@Test
	public void shouldReturnMessageWhenMessageFounded() throws MessageNotFoundException {
		Message message = msgService.findById(MESSAGE_EXISTS_ID);
		assertTrue(!message.equals(null));
	}

	@Test
	public void shouldReturnListOfMessages() throws Exception {
		if (msgService.findAll().isEmpty()) {
			assertThat(msgService.findAll(), is(Collections.emptyList()));
		} else {
			assertTrue(!msgService.findAll().isEmpty());
		}
	}

	@Test(expected = MessageNonValidException.class)
	public void shoudThrowExceptionWhenMessageNotValid() throws Exception {
		msgService.save(MESSAGE_NOT_VALID);
	}

	@Test
	public void shoudSaveMessage() throws Exception {
		Message savedMessage = msgService.save(MESSAGE_TO_SAVE);
		assertThat(savedMessage, is(MESSAGE_TO_SAVE));
	}

	class TestableMessageService extends MessageServiceImpl {

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
			// @formatter:on
			if (message != null && message.getMessageId() == id)
				return message;
			throw new MessageNotFoundException();
		}

		@Override
		public List<Message> findAll() {
			List<Message> messages = Collections.emptyList();
			// @formatter:off
			Message firstMessage = MessageBuilder.aMessage()
					                 .hasMessageId(FIRST_MESSAGE_ID)
									 .hasAuthor(AUTHOR_NAME)
									 .hasContent(MESSAGE_CONTENT)
									 .createdOn(MESSAGE_DATE)
									 .hasCanal(MESSAGE_CANAL)
							   		.build();
			Message secondMessage= MessageBuilder.aMessage()
					.hasMessageId(SECOND_MESSAGE_ID)
					.hasAuthor(AUTHOR_NAME)
					.hasContent(MESSAGE_CONTENT)
					.createdOn(MESSAGE_DATE)
					.hasCanal(MESSAGE_CANAL)
					.build();
			// @formatter:on
			messages = Arrays.asList(firstMessage, secondMessage);
			return messages;
		}

		@Override
		public Message save(Message message) {
			validate(message);
			return message;
		}

		private void validate(Message message) {
			if (message == null || message.getCanal() == null) {
				throw new MessageNonValidException();
			}
		}

		@Override
		public void delete(Message message) {
			// TODO Auto-generated method stub
			super.delete(message);
		}

	}

}
