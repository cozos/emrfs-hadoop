package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;

public abstract class TypeDeserializer
{
  public abstract TypeDeserializer forProperty(BeanProperty paramBeanProperty);
  
  public abstract JsonTypeInfo.As getTypeInclusion();
  
  public abstract String getPropertyName();
  
  public abstract TypeIdResolver getTypeIdResolver();
  
  public abstract Class<?> getDefaultImpl();
  
  public abstract Object deserializeTypedFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public abstract Object deserializeTypedFromArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public abstract Object deserializeTypedFromScalar(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public abstract Object deserializeTypedFromAny(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public static Object deserializeIfNatural(JsonParser jp, DeserializationContext ctxt, JavaType baseType)
    throws IOException
  {
    return deserializeIfNatural(jp, ctxt, baseType.getRawClass());
  }
  
  public static Object deserializeIfNatural(JsonParser jp, DeserializationContext ctxt, Class<?> base)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == null) {
      return null;
    }
    switch (t)
    {
    case VALUE_STRING: 
      if (base.isAssignableFrom(String.class)) {
        return jp.getText();
      }
      break;
    case VALUE_NUMBER_INT: 
      if (base.isAssignableFrom(Integer.class)) {
        return Integer.valueOf(jp.getIntValue());
      }
      break;
    case VALUE_NUMBER_FLOAT: 
      if (base.isAssignableFrom(Double.class)) {
        return Double.valueOf(jp.getDoubleValue());
      }
      break;
    case VALUE_TRUE: 
      if (base.isAssignableFrom(Boolean.class)) {
        return Boolean.TRUE;
      }
      break;
    case VALUE_FALSE: 
      if (base.isAssignableFrom(Boolean.class)) {
        return Boolean.FALSE;
      }
      break;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */