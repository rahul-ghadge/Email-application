package com.email.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.email.demo.model.EmailModel;
import com.email.demo.response.EmailResponse;
import com.email.demo.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	
	@GetMapping("/email")
	public ResponseEntity<EmailResponse> getEmails(@RequestParam(required=false) String sender,
			@RequestParam String folder) {

		EmailResponse emailResponse = emailService.getEmails(sender, folder);

		return new ResponseEntity<>(emailResponse, HttpStatus.OK);

	}
	
	
	@PostMapping("/email")
	public ResponseEntity<EmailResponse> getEmails(@RequestBody EmailModel emailModel) {

		EmailResponse emailResponse = emailService.sendEmails(emailModel);

		return new ResponseEntity<>(emailResponse, HttpStatus.OK);

	}
	
	@GetMapping("/email/move")
	public ResponseEntity<EmailResponse> moveToFolder(@RequestParam String id,
			@RequestParam String folder) {

		EmailResponse emailResponse = emailService.moveToFolder(id, folder);

		return new ResponseEntity<>(emailResponse, HttpStatus.OK);

	}

}
