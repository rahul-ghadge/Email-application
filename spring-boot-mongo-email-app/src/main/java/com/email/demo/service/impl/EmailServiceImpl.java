package com.email.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.demo.model.EmailModel;
import com.email.demo.repository.EmailDAO;
import com.email.demo.response.EmailResponse;
import com.email.demo.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDAO emailDAO;

	@Override
	public EmailResponse getEmails(String sender, String folder) {

		EmailResponse response = new EmailResponse();

		List<EmailModel> emails = emailDAO.getEmailsBySender(sender, folder);

		if (null != emails) {
			response.setModel(emails);
			response.setMessage("Email fetched successfully");
			response.setStatusCode(200);
		} else {
			response.setMessage("Something went wrong");
			response.setStatusCode(400);
		}

		return response;

	}

	@Override
	public EmailResponse sendEmails(EmailModel emailModel) {

		EmailResponse response = new EmailResponse();
		EmailModel model = emailDAO.sendEmail(emailModel);
		
		if (null != model) {
			response.setModel(Arrays.asList(model));
			response.setMessage("Email send successfully");
			response.setStatusCode(200);
		} else {
			response.setMessage("Something went wrong");
			response.setStatusCode(400);
		}

		return response;
	}

	@Override
	public EmailResponse moveToFolder(String id, String folder) {
		EmailResponse response = new EmailResponse();
		EmailModel model = emailDAO.moveToFolder(id, folder);
		
		if (null != model) {
			response.setModel(Arrays.asList(model));
			response.setMessage("Email send successfully");
			response.setStatusCode(200);
		} else {
			response.setMessage("Something went wrong");
			response.setStatusCode(400);
		}

		return response;
	}

}
