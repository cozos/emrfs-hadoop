package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.IOException;

public class AsExistingPropertyTypeSerializer
  extends AsPropertyTypeSerializer
{
  public AsExistingPropertyTypeSerializer(TypeIdResolver idRes, BeanProperty property, String propName)
  {
    super(idRes, property, propName);
  }
  
  public AsExistingPropertyTypeSerializer forProperty(BeanProperty prop)
  {
    return _property == prop ? this : new AsExistingPropertyTypeSerializer(_idResolver, prop, _typePropertyName);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.EXISTING_PROPERTY;
  }
  
  public void writeTypePrefixForObject(Object value, JsonGenerator jgen)
    throws IOException
  {
    String typeId = idFromValue(value);
    if ((typeId != null) && (jgen.canWriteTypeId())) {
      jgen.writeTypeId(typeId);
    }
    jgen.writeStartObject();
  }
  
  public void writeTypePrefixForObject(Object value, JsonGenerator jgen, Class<?> type)
    throws IOException
  {
    String typeId = idFromValueAndType(value, type);
    if ((typeId != null) && (jgen.canWriteTypeId())) {
      jgen.writeTypeId(typeId);
    }
    jgen.writeStartObject();
  }
  
  public void writeCustomTypePrefixForObject(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    if ((typeId != null) && (jgen.canWriteTypeId())) {
      jgen.writeTypeId(typeId);
    }
    jgen.writeStartObject();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */