package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Contract
{
  ThreadingBehavior threading() default ThreadingBehavior.UNSAFE;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */