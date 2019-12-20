package com.tx.txv_common.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KeyValue {
    String key() default "" ;


}
