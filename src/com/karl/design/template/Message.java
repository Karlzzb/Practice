package com.karl.design.template;

public class Message {
	private String head;
	private String body;
	private MessageType messageType;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	@Override
	public String toString() {
		return "Message [head=" + head + ", body=" + body + ", messageType="
				+ messageType + "]";
	}

}
