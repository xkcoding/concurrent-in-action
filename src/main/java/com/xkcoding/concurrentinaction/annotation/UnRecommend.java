package com.xkcoding.concurrentinaction.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 用于标记【不推荐】的类
 * </p>
 *
 * @package: com.xkcoding.concurrentinaction.annotation
 * @description： 用于标记【不推荐】的类
 * @author: yangkai.shen
 * @date: Created in 2018/8/22 下午10:49
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface UnRecommend {

    String value() default "";

}
