package org.agaphetos.cv.controller;

import org.agaphetos.cv.entity.Message;
import org.agaphetos.cv.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	private static final Logger log = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageRepository repository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public Iterable<Message> getMessages() {
		log.info("GET messages");
		Iterable<Message> messages = this.repository.findAll();
		for (Message message : messages) {
			log.info("Message: " + message.toString());
		}
		return messages;
	}
		
	@CrossOrigin(origins = {
			"http://localhost:3000", 
			"http://www.levincalado.me", 
			"http://levincalado.herokuapp.com"
		})
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public ResponseEntity<Void> postMessage(@RequestBody Message data) {
		Message message = new Message();
		message.setContent(data.getContent());
		message.setDate(data.getDate());
		message.setEmail(data.getEmail());
		message.setName(data.getName());
		log.info("POST message");
		log.info(message.toString());
		this.repository.save(message);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
