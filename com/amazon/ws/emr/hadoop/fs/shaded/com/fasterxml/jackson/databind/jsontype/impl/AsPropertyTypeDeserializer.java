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

public class AsPropertyTypeDeserializer
  extends AsArrayTypeDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JsonTypeInfo.As _inclusion;
  
  public AsPropertyTypeDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, Class<?> defaultImpl)
  {
    this(bt, idRes, typePropertyName, typeIdVisible, defaultImpl, JsonTypeInfo.As.PROPERTY);
  }
  
  public AsPropertyTypeDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, Class<?> defaultImpl, JsonTypeInfo.As inclusion)
  {
    super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl);
    _inclusion = inclusion;
  }
  
  public AsPropertyTypeDeserializer(AsPropertyTypeDeserializer src, BeanProperty property)
  {
    super(src, property);
    _inclusion = _inclusion;
  }
  
  public TypeDeserializer forProperty(BeanProperty prop)
  {
    return prop == _property ? this : new AsPropertyTypeDeserializer(this, prop);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return _inclusion;
  }
  
  public Object deserializeTypedFromObject(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (jp.canReadTypeId())
    {
      Object typeId = jp.getTypeId();
      if (typeId != null) {
        return _deserializeWithNativeTypeId(jp, ctxt, typeId);
      }
    }
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.START_OBJECT)
    {
      t = jp.nextToken();
    }
    else
    {
      if (t == JsonToken.START_ARRAY) {
        return _deserializeTypedUsingDefaultImpl(jp, ctxt, null);
      }
      if (t != JsonToken.FIELD_NAME) {
        return _deserializeTypedUsingDefaultImpl(jp, ctxt, null);
      }
    }
    TokenBuffer tb = null;
    for (; t == JsonToken.FIELD_NAME; t = jp.nextToken())
    {
      String name = jp.getCurrentName();
      jp.nextToken();
      if (_typePropertyName.equals(name)) {
        return _deserializeTypedForId(jp, ctxt, tb);
      }
      if (tb == null) {
        tb = new TokenBuffer(jp, ctxt);
      }
      tb.writeFieldName(name);
      tb.copyCurrentStructure(jp);
    }
    return _deserializeTypedUsingDefaultImpl(jp, ctxt, tb);
  }
  
  protected Object _deserializeTypedForId(JsonParser jp, DeserializationContext ctxt, TokenBuffer tb)
    throws IOException
  {
    String typeId = jp.getText();
    JsonDeserializer<Object> deser = _findDeserializer(ctxt, typeId);
    if (_typeIdVisible)
    {
      if (tb == null) {
        tb = new TokenBuffer(jp, ctxt);
      }
      tb.writeFieldName(jp.getCurrentName());
      tb.writeString(typeId);
    }
    if (tb != null) {
      jp = JsonParserSequence.createFlattened(tb.asParser(jp), jp);
    }
    jp.nextToken();
    
    return deser.deserialize(jp, ctxt);
  }
  
  protected Object _deserializeTypedUsingDefaultImpl(JsonParser jp, DeserializationContext ctxt, TokenBuffer tb)
    throws IOException
  {
    JsonDeserializer<Object> deser = _findDefaultImplDeserializer(ctxt);
    if (deser != null)
    {
      if (tb != null)
      {
        tb.writeEndObject();
        jp = tb.asParser(jp);
        
        jp.nextToken();
      }
      return deser.deserialize(jp, ctxt);
    }
    Object result = TypeDeserializer.deserializeIfNatural(jp, ctxt, _baseType);
    if (result != null) {
      return result;
    }
    if (jp.getCurrentToken() == JsonToken.START_ARRAY) {
      return super.deserializeTypedFromAny(jp, ctxt);
    }
    throw ctxt.wrongTokenException(jp, JsonToken.FIELD_NAME, "missing property '" + _typePropertyName + "' that is to contain type id  (for class " + baseTypeName() + ")");
  }
  
  public Object deserializeTypedFromAny(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (jp.getCurrentToken() == JsonToken.START_ARRAY) {
      return super.deserializeTypedFromArray(jp, ctxt);
    }
    return deserializeTypedFromObject(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */