package com.tx.txv_common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Txv {
    String name() default "";
    String value() default "";
}
