package com.innso.service;

import java.util.List;

import com.innso.exception.MessageNotFoundException;
import com.innso.model.Message;

public interface MessageService {

	public Message findById(long id) throws MessageNotFoundException;

	public List<Message> findAll();

	public Message save(Message message);

	public void delete(Message message) throws MessageNotFoundException;

}
