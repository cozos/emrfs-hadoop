package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonProperty
{
  public static final String USE_DEFAULT_NAME = "";
  public static final int INDEX_UNKNOWN = -1;
  
  String value() default "";
  
  boolean required() default false;
  
  int index() default -1;
  
  String defaultValue() default "";
  
  Access access() default Access.AUTO;
  
  public static enum Access
  {
    AUTO,  READ_ONLY,  WRITE_ONLY,  READ_WRITE;
    
    private Access() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */