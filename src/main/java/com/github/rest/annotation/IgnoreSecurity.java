package com.github.rest.annotation;

import java.lang.annotation.*;

/**
 * Created by jiabin on 2018/5/13.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSecurity {

}
