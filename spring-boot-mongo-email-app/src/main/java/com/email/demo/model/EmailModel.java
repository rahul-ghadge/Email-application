package com.email.demo.model;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.annotation.Id;

public class EmailModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;

	private String[] receipt;

	private String[] ccReceipt;

	private String bccReceipt;

	private String sender;

	private String subject;

	private String mailBody;

	private String folder;

	private boolean isSpam;

	public String[] getReceipt() {
		return receipt;
	}

	public void setReceipt(String[] receipt) {
		this.receipt = receipt;
	}

	public String[] getCcReceipt() {
		return ccReceipt;
	}

	public void setCcReceipt(String[] ccReceipt) {
		this.ccReceipt = ccReceipt;
	}

	public String getBccReceipt() {
		return bccReceipt;
	}

	public void setBccReceipt(String bccReceipt) {
		this.bccReceipt = bccReceipt;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public boolean isSpam() {
		return isSpam;
	}

	public void setSpam(boolean isSpam) {
		this.isSpam = isSpam;
	}

	@Override
	public String toString() {
		return "EmailModel [_id=" + _id + ", receipt=" + Arrays.toString(receipt) + ", ccReceipt="
				+ Arrays.toString(ccReceipt) + ", bccReceipt=" + bccReceipt + ", sender=" + sender + ", subject="
				+ subject + ", mailBody=" + mailBody + ", folder=" + folder + ", isSpam=" + isSpam + "]";
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	
	
}
