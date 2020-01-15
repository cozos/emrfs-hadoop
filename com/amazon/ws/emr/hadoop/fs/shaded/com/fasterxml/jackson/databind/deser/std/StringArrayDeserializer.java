package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;

@JacksonStdImpl
public final class StringArrayDeserializer
  extends StdDeserializer<String[]>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  public static final StringArrayDeserializer instance = new StringArrayDeserializer();
  protected JsonDeserializer<String> _elementDeserializer;
  
  public StringArrayDeserializer()
  {
    super(String[].class);
    _elementDeserializer = null;
  }
  
  protected StringArrayDeserializer(JsonDeserializer<?> deser)
  {
    super(String[].class);
    _elementDeserializer = deser;
  }
  
  public String[] deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (!jp.isExpectedStartArrayToken()) {
      return handleNonArray(jp, ctxt);
    }
    if (_elementDeserializer != null) {
      return _deserializeCustom(jp, ctxt);
    }
    ObjectBuffer buffer = ctxt.leaseObjectBuffer();
    Object[] chunk = buffer.resetAndStart();
    
    int ix = 0;
    try
    {
      for (;;)
      {
        String value = jp.nextTextValue();
        if (value == null)
        {
          JsonToken t = jp.getCurrentToken();
          if (t == JsonToken.END_ARRAY) {
            break;
          }
          if (t != JsonToken.VALUE_NULL) {
            value = _parseString(jp, ctxt);
          }
        }
        if (ix >= chunk.length)
        {
          chunk = buffer.appendCompletedChunk(chunk);
          ix = 0;
        }
        chunk[(ix++)] = value;
      }
    }
    catch (Exception e)
    {
      throw JsonMappingException.wrapWithPath(e, chunk, buffer.bufferedSize() + ix);
    }
    String[] result = (String[])buffer.completeAndClearBuffer(chunk, ix, String.class);
    ctxt.returnObjectBuffer(buffer);
    return result;
  }
  
  protected final String[] _deserializeCustom(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    ObjectBuffer buffer = ctxt.leaseObjectBuffer();
    Object[] chunk = buffer.resetAndStart();
    JsonDeserializer<String> deser = _elementDeserializer;
    
    int ix = 0;
    try
    {
      for (;;)
      {
        String value;
        String value;
        if (jp.nextTextValue() == null)
        {
          JsonToken t = jp.getCurrentToken();
          if (t == JsonToken.END_ARRAY) {
            break;
          }
          value = t == JsonToken.VALUE_NULL ? (String)deser.getNullValue(ctxt) : (String)deser.deserialize(jp, ctxt);
        }
        else
        {
          value = (String)deser.deserialize(jp, ctxt);
        }
        if (ix >= chunk.length)
        {
          chunk = buffer.appendCompletedChunk(chunk);
          ix = 0;
        }
        chunk[(ix++)] = value;
      }
    }
    catch (Exception e)
    {
      throw JsonMappingException.wrapWithPath(e, String.class, ix);
    }
    String[] result = (String[])buffer.completeAndClearBuffer(chunk, ix, String.class);
    ctxt.returnObjectBuffer(buffer);
    return result;
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return typeDeserializer.deserializeTypedFromArray(jp, ctxt);
  }
  
  private final String[] handleNonArray(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
    {
      if ((jp.getCurrentToken() == JsonToken.VALUE_STRING) && (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)))
      {
        String str = jp.getText();
        if (str.length() == 0) {
          return null;
        }
      }
      throw ctxt.mappingException(_valueClass);
    }
    return new String[] { jp.getCurrentToken() == JsonToken.VALUE_NULL ? null : _parseString(jp, ctxt) };
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    JsonDeserializer<?> deser = _elementDeserializer;
    
    deser = findConvertingContentDeserializer(ctxt, property, deser);
    JavaType type = ctxt.constructType(String.class);
    if (deser == null) {
      deser = ctxt.findContextualValueDeserializer(type, property);
    } else {
      deser = ctxt.handleSecondaryContextualization(deser, property, type);
    }
    if ((deser != null) && (isDefaultDeserializer(deser))) {
      deser = null;
    }
    if (_elementDeserializer != deser) {
      return new StringArrayDeserializer(deser);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */