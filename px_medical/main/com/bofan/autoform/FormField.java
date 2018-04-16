package com.bofan.autoform;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface FormField {
	String type();
	String label() default "";
	String scene() default "";
	String dataBind() default "";
	String[] options() default {};
	Validator[] validator() default {};
	String script() default "" ;
    
}
