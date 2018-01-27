package com.karl.design.template;

public interface MessageHandle {

	public void messageHandle(Message message);

	public boolean support(MessageType messageType);

	public void messageResovle(Message message);

}
