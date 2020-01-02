package com.email.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.email.demo.model.EmailModel;
import com.email.demo.repository.EmailDAO;

@Repository
public class EmailDAOImpl implements EmailDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	
	
	@Override
	public List<EmailModel> getEmailsBySender(String sender, String folder) {
		List<EmailModel> emails = new ArrayList<>();

		Query query = new Query();
		if (null != sender && sender.trim().length() > 0)
			query.addCriteria(Criteria.where("sender").is(sender));
		
		if (null != folder && folder.trim().length() > 0)
			query.addCriteria(Criteria.where("folder").is(folder));
		else 
			query.addCriteria(Criteria.where("folder").is("INBOX"));

		emails.addAll(mongoTemplate.find(query, EmailModel.class));

		return emails;
	}



	@Override
	public EmailModel sendEmail(EmailModel emailModel) {
		return mongoTemplate.save(emailModel);		
	}



	@Override
	public EmailModel moveToFolder(String id, String folder) {
		Query query = new Query();
		if (null != id && id.trim().length() > 0)
			query.addCriteria(Criteria.where("_id").is(id));
		
		EmailModel email = mongoTemplate.findOne(query, EmailModel.class);
		
		if (null != email && null != folder) {
			email.setFolder(folder);
			return mongoTemplate.save(email);
		}
		
		return null;
	}

}
