package com.xkcoding.concurrentinaction.atomic;

import com.xkcoding.concurrentinaction.annotation.ThreadSafe;
import com.xkcoding.concurrentinaction.base.AbstractConcurrentTest;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 * 并发下 AtomicLong 累加
 * </p>
 *
 * @package: com.xkcoding.concurrentinaction.atomic
 * @description： 并发下 AtomicLong 累加
 * @author: yangkai.shen
 * @date: Created in 2018/8/23 下午11:27
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@ThreadSafe
@Slf4j
public class AtomicExample2 extends AbstractConcurrentTest {

	private AtomicLong count = new AtomicLong(0);

	public static void main(String[] args) throws Exception {
		AtomicExample2 example2 = new AtomicExample2();
		example2.execute();
		log.info("count:{}", example2.count.get());
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
