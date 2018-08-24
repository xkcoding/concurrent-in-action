package com.xkcoding.concurrentinaction.base;

/**
 * <p>
 * 并发测试接口
 * </p>
 *
 * @package: com.xkcoding.concurrentinaction.base
 * @description： 并发测试接口
 * @author: yangkai.shen
 * @date: Created in 2018/8/24 上午9:21
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface ConcurrentTest {

	/**
	 * 并发执行测试方法
	 *
	 * @throws Exception 执行方法抛出的异常
	 */
	void execute() throws Exception;

	/**
	 * 待测试的方法
	 *
	 * @throws Exception 执行方法抛出的异常
	 */
	void testMethod() throws Exception;
}
