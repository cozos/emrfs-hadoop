package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface GuardedBy
{
  String value();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.GuardedBy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */