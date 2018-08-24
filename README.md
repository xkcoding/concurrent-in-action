# concurrent-in-action
并发编程实践学习

## 自定义注解

- `com.xkcoding.concurrentinaction.annotation.Recommend` 用于标记【推荐】的类
- `com.xkcoding.concurrentinaction.annotation.UnRecommend` 用于标记【不推荐】的类
- `com.xkcoding.concurrentinaction.annotation.ThreadSafe` 用于标记线程【安全】的类
- `com.xkcoding.concurrentinaction.annotation.ThreadUnSafe` 用于标记线程【不安全】的类

## 并发测试类

需要进行并发安全测试的类，可以直接继承 `com.xkcoding.concurrentinaction.base.AbstractConcurrentTest` 这个类，重写 `AbstractConcurrentTest#testMethod()` 这个方法，在里面运行调用待测试的方法，然后执行 `AbstractConcurrentTest#execute()` 即可开始并发测试。

示例 `demo`:

```java
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
		ConcurrentIntAdd test = new ConcurrentIntAdd();
		// 执行测试方法
		test.execute();
		log.info("count:{}", test.count);
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
```