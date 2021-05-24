package com.innso.service;

import java.util.Collections;
import java.util.List;

import com.innso.exception.MessageNotFoundException;
import com.innso.model.Message;

public class MessageServiceImpl implements MessageService {

	@Override
	public Message findById(long id) throws MessageNotFoundException {
		throw new MessageNotFoundException();
	}

	@Override
	public List<Message> findAll() {
		return Collections.emptyList();
	}

	@Override
	public Message save(Message message) {
		return null;
	}

	@Override
	public void delete(Message message) {
	}
}
