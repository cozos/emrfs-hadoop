package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface Expose
{
  boolean serialize() default true;
  
  boolean deserialize() default true;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.annotations.Expose
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */