package com.xkcoding.concurrentinaction.threadlocal;

/**
 * <p>
 * Request 持有器
 * </p>
 *
 * @package: com.xkcoding.concurrentinaction.threadlocal
 * @description: Request 持有器
 * @author: yangkai.shen
 * @date: Created in 2018/9/21 下午8:50
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class RequestHolder {
    private final static ThreadLocal<Long> REQUEST_HOLDER = new ThreadLocal<>();

    /**
     * 为当前request添加一个id
     *
     * @param id 值
     */
    public static void add(Long id) {
        REQUEST_HOLDER.set(id);
    }

    /**
     * 获取当前request保存的id
     *
     * @return 当前request保存的id
     */
    public static Long getId() {
        return REQUEST_HOLDER.get();
    }

    /**
     * 清空缓存
     */
    public static void remove() {
        REQUEST_HOLDER.remove();
    }
}
