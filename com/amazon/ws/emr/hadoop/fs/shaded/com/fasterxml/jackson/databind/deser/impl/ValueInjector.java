package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty.Std;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;

public class ValueInjector
  extends BeanProperty.Std
{
  protected final Object _valueId;
  
  public ValueInjector(PropertyName propName, JavaType type, Annotations contextAnnotations, AnnotatedMember mutator, Object valueId)
  {
    super(propName, type, null, contextAnnotations, mutator, PropertyMetadata.STD_OPTIONAL);
    
    _valueId = valueId;
  }
  
  @Deprecated
  public ValueInjector(String propName, JavaType type, Annotations contextAnnotations, AnnotatedMember mutator, Object valueId)
  {
    this(new PropertyName(propName), type, contextAnnotations, mutator, valueId);
  }
  
  public Object findValue(DeserializationContext context, Object beanInstance)
  {
    return context.findInjectableValue(_valueId, this, beanInstance);
  }
  
  public void inject(DeserializationContext context, Object beanInstance)
    throws IOException
  {
    _member.setValue(beanInstance, findValue(context, beanInstance));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ValueInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */