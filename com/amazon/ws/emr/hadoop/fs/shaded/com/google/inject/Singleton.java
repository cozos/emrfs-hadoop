package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ScopeAnnotation
public @interface Singleton {}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Singleton
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */