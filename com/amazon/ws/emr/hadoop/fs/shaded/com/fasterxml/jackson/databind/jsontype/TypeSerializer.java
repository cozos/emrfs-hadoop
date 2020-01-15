package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import java.io.IOException;

public abstract class TypeSerializer
{
  public abstract TypeSerializer forProperty(BeanProperty paramBeanProperty);
  
  public abstract JsonTypeInfo.As getTypeInclusion();
  
  public abstract String getPropertyName();
  
  public abstract TypeIdResolver getTypeIdResolver();
  
  public abstract void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public abstract void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public abstract void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public abstract void writeTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public abstract void writeTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public abstract void writeTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public void writeTypePrefixForScalar(Object value, JsonGenerator jgen, Class<?> type)
    throws IOException
  {
    writeTypePrefixForScalar(value, jgen);
  }
  
  public void writeTypePrefixForObject(Object value, JsonGenerator jgen, Class<?> type)
    throws IOException
  {
    writeTypePrefixForObject(value, jgen);
  }
  
  public void writeTypePrefixForArray(Object value, JsonGenerator jgen, Class<?> type)
    throws IOException
  {
    writeTypePrefixForArray(value, jgen);
  }
  
  public abstract void writeCustomTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException, JsonProcessingException;
  
  public abstract void writeCustomTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeCustomTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeCustomTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeCustomTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeCustomTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */