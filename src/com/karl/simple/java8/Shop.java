package com.karl.simple.java8;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
	private String name;

	public Shop(String name) {
		super();
		this.name = name;
	}

	private double calculatePrice(String product) {
		CommonUtils.delay();
		return new Random().nextDouble() * product.charAt(0)
				+ product.charAt(1);
	}

	public double getPrice(String product) {
		return calculatePrice(product);
	}

	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
			try {
				double price = calculatePrice(product);
				futurePrice.complete(price);
			} catch (Exception ex) {
				futurePrice.completeExceptionally(ex);
			}
		}).start();
		return futurePrice;
	}

	public Future<Double> getPriceAsync2(String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}

	public static void main(String[] args) {
		Shop shop = new Shop("my shop");
		long start = System.nanoTime();
		Future<Double> futurnPrice = shop.getPriceAsync("my favorite product");
		long invacationTime = ((System.nanoTime() - start) / 1_00_000);
		System.out.println("Invocation returned after " + invacationTime
				+ "msecs");

		try {
			double price = futurnPrice.get();
			System.out.printf("Price is %.2f%n", price);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		long retrievaTime = ((System.nanoTime() - start) / 1_00_000);
		System.out.println("Price returned after " + retrievaTime + "msecs");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
