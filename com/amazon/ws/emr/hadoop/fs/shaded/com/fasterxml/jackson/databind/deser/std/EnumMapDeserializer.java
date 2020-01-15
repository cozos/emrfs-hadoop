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
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.EnumMap;

public class EnumMapDeserializer
  extends ContainerDeserializerBase<EnumMap<?, ?>>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _mapType;
  protected final Class<?> _enumClass;
  protected KeyDeserializer _keyDeserializer;
  protected JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  
  public EnumMapDeserializer(JavaType mapType, KeyDeserializer keyDeserializer, JsonDeserializer<?> valueDeser, TypeDeserializer valueTypeDeser)
  {
    super(mapType);
    _mapType = mapType;
    _enumClass = mapType.getKeyType().getRawClass();
    _keyDeserializer = keyDeserializer;
    _valueDeserializer = valueDeser;
    _valueTypeDeserializer = valueTypeDeser;
  }
  
  public EnumMapDeserializer withResolved(KeyDeserializer keyDeserializer, JsonDeserializer<?> valueDeserializer, TypeDeserializer valueTypeDeser)
  {
    if ((keyDeserializer == _keyDeserializer) && (valueDeserializer == _valueDeserializer) && (valueTypeDeser == _valueTypeDeserializer)) {
      return this;
    }
    return new EnumMapDeserializer(_mapType, keyDeserializer, valueDeserializer, _valueTypeDeserializer);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    KeyDeserializer kd = _keyDeserializer;
    if (kd == null) {
      kd = ctxt.findKeyDeserializer(_mapType.getKeyType(), property);
    }
    JsonDeserializer<?> vd = _valueDeserializer;
    JavaType vt = _mapType.getContentType();
    if (vd == null) {
      vd = ctxt.findContextualValueDeserializer(vt, property);
    } else {
      vd = ctxt.handleSecondaryContextualization(vd, property, vt);
    }
    TypeDeserializer vtd = _valueTypeDeserializer;
    if (vtd != null) {
      vtd = vtd.forProperty(property);
    }
    return withResolved(kd, vd, vtd);
  }
  
  public boolean isCachable()
  {
    return (_valueDeserializer == null) && (_keyDeserializer == null) && (_valueTypeDeserializer == null);
  }
  
  public JavaType getContentType()
  {
    return _mapType.getContentType();
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return _valueDeserializer;
  }
  
  public EnumMap<?, ?> deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (jp.getCurrentToken() != JsonToken.START_OBJECT) {
      return (EnumMap)_deserializeFromEmpty(jp, ctxt);
    }
    EnumMap result = constructMap();
    JsonDeserializer<Object> valueDes = _valueDeserializer;
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    while (jp.nextToken() == JsonToken.FIELD_NAME)
    {
      String keyName = jp.getCurrentName();
      
      Enum<?> key = (Enum)_keyDeserializer.deserializeKey(keyName, ctxt);
      if (key == null)
      {
        if (!ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
          throw ctxt.weirdStringException(keyName, _enumClass, "value not one of declared Enum instance names for " + _mapType.getKeyType());
        }
        jp.nextToken();
        jp.skipChildren();
      }
      else
      {
        JsonToken t = jp.nextToken();
        Object value;
        try
        {
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
        }
        catch (Exception e)
        {
          wrapAndThrow(e, result, keyName);
          return null;
        }
        result.put(key, value);
      }
    }
    return result;
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException, JsonProcessingException
  {
    return typeDeserializer.deserializeTypedFromObject(jp, ctxt);
  }
  
  protected EnumMap<?, ?> constructMap()
  {
    return new EnumMap(_enumClass);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */