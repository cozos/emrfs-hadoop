package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.JsonParserSequence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;

public class AsArrayTypeDeserializer
  extends TypeDeserializerBase
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  public AsArrayTypeDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, Class<?> defaultImpl)
  {
    super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl);
  }
  
  public AsArrayTypeDeserializer(AsArrayTypeDeserializer src, BeanProperty property)
  {
    super(src, property);
  }
  
  public TypeDeserializer forProperty(BeanProperty prop)
  {
    return prop == _property ? this : new AsArrayTypeDeserializer(this, prop);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.WRAPPER_ARRAY;
  }
  
  public Object deserializeTypedFromArray(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _deserialize(jp, ctxt);
  }
  
  public Object deserializeTypedFromObject(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _deserialize(jp, ctxt);
  }
  
  public Object deserializeTypedFromScalar(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _deserialize(jp, ctxt);
  }
  
  public Object deserializeTypedFromAny(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _deserialize(jp, ctxt);
  }
  
  protected Object _deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (p.canReadTypeId())
    {
      Object typeId = p.getTypeId();
      if (typeId != null) {
        return _deserializeWithNativeTypeId(p, ctxt, typeId);
      }
    }
    boolean hadStartArray = p.isExpectedStartArrayToken();
    String typeId = _locateTypeId(p, ctxt);
    JsonDeserializer<Object> deser = _findDeserializer(ctxt, typeId);
    if ((_typeIdVisible) && (!_usesExternalId()) && (p.getCurrentToken() == JsonToken.START_OBJECT))
    {
      TokenBuffer tb = new TokenBuffer(null, false);
      tb.writeStartObject();
      tb.writeFieldName(_typePropertyName);
      tb.writeString(typeId);
      p = JsonParserSequence.createFlattened(tb.asParser(p), p);
      p.nextToken();
    }
    Object value = deser.deserialize(p, ctxt);
    if ((hadStartArray) && (p.nextToken() != JsonToken.END_ARRAY)) {
      throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "expected closing END_ARRAY after type information and deserialized value");
    }
    return value;
  }
  
  protected String _locateTypeId(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (!jp.isExpectedStartArrayToken())
    {
      if (_defaultImpl != null) {
        return _idResolver.idFromBaseType();
      }
      throw ctxt.wrongTokenException(jp, JsonToken.START_ARRAY, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + baseTypeName());
    }
    JsonToken t = jp.nextToken();
    if (t == JsonToken.VALUE_STRING)
    {
      String result = jp.getText();
      jp.nextToken();
      return result;
    }
    if (_defaultImpl != null) {
      return _idResolver.idFromBaseType();
    }
    throw ctxt.wrongTokenException(jp, JsonToken.VALUE_STRING, "need JSON String that contains type id (for subtype of " + baseTypeName() + ")");
  }
  
  protected boolean _usesExternalId()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */