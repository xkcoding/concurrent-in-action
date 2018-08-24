package com.xkcoding.concurrentinaction.notsafe;

import com.xkcoding.concurrentinaction.annotation.ThreadUnSafe;
import com.xkcoding.concurrentinaction.base.AbstractConcurrentTest;
import lombok.extern.slf4j.Slf4j;

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
public class ConcurrentIntAdd extends AbstractConcurrentTest {

	private int count = 0;

	public static void main(String[] args) throws Exception {
		ConcurrentIntAdd concurrentIntAdd = new ConcurrentIntAdd();
		// 执行测试方法
		concurrentIntAdd.execute();
		log.info("count:{}", concurrentIntAdd.count);
	}

	private void add() {
		count++;
	}

	/**
	 * 测试方法
	 */
	@Override
	public void testMethod() {
		add();
	}
}
