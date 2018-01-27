package com.karl.design.factory;

import java.util.UUID;

import com.karl.design.factory.framework.Product;

/**
 * 工厂模式角色中的ConcreteProduct(具体的产品)
 * 
 * @author kevin
 *
 */
public class IDCard extends Product {
	private String owner;
	private String cardCode;

	/**
	 * 不能是public，防止外部避开工厂方法而单独创建
	 * 
	 * @param owner
	 */
	IDCard(String owner) {
		super();
		this.owner = owner;
		this.cardCode = UUID.randomUUID().toString();
		System.out.printf("制作  %s 的ID卡[%s]\n", owner, cardCode);
	}

	@Override
	public void use() {
		System.out.printf("使用  %s 的ID卡[%s]\n", owner, cardCode);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

}
