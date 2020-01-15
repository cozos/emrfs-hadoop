package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TypeDeserializerBase
  extends TypeDeserializer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final TypeIdResolver _idResolver;
  protected final JavaType _baseType;
  protected final BeanProperty _property;
  protected final JavaType _defaultImpl;
  protected final String _typePropertyName;
  protected final boolean _typeIdVisible;
  protected final Map<String, JsonDeserializer<Object>> _deserializers;
  protected JsonDeserializer<Object> _defaultImplDeserializer;
  
  protected TypeDeserializerBase(JavaType baseType, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, Class<?> defaultImpl)
  {
    _baseType = baseType;
    _idResolver = idRes;
    _typePropertyName = typePropertyName;
    _typeIdVisible = typeIdVisible;
    
    _deserializers = new ConcurrentHashMap(16, 0.75F, 4);
    if (defaultImpl == null) {
      _defaultImpl = null;
    } else {
      _defaultImpl = baseType.forcedNarrowBy(defaultImpl);
    }
    _property = null;
  }
  
  protected TypeDeserializerBase(TypeDeserializerBase src, BeanProperty property)
  {
    _baseType = _baseType;
    _idResolver = _idResolver;
    _typePropertyName = _typePropertyName;
    _typeIdVisible = _typeIdVisible;
    _deserializers = _deserializers;
    _defaultImpl = _defaultImpl;
    _defaultImplDeserializer = _defaultImplDeserializer;
    _property = property;
  }
  
  public abstract TypeDeserializer forProperty(BeanProperty paramBeanProperty);
  
  public abstract JsonTypeInfo.As getTypeInclusion();
  
  public String baseTypeName()
  {
    return _baseType.getRawClass().getName();
  }
  
  public final String getPropertyName()
  {
    return _typePropertyName;
  }
  
  public TypeIdResolver getTypeIdResolver()
  {
    return _idResolver;
  }
  
  public Class<?> getDefaultImpl()
  {
    return _defaultImpl == null ? null : _defaultImpl.getRawClass();
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append('[').append(getClass().getName());
    sb.append("; base-type:").append(_baseType);
    sb.append("; id-resolver: ").append(_idResolver);
    sb.append(']');
    return sb.toString();
  }
  
  protected final JsonDeserializer<Object> _findDeserializer(DeserializationContext ctxt, String typeId)
    throws IOException
  {
    JsonDeserializer<Object> deser = (JsonDeserializer)_deserializers.get(typeId);
    if (deser == null)
    {
      JavaType type = _idResolver.typeFromId(ctxt, typeId);
      if (type == null)
      {
        deser = _findDefaultImplDeserializer(ctxt);
        if (deser == null) {
          deser = _handleUnknownTypeId(ctxt, typeId, _idResolver, _baseType);
        }
      }
      else
      {
        if ((_baseType != null) && (_baseType.getClass() == type.getClass())) {
          type = ctxt.getTypeFactory().constructSpecializedType(_baseType, type.getRawClass());
        }
        deser = ctxt.findContextualValueDeserializer(type, _property);
      }
      _deserializers.put(typeId, deser);
    }
    return deser;
  }
  
  protected final JsonDeserializer<Object> _findDefaultImplDeserializer(DeserializationContext ctxt)
    throws IOException
  {
    if (_defaultImpl == null)
    {
      if (!ctxt.isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
        return NullifyingDeserializer.instance;
      }
      return null;
    }
    Class<?> raw = _defaultImpl.getRawClass();
    if (ClassUtil.isBogusClass(raw)) {
      return NullifyingDeserializer.instance;
    }
    synchronized (_defaultImpl)
    {
      if (_defaultImplDeserializer == null) {
        _defaultImplDeserializer = ctxt.findContextualValueDeserializer(_defaultImpl, _property);
      }
      return _defaultImplDeserializer;
    }
  }
  
  @Deprecated
  protected Object _deserializeWithNativeTypeId(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _deserializeWithNativeTypeId(jp, ctxt, jp.getTypeId());
  }
  
  protected Object _deserializeWithNativeTypeId(JsonParser jp, DeserializationContext ctxt, Object typeId)
    throws IOException
  {
    JsonDeserializer<Object> deser;
    if (typeId == null)
    {
      JsonDeserializer<Object> deser = _findDefaultImplDeserializer(ctxt);
      if (deser == null) {
        throw ctxt.mappingException("No (native) type id found when one was expected for polymorphic type handling");
      }
    }
    else
    {
      String typeIdStr = (typeId instanceof String) ? (String)typeId : String.valueOf(typeId);
      deser = _findDeserializer(ctxt, typeIdStr);
    }
    return deser.deserialize(jp, ctxt);
  }
  
  protected JsonDeserializer<Object> _handleUnknownTypeId(DeserializationContext ctxt, String typeId, TypeIdResolver idResolver, JavaType baseType)
    throws IOException
  {
    String extraDesc;
    if ((idResolver instanceof TypeIdResolverBase))
    {
      String extraDesc = ((TypeIdResolverBase)idResolver).getDescForKnownTypeIds();
      if (extraDesc == null) {
        extraDesc = "known type ids are not statically known";
      } else {
        extraDesc = "known type ids = " + extraDesc;
      }
    }
    else
    {
      extraDesc = null;
    }
    throw ctxt.unknownTypeException(_baseType, typeId, extraDesc);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */