package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer.None;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonSerialize
{
  Class<? extends JsonSerializer> using() default JsonSerializer.None.class;
  
  Class<? extends JsonSerializer> contentUsing() default JsonSerializer.None.class;
  
  Class<? extends JsonSerializer> keyUsing() default JsonSerializer.None.class;
  
  Class<? extends JsonSerializer> nullsUsing() default JsonSerializer.None.class;
  
  Class<?> as() default Void.class;
  
  Class<?> keyAs() default Void.class;
  
  Class<?> contentAs() default Void.class;
  
  Typing typing() default Typing.DEFAULT_TYPING;
  
  Class<? extends Converter> converter() default Converter.None.class;
  
  Class<? extends Converter> contentConverter() default Converter.None.class;
  
  @Deprecated
  Inclusion include() default Inclusion.DEFAULT_INCLUSION;
  
  @Deprecated
  public static enum Inclusion
  {
    ALWAYS,  NON_NULL,  NON_DEFAULT,  NON_EMPTY,  DEFAULT_INCLUSION;
    
    private Inclusion() {}
  }
  
  public static enum Typing
  {
    DYNAMIC,  STATIC,  DEFAULT_TYPING;
    
    private Typing() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonSerialize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */