package com.paxcel.mail.model;

import java.util.List;
import java.util.Map;

public class Mail {

    private String from;
    private String to;
    private String subject;
    private ModelMain main;
    private List<Object> attachments;
    private Map<String, Object> model;

    public Mail() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

  

	public ModelMain getMain() {
		return main;
	}

	public void setMain(ModelMain main) {
		this.main = main;
	}

	public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
