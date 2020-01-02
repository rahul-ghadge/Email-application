package com.email.demo.repository;

import java.util.List;

import com.email.demo.model.EmailModel;

public interface EmailDAO {
	
	List<EmailModel> getEmailsBySender(String sender, String folder);

	EmailModel sendEmail(EmailModel emailModel);

	EmailModel moveToFolder(String id, String folder);

}
