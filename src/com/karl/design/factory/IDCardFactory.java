package com.karl.design.factory;

import java.util.HashMap;
import java.util.Map;

import com.karl.design.factory.framework.Factory;
import com.karl.design.factory.framework.Product;

/**
 * 工厂模式角色中的ConcreteCreate(具体的创建者)
 * 
 * @author kevin
 *
 */
public class IDCardFactory extends Factory {

	private Map<String, String> owners = new HashMap<>();

	@Override
	protected void registerProduct(Product product) {
		owners.put(((IDCard) product).getOwner(),
				((IDCard) product).getCardCode());
	}

	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}

	public Map<String, String> getOwners() {
		return owners;
	}

	public void setOwners(Map<String, String> owners) {
		this.owners = owners;
	}

}
