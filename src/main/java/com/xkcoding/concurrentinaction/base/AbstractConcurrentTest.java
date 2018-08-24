package com.xkcoding.concurrentinaction.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * <p>
 * 并发测试接口抽象
 * </p>
 *
 * @package: com.xkcoding.concurrentinaction.base
 * @description： 并发测试接口抽象
 * @author: yangkai.shen
 * @date: Created in 2018/8/24 上午9:00
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public abstract class AbstractConcurrentTest implements ConcurrentTest {
	/**
	 * 请求总数
	 */
	private final static int CLIENT_TOTAL = 5000;

	/**
	 * 同时并发执行的线程数
	 */
	private final static int THREAD_TOTAL = 200;

	/**
	 * 并发执行测试方法
	 *
	 * @throws InterruptedException 执行方法抛出的异常
	 */
	@Override
	public void execute() throws InterruptedException {
		ExecutorService executor = new ThreadPoolExecutor(20, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), new BasicThreadFactory.Builder().namingPattern("thread-%d").build());
		final Semaphore semaphore = new Semaphore(THREAD_TOTAL);
		final CountDownLatch countDownLatch = new CountDownLatch(CLIENT_TOTAL);
		for (int i = 0; i < CLIENT_TOTAL; i++) {
			executor.execute(() -> {
				try {
					semaphore.acquire();
					testMethod();
					semaphore.release();
				} catch (Exception e) {
					log.error("exception", e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executor.shutdown();
	}

	/**
	 * 待测试的方法
	 *
	 * @throws Exception 执行方法抛出的异常
	 */
	@Override
	public abstract void testMethod() throws Exception;
}
