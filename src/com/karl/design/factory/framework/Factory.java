package com.karl.design.factory.framework;

/**
 * 工厂模式角色中的Creator：创建者属于framework，负责生产Product角色的抽象类，具体的处理由子类ConcreteCreator角色决定。
 * 它本身对实际负责生产实例的ConcreteCreator一无所知，仅仅知道调用生产Product角色和生成实例的方法就可以产生Product的实例。
 * 本示例采用Templete 模式，不用new来创建实例，而是调用生产实例的专用方法来生产实例，如此可以有效防止父类与其他具体实现类的耦合。
 * 
 * @author kevin
 *
 */
public abstract class Factory {

	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}

	protected abstract void registerProduct(Product product);

	protected abstract Product createProduct(String owner);
}
