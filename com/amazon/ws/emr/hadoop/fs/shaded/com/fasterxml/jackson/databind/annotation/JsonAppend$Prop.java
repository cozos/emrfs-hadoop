package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import java.lang.annotation.Annotation;

public @interface JsonAppend$Prop
{
  Class<? extends VirtualBeanPropertyWriter> value();
  
  String name() default "";
  
  String namespace() default "";
  
  JsonInclude.Include include() default JsonInclude.Include.NON_NULL;
  
  boolean required() default false;
  
  Class<?> type() default Object.class;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonAppend.Prop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */