package com.karl.simple;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureCancelTest {
	private final ExecutorService executor = Executors.newFixedThreadPool(10);
	private final long FUTURE_TIMEOUT = 2000l;// 执行超时时间

	final class CallableSignCheck implements Callable<Boolean> {

		@Override
		public Boolean call() {
			try {
				String mycount = "t1";
				while (true) {
					Thread.sleep(30l);
					mycount += mycount;
				}
			} catch (InterruptedException e) {
				System.out.println("延签线程执行本打断！");
			}
			return true;
		}
	}

	/**
	 * 验签处理
	 * 
	 * @return
	 */
	public boolean signCheckHandle() {
		Future<Boolean> future = executor.submit(new CallableSignCheck());
		boolean result = false;
		try {
			result = future.get(FUTURE_TIMEOUT, TimeUnit.MILLISECONDS);
			System.out.println("验证执行正常完成！");
		} catch (Exception e) {
			System.out.printf("验证执行失败或超时！{}\n", e);
			result = false;
		} finally {
			future.cancel(true);
		}
		return result;
	}

	public static void main(String[] args) {
		FutureCancelTest test = new FutureCancelTest();
		for (int i = 0; i < 50; i++) {
			test.signCheckHandle();
		}
	}
}
