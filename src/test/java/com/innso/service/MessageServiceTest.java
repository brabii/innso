package com.innso.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
	private static final long MESSAGE_NOT_EXISTS_ID = 100L;
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
	 private static final Message MESSAGE_NOT_EXISTS = MessageBuilder.aMessage()
																	 .hasMessageId(MESSAGE_NOT_EXISTS_ID)
																	 .hasAuthor(AUTHOR_NAME)
																	 .hasContent(MESSAGE_CONTENT)
																	 .createdOn(MESSAGE_DATE)
																	 .hasCanal(MESSAGE_CANAL)
																	 .build();
	private static final Message MESSAGE_EXISTS = MessageBuilder.aMessage()
							                          			.hasMessageId(FIRST_MESSAGE_ID)
										            	 		.hasAuthor(AUTHOR_NAME)
										            	 		.hasContent(MESSAGE_CONTENT)
											 					.createdOn(MESSAGE_DATE)
											 					.hasCanal(MESSAGE_CANAL)
											 					.build();
			
 // @formatter:on
	private MessageServiceImpl msgService;
	private Message message;

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
		message = msgService.findById(MESSAGE_EXISTS_ID);
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

	@Test(expected = MessageNotFoundException.class)
	public void shouldThrowExceptionWhenDeleteMessageNotExists() throws MessageNotFoundException {
		msgService.delete(MESSAGE_NOT_EXISTS);
	}

	@Test
	public void shouldDeleteMessage() throws MessageNotFoundException {
		msgService.delete(MESSAGE_EXISTS);
		assertTrue(!msgService.messages.contains(MESSAGE_EXISTS));
		System.err.println(msgService.messages);
	}

	class TestableMessageService extends MessageServiceImpl {
		List<Message> messages = messages();

		@Override
		public Message findById(long id) throws MessageNotFoundException {

			List<Message> messagesList = messages;
			for (Message message : messagesList) {
				if (message.getMessageId() == id) {
					return message;
				}
			}
			throw new MessageNotFoundException();
		}

		@Override
		public List<Message> findAll() {
			return messages;
		}

		@Override
		public Message save(Message message) {
			validate(message);
			messages.add(message);
			return message;
		}

		private void validate(Message message) {
			if (message == null || message.getCanal() == null) {
				throw new MessageNonValidException();
			}
		}

		@Override
		public List<Message> messages() {
			List<Message> messages = new ArrayList<>();
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
			messages.add(firstMessage);
			messages.add(secondMessage);
			return messages;
		}

		@Override
		public void exists(Message message) throws MessageNotFoundException {
			if (!messages.contains(message)) {
				throw new MessageNotFoundException();
			}
		}

		@Override
		public void delete(Message message) throws MessageNotFoundException {
			exists(message);
			messages.remove(message);
			System.err.println("delete methode! " + messages);
		}

	}
}
