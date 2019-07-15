package com.xkcoding.concurrentinaction.threadlocal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试ThreadLocal
 * </p>
 *
 * @package: com.xkcoding.concurrentinaction.threadlocal
 * @description: 测试ThreadLocal
 * @author: yangkai.shen
 * @date: Created in 2018/9/21 下午8:52
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    /**
     * 测试ThreadLocal保存的值
     */
    @GetMapping("/test")
    public Long test() {
        return RequestHolder.getId();
    }
}
