package vob.annotation;

import java.lang.annotation.Documented;

@Documented
public @interface BelongsTo {
	String parent();
}
