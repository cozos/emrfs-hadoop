package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonCreator
{
  Mode mode() default Mode.DEFAULT;
  
  public static enum Mode
  {
    DEFAULT,  DELEGATING,  PROPERTIES,  DISABLED;
    
    private Mode() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */