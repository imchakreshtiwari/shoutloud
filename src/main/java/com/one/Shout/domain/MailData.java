package com.one.Shout.domain;

public class MailData {
	private String to;
	private String name;
	private String from;
	private String mno;
	private String query;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
