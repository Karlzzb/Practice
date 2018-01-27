package com.karl.design.template;

/**
 * 模板模式中的ConcreteClass(具体实现类)： 此角色负责实现AbstractClass角色定义的抽象方法
 * 
 * @author karl
 *
 */
public class BusinessMessageHandle extends AbstractMessageHandle {

	@Override
	public boolean support(MessageType messageType) {
		return messageType.equals(MessageType.BUSSINESS);
	}

	@Override
	public void messageResovle(Message message) {
		System.out.printf("The business message{} has been resovled",
				message.toString());
	}

}
