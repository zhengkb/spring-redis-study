package com.zkb.springredisstudy.redis.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisLock {

    String key() default "";

    long time() default 1000L * 300;
}
