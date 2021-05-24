package com.innso.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.innso.exception.MessageNotFoundException;
import com.innso.model.Message;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class MessageServiceTest {

	private static final long MESSAGE_NOT_EXISTS_ID = 2;
	private static final long MESSAGE_EXISTS_ID = 1;
	private MessageService msgService;

	@Before
	public void initialise() {
		msgService = new MessageServiceImpl();
	}

	@Test(expected = MessageNotFoundException.class)
	public void shouldThrowExceptionWhenMessageNotFound() throws MessageNotFoundException {
		msgService = new MessageServiceImpl();
		msgService.findById(MESSAGE_NOT_EXISTS_ID);
	}

	@Test
	public void shouldReturnMessageWhenMessageFounded() throws MessageNotFoundException {
		msgService = new MessageServiceImpl();
		Message message = msgService.findById(MESSAGE_EXISTS_ID);
		assertTrue(!message.equals(null));
	}

}
