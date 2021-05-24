package com.innso.service;

import org.junit.Test;

import com.innso.exception.MessageNotFoundException;

public class MessageServiceTest {

	private static final long MESSAGE_ID_NO_EXISTS = 2;

	@Test(expected = MessageNotFoundException.class)
	public void shouldThrowExceptionWhenMessageNotFound() throws MessageNotFoundException {
		MessageService msgService = new MessageServiceImpl();
		msgService.findById(MESSAGE_ID_NO_EXISTS);
	}
	
}
