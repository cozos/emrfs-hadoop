package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonTypeInfo
{
  Id use();
  
  As include() default As.PROPERTY;
  
  String property() default "";
  
  Class<?> defaultImpl() default None.class;
  
  boolean visible() default false;
  
  public static enum Id
  {
    NONE(null),  CLASS("@class"),  MINIMAL_CLASS("@c"),  NAME("@type"),  CUSTOM(null);
    
    private final String _defaultPropertyName;
    
    private Id(String defProp)
    {
      _defaultPropertyName = defProp;
    }
    
    public String getDefaultPropertyName()
    {
      return _defaultPropertyName;
    }
  }
  
  public static enum As
  {
    PROPERTY,  WRAPPER_OBJECT,  WRAPPER_ARRAY,  EXTERNAL_PROPERTY,  EXISTING_PROPERTY;
    
    private As() {}
  }
  
  @Deprecated
  public static abstract class None {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */