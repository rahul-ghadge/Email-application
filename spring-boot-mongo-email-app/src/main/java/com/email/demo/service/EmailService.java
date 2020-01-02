package com.email.demo.service;

import com.email.demo.model.EmailModel;
import com.email.demo.response.EmailResponse;

public interface EmailService {

	EmailResponse getEmails(String sender, String folder);

	EmailResponse sendEmails(EmailModel emailModel);

	EmailResponse moveToFolder(String id, String folder);

}
