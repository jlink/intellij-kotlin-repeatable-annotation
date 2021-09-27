package tagging;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TagList.class)
public @interface Tag {
	Class<? extends CharSequence> value();

	int priority() default 0;
}
