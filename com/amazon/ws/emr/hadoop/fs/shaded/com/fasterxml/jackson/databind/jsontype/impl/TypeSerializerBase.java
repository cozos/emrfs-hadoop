package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class TypeSerializerBase
  extends TypeSerializer
{
  protected final TypeIdResolver _idResolver;
  protected final BeanProperty _property;
  
  protected TypeSerializerBase(TypeIdResolver idRes, BeanProperty property)
  {
    _idResolver = idRes;
    _property = property;
  }
  
  public abstract JsonTypeInfo.As getTypeInclusion();
  
  public String getPropertyName()
  {
    return null;
  }
  
  public TypeIdResolver getTypeIdResolver()
  {
    return _idResolver;
  }
  
  protected String idFromValue(Object value)
  {
    String id = _idResolver.idFromValue(value);
    if (id == null) {
      handleMissingId(value);
    }
    return id;
  }
  
  protected String idFromValueAndType(Object value, Class<?> type)
  {
    String id = _idResolver.idFromValueAndType(value, type);
    if (id == null) {
      handleMissingId(value);
    }
    return id;
  }
  
  protected void handleMissingId(Object value) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.TypeSerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */