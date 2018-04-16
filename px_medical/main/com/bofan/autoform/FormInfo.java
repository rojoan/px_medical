package com.bofan.autoform;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface FormInfo {
	String name() default "";
	String layout();
	FormMethod method() default FormMethod.GET;
	String action() default "";
}
