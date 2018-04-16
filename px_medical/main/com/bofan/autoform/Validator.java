/*
 * <p> Title:  FormScene.java</p>
 * <p>Copyright:   BoFan (b) 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.autoform;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> Calss Name:  FormScene.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2018-3-15
 */
@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Validator {
	String scene() default "";
	boolean required() default false;
	String value() default "";
}
