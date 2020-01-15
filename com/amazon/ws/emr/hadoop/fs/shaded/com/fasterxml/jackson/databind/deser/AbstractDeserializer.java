package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class AbstractDeserializer
  extends JsonDeserializer<Object>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _baseType;
  protected final ObjectIdReader _objectIdReader;
  protected final Map<String, SettableBeanProperty> _backRefProperties;
  protected final boolean _acceptString;
  protected final boolean _acceptBoolean;
  protected final boolean _acceptInt;
  protected final boolean _acceptDouble;
  
  public AbstractDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, Map<String, SettableBeanProperty> backRefProps)
  {
    _baseType = beanDesc.getType();
    _objectIdReader = builder.getObjectIdReader();
    _backRefProperties = backRefProps;
    Class<?> cls = _baseType.getRawClass();
    _acceptString = cls.isAssignableFrom(String.class);
    _acceptBoolean = ((cls == Boolean.TYPE) || (cls.isAssignableFrom(Boolean.class)));
    _acceptInt = ((cls == Integer.TYPE) || (cls.isAssignableFrom(Integer.class)));
    _acceptDouble = ((cls == Double.TYPE) || (cls.isAssignableFrom(Double.class)));
  }
  
  protected AbstractDeserializer(BeanDescription beanDesc)
  {
    _baseType = beanDesc.getType();
    _objectIdReader = null;
    _backRefProperties = null;
    Class<?> cls = _baseType.getRawClass();
    _acceptString = cls.isAssignableFrom(String.class);
    _acceptBoolean = ((cls == Boolean.TYPE) || (cls.isAssignableFrom(Boolean.class)));
    _acceptInt = ((cls == Integer.TYPE) || (cls.isAssignableFrom(Integer.class)));
    _acceptDouble = ((cls == Double.TYPE) || (cls.isAssignableFrom(Double.class)));
  }
  
  public static AbstractDeserializer constructForNonPOJO(BeanDescription beanDesc)
  {
    return new AbstractDeserializer(beanDesc);
  }
  
  public Class<?> handledType()
  {
    return _baseType.getRawClass();
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  public ObjectIdReader getObjectIdReader()
  {
    return _objectIdReader;
  }
  
  public SettableBeanProperty findBackReference(String logicalName)
  {
    return _backRefProperties == null ? null : (SettableBeanProperty)_backRefProperties.get(logicalName);
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException, JsonProcessingException
  {
    if (_objectIdReader != null)
    {
      JsonToken t = jp.getCurrentToken();
      if ((t != null) && (t.isScalarValue())) {
        return _deserializeFromObjectId(jp, ctxt);
      }
    }
    Object result = _deserializeIfNatural(jp, ctxt);
    if (result != null) {
      return result;
    }
    return typeDeserializer.deserializeTypedFromObject(jp, ctxt);
  }
  
  public Object deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    throw ctxt.instantiationException(_baseType.getRawClass(), "abstract types either need to be mapped to concrete types, have custom deserializer, or be instantiated with additional type information");
  }
  
  protected Object _deserializeIfNatural(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    switch (jp.getCurrentTokenId())
    {
    case 6: 
      if (_acceptString) {
        return jp.getText();
      }
      break;
    case 7: 
      if (_acceptInt) {
        return Integer.valueOf(jp.getIntValue());
      }
      break;
    case 8: 
      if (_acceptDouble) {
        return Double.valueOf(jp.getDoubleValue());
      }
      break;
    case 9: 
      if (_acceptBoolean) {
        return Boolean.TRUE;
      }
      break;
    case 10: 
      if (_acceptBoolean) {
        return Boolean.FALSE;
      }
      break;
    }
    return null;
  }
  
  protected Object _deserializeFromObjectId(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    Object id = _objectIdReader.readObjectReference(jp, ctxt);
    ReadableObjectId roid = ctxt.findObjectId(id, _objectIdReader.generator, _objectIdReader.resolver);
    
    Object pojo = roid.resolve();
    if (pojo == null) {
      throw new UnresolvedForwardReference("Could not resolve Object Id [" + id + "] -- unresolved forward-reference?", jp.getCurrentLocation(), roid);
    }
    return pojo;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.AbstractDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */