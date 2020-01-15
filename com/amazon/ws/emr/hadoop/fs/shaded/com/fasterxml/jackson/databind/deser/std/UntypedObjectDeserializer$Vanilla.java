package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@JacksonStdImpl
public class UntypedObjectDeserializer$Vanilla
  extends StdDeserializer<Object>
{
  private static final long serialVersionUID = 1L;
  public static final Vanilla std = new Vanilla();
  
  public UntypedObjectDeserializer$Vanilla()
  {
    super(Object.class);
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 1: 
      JsonToken t = p.nextToken();
      if (t == JsonToken.END_OBJECT) {
        return new LinkedHashMap(2);
      }
    case 5: 
      return mapObject(p, ctxt);
    case 3: 
      JsonToken t = p.nextToken();
      if (t == JsonToken.END_ARRAY)
      {
        if (ctxt.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
          return UntypedObjectDeserializer.NO_OBJECTS;
        }
        return new ArrayList(2);
      }
      if (ctxt.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
        return mapArrayToArray(p, ctxt);
      }
      return mapArray(p, ctxt);
    case 12: 
      return p.getEmbeddedObject();
    case 6: 
      return p.getText();
    case 7: 
      if (ctxt.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
        return _coerceIntegral(p, ctxt);
      }
      return p.getNumberValue();
    case 8: 
      if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return p.getDecimalValue();
      }
      return Double.valueOf(p.getDoubleValue());
    case 9: 
      return Boolean.TRUE;
    case 10: 
      return Boolean.FALSE;
    case 11: 
      return null;
    case 2: 
      return new LinkedHashMap(2);
    }
    throw ctxt.mappingException(Object.class);
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    switch (jp.getCurrentTokenId())
    {
    case 1: 
    case 3: 
    case 5: 
      return typeDeserializer.deserializeTypedFromAny(jp, ctxt);
    case 6: 
      return jp.getText();
    case 7: 
      if (ctxt.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
        return jp.getBigIntegerValue();
      }
      return jp.getNumberValue();
    case 8: 
      if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return jp.getDecimalValue();
      }
      return Double.valueOf(jp.getDoubleValue());
    case 9: 
      return Boolean.TRUE;
    case 10: 
      return Boolean.FALSE;
    case 12: 
      return jp.getEmbeddedObject();
    case 11: 
      return null;
    }
    throw ctxt.mappingException(Object.class);
  }
  
  protected Object mapArray(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    Object value = deserialize(jp, ctxt);
    if (jp.nextToken() == JsonToken.END_ARRAY)
    {
      ArrayList<Object> l = new ArrayList(2);
      l.add(value);
      return l;
    }
    Object value2 = deserialize(jp, ctxt);
    if (jp.nextToken() == JsonToken.END_ARRAY)
    {
      ArrayList<Object> l = new ArrayList(2);
      l.add(value);
      l.add(value2);
      return l;
    }
    ObjectBuffer buffer = ctxt.leaseObjectBuffer();
    Object[] values = buffer.resetAndStart();
    int ptr = 0;
    values[(ptr++)] = value;
    values[(ptr++)] = value2;
    int totalSize = ptr;
    do
    {
      value = deserialize(jp, ctxt);
      totalSize++;
      if (ptr >= values.length)
      {
        values = buffer.appendCompletedChunk(values);
        ptr = 0;
      }
      values[(ptr++)] = value;
    } while (jp.nextToken() != JsonToken.END_ARRAY);
    ArrayList<Object> result = new ArrayList(totalSize);
    buffer.completeAndClearBuffer(values, ptr, result);
    return result;
  }
  
  protected Object mapObject(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    String key1 = p.getText();
    p.nextToken();
    Object value1 = deserialize(p, ctxt);
    
    String key2 = p.nextFieldName();
    if (key2 == null)
    {
      LinkedHashMap<String, Object> result = new LinkedHashMap(2);
      result.put(key1, value1);
      return result;
    }
    p.nextToken();
    Object value2 = deserialize(p, ctxt);
    
    String key = p.nextFieldName();
    if (key == null)
    {
      LinkedHashMap<String, Object> result = new LinkedHashMap(4);
      result.put(key1, value1);
      result.put(key2, value2);
      return result;
    }
    LinkedHashMap<String, Object> result = new LinkedHashMap();
    result.put(key1, value1);
    result.put(key2, value2);
    do
    {
      p.nextToken();
      result.put(key, deserialize(p, ctxt));
    } while ((key = p.nextFieldName()) != null);
    return result;
  }
  
  protected Object[] mapArrayToArray(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    ObjectBuffer buffer = ctxt.leaseObjectBuffer();
    Object[] values = buffer.resetAndStart();
    int ptr = 0;
    do
    {
      Object value = deserialize(jp, ctxt);
      if (ptr >= values.length)
      {
        values = buffer.appendCompletedChunk(values);
        ptr = 0;
      }
      values[(ptr++)] = value;
    } while (jp.nextToken() != JsonToken.END_ARRAY);
    return buffer.completeAndClearBuffer(values, ptr);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */