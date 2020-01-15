package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;

public class AttributePropertyWriter
  extends VirtualBeanPropertyWriter
{
  private static final long serialVersionUID = 1L;
  protected final String _attrName;
  
  protected AttributePropertyWriter(String attrName, BeanPropertyDefinition propDef, Annotations contextAnnotations, JavaType declaredType)
  {
    this(attrName, propDef, contextAnnotations, declaredType, propDef.findInclusion());
  }
  
  protected AttributePropertyWriter(String attrName, BeanPropertyDefinition propDef, Annotations contextAnnotations, JavaType declaredType, JsonInclude.Include inclusion)
  {
    super(propDef, contextAnnotations, declaredType, null, null, null, inclusion);
    
    _attrName = attrName;
  }
  
  public static AttributePropertyWriter construct(String attrName, BeanPropertyDefinition propDef, Annotations contextAnnotations, JavaType declaredType)
  {
    return new AttributePropertyWriter(attrName, propDef, contextAnnotations, declaredType);
  }
  
  protected AttributePropertyWriter(AttributePropertyWriter base)
  {
    super(base);
    _attrName = _attrName;
  }
  
  public VirtualBeanPropertyWriter withConfig(MapperConfig<?> config, AnnotatedClass declaringClass, BeanPropertyDefinition propDef, JavaType type)
  {
    throw new IllegalStateException("Should not be called on this type");
  }
  
  protected Object value(Object bean, JsonGenerator jgen, SerializerProvider prov)
    throws Exception
  {
    return prov.getAttribute(_attrName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */