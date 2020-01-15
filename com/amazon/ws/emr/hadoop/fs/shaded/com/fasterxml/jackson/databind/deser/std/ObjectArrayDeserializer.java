package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ArrayType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.lang.reflect.Array;

@JacksonStdImpl
public class ObjectArrayDeserializer
  extends ContainerDeserializerBase<Object[]>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final ArrayType _arrayType;
  protected final boolean _untyped;
  protected final Class<?> _elementClass;
  protected JsonDeserializer<Object> _elementDeserializer;
  protected final TypeDeserializer _elementTypeDeserializer;
  
  public ObjectArrayDeserializer(ArrayType arrayType, JsonDeserializer<Object> elemDeser, TypeDeserializer elemTypeDeser)
  {
    super(arrayType);
    _arrayType = arrayType;
    _elementClass = arrayType.getContentType().getRawClass();
    _untyped = (_elementClass == Object.class);
    _elementDeserializer = elemDeser;
    _elementTypeDeserializer = elemTypeDeser;
  }
  
  public ObjectArrayDeserializer withDeserializer(TypeDeserializer elemTypeDeser, JsonDeserializer<?> elemDeser)
  {
    if ((elemDeser == _elementDeserializer) && (elemTypeDeser == _elementTypeDeserializer)) {
      return this;
    }
    return new ObjectArrayDeserializer(_arrayType, elemDeser, elemTypeDeser);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    JsonDeserializer<?> deser = _elementDeserializer;
    
    deser = findConvertingContentDeserializer(ctxt, property, deser);
    JavaType vt = _arrayType.getContentType();
    if (deser == null) {
      deser = ctxt.findContextualValueDeserializer(vt, property);
    } else {
      deser = ctxt.handleSecondaryContextualization(deser, property, vt);
    }
    TypeDeserializer elemTypeDeser = _elementTypeDeserializer;
    if (elemTypeDeser != null) {
      elemTypeDeser = elemTypeDeser.forProperty(property);
    }
    return withDeserializer(elemTypeDeser, deser);
  }
  
  public boolean isCachable()
  {
    return (_elementDeserializer == null) && (_elementTypeDeserializer == null);
  }
  
  public JavaType getContentType()
  {
    return _arrayType.getContentType();
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return _elementDeserializer;
  }
  
  public Object[] deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if (!jp.isExpectedStartArrayToken()) {
      return handleNonArray(jp, ctxt);
    }
    ObjectBuffer buffer = ctxt.leaseObjectBuffer();
    Object[] chunk = buffer.resetAndStart();
    int ix = 0;
    
    TypeDeserializer typeDeser = _elementTypeDeserializer;
    try
    {
      JsonToken t;
      while ((t = jp.nextToken()) != JsonToken.END_ARRAY)
      {
        Object value;
        Object value;
        if (t == JsonToken.VALUE_NULL)
        {
          value = _elementDeserializer.getNullValue(ctxt);
        }
        else
        {
          Object value;
          if (typeDeser == null) {
            value = _elementDeserializer.deserialize(jp, ctxt);
          } else {
            value = _elementDeserializer.deserializeWithType(jp, ctxt, typeDeser);
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
    Object[] result;
    Object[] result;
    if (_untyped) {
      result = buffer.completeAndClearBuffer(chunk, ix);
    } else {
      result = buffer.completeAndClearBuffer(chunk, ix, _elementClass);
    }
    ctxt.returnObjectBuffer(buffer);
    return result;
  }
  
  public Object[] deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException, JsonProcessingException
  {
    return (Object[])typeDeserializer.deserializeTypedFromArray(jp, ctxt);
  }
  
  protected Byte[] deserializeFromBase64(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    byte[] b = jp.getBinaryValue(ctxt.getBase64Variant());
    
    Byte[] result = new Byte[b.length];
    int i = 0;
    for (int len = b.length; i < len; i++) {
      result[i] = Byte.valueOf(b[i]);
    }
    return result;
  }
  
  private final Object[] handleNonArray(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if ((jp.getCurrentToken() == JsonToken.VALUE_STRING) && (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)))
    {
      String str = jp.getText();
      if (str.length() == 0) {
        return null;
      }
    }
    if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
    {
      if ((jp.getCurrentToken() == JsonToken.VALUE_STRING) && (_elementClass == Byte.class)) {
        return deserializeFromBase64(jp, ctxt);
      }
      throw ctxt.mappingException(_arrayType.getRawClass());
    }
    JsonToken t = jp.getCurrentToken();
    Object value;
    Object value;
    if (t == JsonToken.VALUE_NULL)
    {
      value = _elementDeserializer.getNullValue(ctxt);
    }
    else
    {
      Object value;
      if (_elementTypeDeserializer == null) {
        value = _elementDeserializer.deserialize(jp, ctxt);
      } else {
        value = _elementDeserializer.deserializeWithType(jp, ctxt, _elementTypeDeserializer);
      }
    }
    Object[] result;
    Object[] result;
    if (_untyped) {
      result = new Object[1];
    } else {
      result = (Object[])Array.newInstance(_elementClass, 1);
    }
    result[0] = value;
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */