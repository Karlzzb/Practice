package com.karl.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompletableFutureTest {

	private List<Shop> shops;

	private Executor executor;

	public List<String> findPrices(String product) {
		return shops
				.stream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(),
						shop.getPrice(product))).collect(Collectors.toList());
	}

	public List<String> findPricesParallel(String product) {
		return shops
				.parallelStream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(),
						shop.getPrice(product))).collect(Collectors.toList());
	}

	public List<String> findPricesCompletableFuture(String product) {
		List<CompletableFuture<String>> priceFutures = shops
				.stream()
				.map(shop -> CompletableFuture.supplyAsync(() -> shop.getName()
						+ " price is " + shop.getPrice(product)))
				.collect(Collectors.toList());

		return priceFutures.stream().map(CompletableFuture::join)
				.collect(Collectors.toList());
	}

	public List<String> findPricesCompletableFuture2(String product) {
		List<CompletableFuture<String>> priceFutures = shops
				.stream()
				.map(shop -> CompletableFuture.supplyAsync(() -> shop.getName()
						+ " price is " + shop.getPrice(product), executor))
				.collect(Collectors.toList());

		return priceFutures.stream().map(CompletableFuture::join)
				.collect(Collectors.toList());
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	@BeforeTest
	public void test() {
		List<Shop> shops = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			shops.add(new Shop("BestPrice" + i));
		}
		setShops(shops);

		setExecutor(Executors.newFixedThreadPool(Math.min(shops.size(), 100),
				new ThreadFactory() {
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						t.setDaemon(true);
						return t;
					}

				}));

		System.out.println("Available Processors are:"
				+ Runtime.getRuntime().availableProcessors());
	}

	@Test
	public void test0() {
		System.out.println(findPrices("myPhone27s"));
	}

	@Test
	public void test1() {
		System.out.println(findPricesParallel("myPhone27s"));
	}

	@Test
	public void test2() {
		System.out.println(findPricesCompletableFuture("myPhone27s"));
	}

	@Test
	public void test3() {
		System.out.println(findPricesCompletableFuture2("myPhone27s"));
	}

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
}
