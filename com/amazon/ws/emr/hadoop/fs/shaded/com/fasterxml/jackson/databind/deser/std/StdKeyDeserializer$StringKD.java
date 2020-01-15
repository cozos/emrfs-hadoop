package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
final class StdKeyDeserializer$StringKD
  extends StdKeyDeserializer
{
  private static final long serialVersionUID = 1L;
  private static final StringKD sString = new StringKD(String.class);
  private static final StringKD sObject = new StringKD(Object.class);
  
  private StdKeyDeserializer$StringKD(Class<?> nominalType)
  {
    super(-1, nominalType);
  }
  
  public static StringKD forType(Class<?> nominalType)
  {
    if (nominalType == String.class) {
      return sString;
    }
    if (nominalType == Object.class) {
      return sObject;
    }
    return new StringKD(nominalType);
  }
  
  public Object deserializeKey(String key, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    return key;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringKD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */