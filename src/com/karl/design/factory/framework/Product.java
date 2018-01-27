package com.karl.design.factory.framework;

/**
 * 工厂模式角色中的Product：属于framework中的角色，定义了工厂模式生产的实例所持有的接口。
 * 具体的处理由子类ConcreteCreator角色决定
 * 
 * @author kevin
 *
 */
public abstract class Product {

	public abstract void use();
}
