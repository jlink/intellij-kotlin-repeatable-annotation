package tagging;

import java.lang.annotation.*;
import java.math.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TagList.class)
public @interface Tag {
	Class<? extends CharSequence> value();
	int priority() default 0;
}
