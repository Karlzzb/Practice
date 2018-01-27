package com.karl.design.template;

public enum MessageType {
	CONNECT(1) {

	},
	HEARTBEAT(2) {

	},
	BUSSINESS(3) {

	};

	private int code;

	private MessageType(int number) {
		this.code = number;
	}

	public int getCode() {
		return code;
	}

}
