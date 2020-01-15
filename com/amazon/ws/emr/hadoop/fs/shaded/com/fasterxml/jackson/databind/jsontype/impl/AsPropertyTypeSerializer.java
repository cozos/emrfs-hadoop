package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.IOException;

public class AsPropertyTypeSerializer
  extends AsArrayTypeSerializer
{
  protected final String _typePropertyName;
  
  public AsPropertyTypeSerializer(TypeIdResolver idRes, BeanProperty property, String propName)
  {
    super(idRes, property);
    _typePropertyName = propName;
  }
  
  public AsPropertyTypeSerializer forProperty(BeanProperty prop)
  {
    return _property == prop ? this : new AsPropertyTypeSerializer(_idResolver, prop, _typePropertyName);
  }
  
  public String getPropertyName()
  {
    return _typePropertyName;
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.PROPERTY;
  }
  
  public void writeTypePrefixForObject(Object value, JsonGenerator jgen)
    throws IOException
  {
    String typeId = idFromValue(value);
    if (typeId == null)
    {
      jgen.writeStartObject();
    }
    else if (jgen.canWriteTypeId())
    {
      jgen.writeTypeId(typeId);
      jgen.writeStartObject();
    }
    else
    {
      jgen.writeStartObject();
      jgen.writeStringField(_typePropertyName, typeId);
    }
  }
  
  public void writeTypePrefixForObject(Object value, JsonGenerator jgen, Class<?> type)
    throws IOException
  {
    String typeId = idFromValueAndType(value, type);
    if (typeId == null)
    {
      jgen.writeStartObject();
    }
    else if (jgen.canWriteTypeId())
    {
      jgen.writeTypeId(typeId);
      jgen.writeStartObject();
    }
    else
    {
      jgen.writeStartObject();
      jgen.writeStringField(_typePropertyName, typeId);
    }
  }
  
  public void writeTypeSuffixForObject(Object value, JsonGenerator jgen)
    throws IOException
  {
    jgen.writeEndObject();
  }
  
  public void writeCustomTypePrefixForObject(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    if (typeId == null)
    {
      jgen.writeStartObject();
    }
    else if (jgen.canWriteTypeId())
    {
      jgen.writeTypeId(typeId);
      jgen.writeStartObject();
    }
    else
    {
      jgen.writeStartObject();
      jgen.writeStringField(_typePropertyName, typeId);
    }
  }
  
  public void writeCustomTypeSuffixForObject(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    jgen.writeEndObject();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */