package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDeserializer
  extends CollectionDeserializer
{
  private static final long serialVersionUID = 1L;
  
  public ArrayBlockingQueueDeserializer(JavaType collectionType, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, ValueInstantiator valueInstantiator, JsonDeserializer<Object> delegateDeser)
  {
    super(collectionType, valueDeser, valueTypeDeser, valueInstantiator, delegateDeser);
  }
  
  protected ArrayBlockingQueueDeserializer(ArrayBlockingQueueDeserializer src)
  {
    super(src);
  }
  
  protected ArrayBlockingQueueDeserializer withResolved(JsonDeserializer<?> dd, JsonDeserializer<?> vd, TypeDeserializer vtd)
  {
    if ((dd == _delegateDeserializer) && (vd == _valueDeserializer) && (vtd == _valueTypeDeserializer)) {
      return this;
    }
    return new ArrayBlockingQueueDeserializer(_collectionType, vd, vtd, _valueInstantiator, dd);
  }
  
  public Collection<Object> deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return (Collection)_valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt));
    }
    if (jp.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      String str = jp.getText();
      if (str.length() == 0) {
        return (Collection)_valueInstantiator.createFromString(ctxt, str);
      }
    }
    return deserialize(jp, ctxt, null);
  }
  
  public Collection<Object> deserialize(JsonParser jp, DeserializationContext ctxt, Collection<Object> result0)
    throws IOException
  {
    if (!jp.isExpectedStartArrayToken()) {
      return handleNonArray(jp, ctxt, new ArrayBlockingQueue(1));
    }
    ArrayList<Object> tmp = new ArrayList();
    
    JsonDeserializer<Object> valueDes = _valueDeserializer;
    
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    try
    {
      JsonToken t;
      while ((t = jp.nextToken()) != JsonToken.END_ARRAY)
      {
        Object value;
        Object value;
        if (t == JsonToken.VALUE_NULL)
        {
          value = valueDes.getNullValue(ctxt);
        }
        else
        {
          Object value;
          if (typeDeser == null) {
            value = valueDes.deserialize(jp, ctxt);
          } else {
            value = valueDes.deserializeWithType(jp, ctxt, typeDeser);
          }
        }
        tmp.add(value);
      }
    }
    catch (Exception e)
    {
      throw JsonMappingException.wrapWithPath(e, tmp, tmp.size());
    }
    if (result0 != null)
    {
      result0.addAll(tmp);
      return result0;
    }
    return new ArrayBlockingQueue(tmp.size(), false, tmp);
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return typeDeserializer.deserializeTypedFromArray(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */