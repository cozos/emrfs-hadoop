package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.lang.annotation.Annotation;

public @interface JsonAppend$Attr
{
  String value();
  
  String propName() default "";
  
  String propNamespace() default "";
  
  JsonInclude.Include include() default JsonInclude.Include.NON_NULL;
  
  boolean required() default false;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonAppend.Attr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */