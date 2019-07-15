package com.xkcoding.concurrentinaction.atomic;

import com.xkcoding.concurrentinaction.annotation.ThreadSafe;
import com.xkcoding.concurrentinaction.base.AbstractConcurrentTest;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 并发下 AtomicInteger 累加
 * </p>
 *
 * @package: com.xkcoding.concurrentinaction.atomic
 * @description： 并发下 AtomicInteger 累加
 * @author: yangkai.shen
 * @date: Created in 2018/8/23 下午11:27
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@ThreadSafe
@Slf4j
public class AtomicExample1 extends AbstractConcurrentTest {

	private AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) throws Exception {
		AtomicExample1 example1 = new AtomicExample1();
		example1.execute();
		log.info("count:{}", example1.count.get());
	}

	private void add() {
		count.incrementAndGet(); // 类似 ++i
		//		count.getAndIncrement(); // 类似 i++
	}

	/**
	 * 待测试的方法
	 */
	@Override
	public void testMethod() {
		add();
	}
}
