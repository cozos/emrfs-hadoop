package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.BindingAnnotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
@BindingAnnotation
public @interface Named
{
  String value();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name.Named
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */