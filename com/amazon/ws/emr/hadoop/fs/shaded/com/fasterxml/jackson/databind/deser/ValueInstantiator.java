package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.io.IOException;

public abstract class ValueInstantiator
{
  public abstract String getValueTypeDesc();
  
  public boolean canInstantiate()
  {
    return (canCreateUsingDefault()) || (canCreateUsingDelegate()) || (canCreateFromObjectWith()) || (canCreateFromString()) || (canCreateFromInt()) || (canCreateFromLong()) || (canCreateFromDouble()) || (canCreateFromBoolean());
  }
  
  public boolean canCreateFromString()
  {
    return false;
  }
  
  public boolean canCreateFromInt()
  {
    return false;
  }
  
  public boolean canCreateFromLong()
  {
    return false;
  }
  
  public boolean canCreateFromDouble()
  {
    return false;
  }
  
  public boolean canCreateFromBoolean()
  {
    return false;
  }
  
  public boolean canCreateUsingDefault()
  {
    return getDefaultCreator() != null;
  }
  
  public boolean canCreateUsingDelegate()
  {
    return false;
  }
  
  public boolean canCreateFromObjectWith()
  {
    return false;
  }
  
  public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig config)
  {
    return null;
  }
  
  public JavaType getDelegateType(DeserializationConfig config)
  {
    return null;
  }
  
  public Object createUsingDefault(DeserializationContext ctxt)
    throws IOException
  {
    throw ctxt.mappingException("Can not instantiate value of type %s; no default creator found", new Object[] { getValueTypeDesc() });
  }
  
  public Object createFromObjectWith(DeserializationContext ctxt, Object[] args)
    throws IOException
  {
    throw ctxt.mappingException("Can not instantiate value of type %s with arguments", new Object[] { getValueTypeDesc() });
  }
  
  public Object createUsingDelegate(DeserializationContext ctxt, Object delegate)
    throws IOException
  {
    throw ctxt.mappingException("Can not instantiate value of type %s using delegate", new Object[] { getValueTypeDesc() });
  }
  
  public Object createFromString(DeserializationContext ctxt, String value)
    throws IOException
  {
    return _createFromStringFallbacks(ctxt, value);
  }
  
  public Object createFromInt(DeserializationContext ctxt, int value)
    throws IOException
  {
    throw ctxt.mappingException("Can not instantiate value of type %s from Integer number (%s, int)", new Object[] { getValueTypeDesc(), Integer.valueOf(value) });
  }
  
  public Object createFromLong(DeserializationContext ctxt, long value)
    throws IOException
  {
    throw ctxt.mappingException("Can not instantiate value of type %s from Integer number (%s, long)", new Object[] { getValueTypeDesc(), Long.valueOf(value) });
  }
  
  public Object createFromDouble(DeserializationContext ctxt, double value)
    throws IOException
  {
    throw ctxt.mappingException("Can not instantiate value of type %s from Floating-point number (%s, double)", new Object[] { getValueTypeDesc(), Double.valueOf(value) });
  }
  
  public Object createFromBoolean(DeserializationContext ctxt, boolean value)
    throws IOException
  {
    throw ctxt.mappingException("Can not instantiate value of type %s from Boolean value (%s)", new Object[] { getValueTypeDesc(), Boolean.valueOf(value) });
  }
  
  public AnnotatedWithParams getDefaultCreator()
  {
    return null;
  }
  
  public AnnotatedWithParams getDelegateCreator()
  {
    return null;
  }
  
  public AnnotatedWithParams getWithArgsCreator()
  {
    return null;
  }
  
  public AnnotatedParameter getIncompleteParameter()
  {
    return null;
  }
  
  protected Object _createFromStringFallbacks(DeserializationContext ctxt, String value)
    throws IOException, JsonProcessingException
  {
    if (canCreateFromBoolean())
    {
      String str = value.trim();
      if ("true".equals(str)) {
        return createFromBoolean(ctxt, true);
      }
      if ("false".equals(str)) {
        return createFromBoolean(ctxt, false);
      }
    }
    if ((value.length() == 0) && 
      (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT))) {
      return null;
    }
    throw ctxt.mappingException("Can not instantiate value of type %s from String value ('%s'); no single-String constructor/factory method", new Object[] { getValueTypeDesc(), value });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */