package com.karl.design.template;

/**
 * 模板模式中的 AbstractClass(抽象类)： 此角色不仅仅负责实现模板方法，还负责申请再在模板方法中所有用到的抽象方法。
 * 这些抽象方法由子类ConcreteClass(具体实现类)角色负责实现。
 * 
 * @author karl
 *
 */
public abstract class AbstractMessageHandle implements MessageHandle {

	/**
	 * 模板方法
	 */
	public void messageHandle(Message message) {
		if (support(message.getMessageType())) {
			messageResovle(message);
		}

	}

	public abstract boolean support(MessageType messageType);

	public abstract void messageResovle(Message message);
}
