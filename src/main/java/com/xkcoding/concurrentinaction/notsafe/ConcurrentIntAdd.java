package com.xkcoding.concurrentinaction.notsafe;

import com.xkcoding.concurrentinaction.annotation.ThreadUnSafe;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * <p>
 * 并发下int累加
 * </p>
 *
 * @package: com.xkcoding.concurrentinaction.notsafe
 * @description： 并发下int累加
 * @author: yangkai.shen
 * @date: Created in 2018/8/23 下午11:27
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@ThreadUnSafe
@Slf4j
public class ConcurrentIntAdd {

	/**
	 * 请求总数
	 */
	public final static int CLIENT_TOTAL = 5000;

	/**
	 * 同时并发执行的线程数
	 */
	public final static int THREAD_TOTAL = 200;

	public static int count = 0;

	public static void main(String[] args) throws Exception {
		ExecutorService executor = new ThreadPoolExecutor(20, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), new BasicThreadFactory.Builder().namingPattern("thread-%d").build());
		final Semaphore semaphore = new Semaphore(THREAD_TOTAL);
		final CountDownLatch countDownLatch = new CountDownLatch(CLIENT_TOTAL);
		for (int i = 0; i < CLIENT_TOTAL; i++) {
			executor.execute(() -> {
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (Exception e) {
					log.error("exception", e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executor.shutdown();
		log.info("count:{}", count);
	}

	private static void add() {
		count++;
	}
}