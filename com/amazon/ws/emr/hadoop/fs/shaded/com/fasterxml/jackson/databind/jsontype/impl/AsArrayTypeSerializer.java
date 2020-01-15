package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.IOException;

public class AsArrayTypeSerializer
  extends TypeSerializerBase
{
  public AsArrayTypeSerializer(TypeIdResolver idRes, BeanProperty property)
  {
    super(idRes, property);
  }
  
  public AsArrayTypeSerializer forProperty(BeanProperty prop)
  {
    return _property == prop ? this : new AsArrayTypeSerializer(_idResolver, prop);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.WRAPPER_ARRAY;
  }
  
  public void writeTypePrefixForObject(Object value, JsonGenerator jgen)
    throws IOException
  {
    String typeId = idFromValue(value);
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
    jgen.writeStartObject();
  }
  
  public void writeTypePrefixForObject(Object value, JsonGenerator jgen, Class<?> type)
    throws IOException
  {
    String typeId = idFromValueAndType(value, type);
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
    jgen.writeStartObject();
  }
  
  public void writeTypePrefixForArray(Object value, JsonGenerator jgen)
    throws IOException
  {
    String typeId = idFromValue(value);
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
    jgen.writeStartArray();
  }
  
  public void writeTypePrefixForArray(Object value, JsonGenerator jgen, Class<?> type)
    throws IOException
  {
    String typeId = idFromValueAndType(value, type);
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
    jgen.writeStartArray();
  }
  
  public void writeTypePrefixForScalar(Object value, JsonGenerator jgen)
    throws IOException
  {
    String typeId = idFromValue(value);
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
  }
  
  public void writeTypePrefixForScalar(Object value, JsonGenerator jgen, Class<?> type)
    throws IOException
  {
    String typeId = idFromValueAndType(value, type);
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
  }
  
  public void writeTypeSuffixForObject(Object value, JsonGenerator jgen)
    throws IOException
  {
    jgen.writeEndObject();
    if (!jgen.canWriteTypeId()) {
      jgen.writeEndArray();
    }
  }
  
  public void writeTypeSuffixForArray(Object value, JsonGenerator jgen)
    throws IOException
  {
    jgen.writeEndArray();
    if (!jgen.canWriteTypeId()) {
      jgen.writeEndArray();
    }
  }
  
  public void writeTypeSuffixForScalar(Object value, JsonGenerator jgen)
    throws IOException
  {
    if (!jgen.canWriteTypeId()) {
      jgen.writeEndArray();
    }
  }
  
  public void writeCustomTypePrefixForObject(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
    jgen.writeStartObject();
  }
  
  public void writeCustomTypePrefixForArray(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
    jgen.writeStartArray();
  }
  
  public void writeCustomTypePrefixForScalar(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    if (jgen.canWriteTypeId())
    {
      if (typeId != null) {
        jgen.writeTypeId(typeId);
      }
    }
    else
    {
      jgen.writeStartArray();
      jgen.writeString(typeId);
    }
  }
  
  public void writeCustomTypeSuffixForObject(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    if (!jgen.canWriteTypeId()) {
      writeTypeSuffixForObject(value, jgen);
    }
  }
  
  public void writeCustomTypeSuffixForArray(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    if (!jgen.canWriteTypeId()) {
      writeTypeSuffixForArray(value, jgen);
    }
  }
  
  public void writeCustomTypeSuffixForScalar(Object value, JsonGenerator jgen, String typeId)
    throws IOException
  {
    if (!jgen.canWriteTypeId()) {
      writeTypeSuffixForScalar(value, jgen);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */