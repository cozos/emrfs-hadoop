package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

@JacksonStdImpl
public class MapEntryDeserializer
  extends ContainerDeserializerBase<Map.Entry<Object, Object>>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _type;
  protected final KeyDeserializer _keyDeserializer;
  protected final JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  
  public MapEntryDeserializer(JavaType type, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser)
  {
    super(type);
    if (type.containedTypeCount() != 2) {
      throw new IllegalArgumentException("Missing generic type information for " + type);
    }
    _type = type;
    _keyDeserializer = keyDeser;
    _valueDeserializer = valueDeser;
    _valueTypeDeserializer = valueTypeDeser;
  }
  
  protected MapEntryDeserializer(MapEntryDeserializer src)
  {
    super(_type);
    _type = _type;
    _keyDeserializer = _keyDeserializer;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
  }
  
  protected MapEntryDeserializer(MapEntryDeserializer src, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser)
  {
    super(_type);
    _type = _type;
    _keyDeserializer = keyDeser;
    _valueDeserializer = valueDeser;
    _valueTypeDeserializer = valueTypeDeser;
  }
  
  protected MapEntryDeserializer withResolved(KeyDeserializer keyDeser, TypeDeserializer valueTypeDeser, JsonDeserializer<?> valueDeser)
  {
    if ((_keyDeserializer == keyDeser) && (_valueDeserializer == valueDeser) && (_valueTypeDeserializer == valueTypeDeser)) {
      return this;
    }
    return new MapEntryDeserializer(this, keyDeser, valueDeser, valueTypeDeser);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    KeyDeserializer kd = _keyDeserializer;
    if (kd == null) {
      kd = ctxt.findKeyDeserializer(_type.containedType(0), property);
    } else if ((kd instanceof ContextualKeyDeserializer)) {
      kd = ((ContextualKeyDeserializer)kd).createContextual(ctxt, property);
    }
    JsonDeserializer<?> vd = _valueDeserializer;
    vd = findConvertingContentDeserializer(ctxt, property, vd);
    JavaType contentType = _type.containedType(1);
    if (vd == null) {
      vd = ctxt.findContextualValueDeserializer(contentType, property);
    } else {
      vd = ctxt.handleSecondaryContextualization(vd, property, contentType);
    }
    TypeDeserializer vtd = _valueTypeDeserializer;
    if (vtd != null) {
      vtd = vtd.forProperty(property);
    }
    return withResolved(kd, vtd, vd);
  }
  
  public JavaType getContentType()
  {
    return _type.containedType(1);
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return _valueDeserializer;
  }
  
  public Map.Entry<Object, Object> deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if ((t != JsonToken.START_OBJECT) && (t != JsonToken.FIELD_NAME) && (t != JsonToken.END_OBJECT)) {
      return (Map.Entry)_deserializeFromEmpty(jp, ctxt);
    }
    if (t == JsonToken.START_OBJECT) {
      t = jp.nextToken();
    }
    if (t != JsonToken.FIELD_NAME)
    {
      if (t == JsonToken.END_OBJECT) {
        throw ctxt.mappingException("Can not deserialize a Map.Entry out of empty JSON Object");
      }
      throw ctxt.mappingException(handledType(), t);
    }
    KeyDeserializer keyDes = _keyDeserializer;
    JsonDeserializer<Object> valueDes = _valueDeserializer;
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    
    String keyStr = jp.getCurrentName();
    Object key = keyDes.deserializeKey(keyStr, ctxt);
    Object value = null;
    
    t = jp.nextToken();
    try
    {
      if (t == JsonToken.VALUE_NULL) {
        value = valueDes.getNullValue(ctxt);
      } else if (typeDeser == null) {
        value = valueDes.deserialize(jp, ctxt);
      } else {
        value = valueDes.deserializeWithType(jp, ctxt, typeDeser);
      }
    }
    catch (Exception e)
    {
      wrapAndThrow(e, Map.Entry.class, keyStr);
    }
    t = jp.nextToken();
    if (t != JsonToken.END_OBJECT)
    {
      if (t == JsonToken.FIELD_NAME) {
        throw ctxt.mappingException("Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '" + jp.getCurrentName() + "')");
      }
      throw ctxt.mappingException("Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + t);
    }
    return new AbstractMap.SimpleEntry(key, value);
  }
  
  public Map.Entry<Object, Object> deserialize(JsonParser jp, DeserializationContext ctxt, Map.Entry<Object, Object> result)
    throws IOException
  {
    throw new IllegalStateException("Can not update Map.Entry values");
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException, JsonProcessingException
  {
    return typeDeserializer.deserializeTypedFromObject(jp, ctxt);
  }
  
  public JavaType getValueType()
  {
    return _type;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */