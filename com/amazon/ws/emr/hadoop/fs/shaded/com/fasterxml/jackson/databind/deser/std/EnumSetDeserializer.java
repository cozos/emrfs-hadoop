package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.EnumSet;

public class EnumSetDeserializer
  extends StdDeserializer<EnumSet<?>>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _enumType;
  protected final Class<Enum> _enumClass;
  protected JsonDeserializer<Enum<?>> _enumDeserializer;
  
  public EnumSetDeserializer(JavaType enumType, JsonDeserializer<?> deser)
  {
    super(EnumSet.class);
    _enumType = enumType;
    _enumClass = enumType.getRawClass();
    if (!_enumClass.isEnum()) {
      throw new IllegalArgumentException("Type " + enumType + " not Java Enum type");
    }
    _enumDeserializer = deser;
  }
  
  public EnumSetDeserializer withDeserializer(JsonDeserializer<?> deser)
  {
    if (_enumDeserializer == deser) {
      return this;
    }
    return new EnumSetDeserializer(_enumType, deser);
  }
  
  public boolean isCachable()
  {
    if (_enumType.getValueHandler() != null) {
      return false;
    }
    return true;
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    JsonDeserializer<?> deser = _enumDeserializer;
    if (deser == null) {
      deser = ctxt.findContextualValueDeserializer(_enumType, property);
    } else {
      deser = ctxt.handleSecondaryContextualization(deser, property, _enumType);
    }
    return withDeserializer(deser);
  }
  
  public EnumSet<?> deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (!jp.isExpectedStartArrayToken()) {
      throw ctxt.mappingException(EnumSet.class);
    }
    EnumSet result = constructSet();
    try
    {
      JsonToken t;
      while ((t = jp.nextToken()) != JsonToken.END_ARRAY)
      {
        if (t == JsonToken.VALUE_NULL) {
          throw ctxt.mappingException(_enumClass);
        }
        Enum<?> value = (Enum)_enumDeserializer.deserialize(jp, ctxt);
        if (value != null) {
          result.add(value);
        }
      }
    }
    catch (Exception e)
    {
      throw JsonMappingException.wrapWithPath(e, result, result.size());
    }
    return result;
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException, JsonProcessingException
  {
    return typeDeserializer.deserializeTypedFromArray(jp, ctxt);
  }
  
  private EnumSet constructSet()
  {
    return EnumSet.noneOf(_enumClass);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */