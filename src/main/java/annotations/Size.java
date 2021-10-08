package annotations;

import java.lang.annotation.*;

@Target({ ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Size {
	int min() default 0;

	int value() default 0;
}