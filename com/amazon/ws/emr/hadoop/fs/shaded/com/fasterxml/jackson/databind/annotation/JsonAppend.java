package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonAppend
{
  Attr[] attrs() default {};
  
  Prop[] props() default {};
  
  boolean prepend() default false;
  
  public static @interface Prop
  {
    Class<? extends VirtualBeanPropertyWriter> value();
    
    String name() default "";
    
    String namespace() default "";
    
    JsonInclude.Include include() default JsonInclude.Include.NON_NULL;
    
    boolean required() default false;
    
    Class<?> type() default Object.class;
  }
  
  public static @interface Attr
  {
    String value();
    
    String propName() default "";
    
    String propNamespace() default "";
    
    JsonInclude.Include include() default JsonInclude.Include.NON_NULL;
    
    boolean required() default false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonAppend
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */