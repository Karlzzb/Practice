package com.karl.design.template;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class MainTest {

	@Test
	public void main() {
		Message message = new Message();
		message.setMessageType(MessageType.CONNECT);
		message.setHead("消息头信息");
		message.setBody("消息报文");

		List<MessageHandle> handlers = new ArrayList<>();
		handlers.add(new BusinessMessageHandle());
		handlers.add(new HeatBeatMessageHandle());
		handlers.add(new ConnectMessageHandle());
		handlers.parallelStream().forEach(handle -> {
			handle.messageHandle(message);
		});

	}
}
