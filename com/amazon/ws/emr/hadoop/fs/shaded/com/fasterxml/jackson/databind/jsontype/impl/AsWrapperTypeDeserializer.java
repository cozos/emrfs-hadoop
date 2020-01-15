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

public class AsWrapperTypeDeserializer
  extends TypeDeserializerBase
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  public AsWrapperTypeDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, Class<?> defaultImpl)
  {
    super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl);
  }
  
  protected AsWrapperTypeDeserializer(AsWrapperTypeDeserializer src, BeanProperty property)
  {
    super(src, property);
  }
  
  public TypeDeserializer forProperty(BeanProperty prop)
  {
    return prop == _property ? this : new AsWrapperTypeDeserializer(this, prop);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.WRAPPER_OBJECT;
  }
  
  public Object deserializeTypedFromObject(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _deserialize(jp, ctxt);
  }
  
  public Object deserializeTypedFromArray(JsonParser jp, DeserializationContext ctxt)
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
    JsonToken t = p.getCurrentToken();
    if (t == JsonToken.START_OBJECT)
    {
      if (p.nextToken() != JsonToken.FIELD_NAME) {
        throw ctxt.wrongTokenException(p, JsonToken.FIELD_NAME, "need JSON String that contains type id (for subtype of " + baseTypeName() + ")");
      }
    }
    else if (t != JsonToken.FIELD_NAME) {
      throw ctxt.wrongTokenException(p, JsonToken.START_OBJECT, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + baseTypeName());
    }
    String typeId = p.getText();
    JsonDeserializer<Object> deser = _findDeserializer(ctxt, typeId);
    p.nextToken();
    if ((_typeIdVisible) && (p.getCurrentToken() == JsonToken.START_OBJECT))
    {
      TokenBuffer tb = new TokenBuffer(null, false);
      tb.writeStartObject();
      tb.writeFieldName(_typePropertyName);
      tb.writeString(typeId);
      p = JsonParserSequence.createFlattened(tb.asParser(p), p);
      p.nextToken();
    }
    Object value = deser.deserialize(p, ctxt);
    if (p.nextToken() != JsonToken.END_OBJECT) {
      throw ctxt.wrongTokenException(p, JsonToken.END_OBJECT, "expected closing END_OBJECT after type information and deserialized value");
    }
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.AsWrapperTypeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */