package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ArrayType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class DeserializerCache
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new ConcurrentHashMap(64, 0.75F, 4);
  protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap(8);
  
  Object writeReplace()
  {
    _incompleteDeserializers.clear();
    
    return this;
  }
  
  public int cachedDeserializersCount()
  {
    return _cachedDeserializers.size();
  }
  
  public void flushCachedDeserializers()
  {
    _cachedDeserializers.clear();
  }
  
  public JsonDeserializer<Object> findValueDeserializer(DeserializationContext ctxt, DeserializerFactory factory, JavaType propertyType)
    throws JsonMappingException
  {
    JsonDeserializer<Object> deser = _findCachedDeserializer(propertyType);
    if (deser == null)
    {
      deser = _createAndCacheValueDeserializer(ctxt, factory, propertyType);
      if (deser == null) {
        deser = _handleUnknownValueDeserializer(propertyType);
      }
    }
    return deser;
  }
  
  public KeyDeserializer findKeyDeserializer(DeserializationContext ctxt, DeserializerFactory factory, JavaType type)
    throws JsonMappingException
  {
    KeyDeserializer kd = factory.createKeyDeserializer(ctxt, type);
    if (kd == null) {
      return _handleUnknownKeyDeserializer(type);
    }
    if ((kd instanceof ResolvableDeserializer)) {
      ((ResolvableDeserializer)kd).resolve(ctxt);
    }
    return kd;
  }
  
  public boolean hasValueDeserializerFor(DeserializationContext ctxt, DeserializerFactory factory, JavaType type)
    throws JsonMappingException
  {
    JsonDeserializer<Object> deser = _findCachedDeserializer(type);
    if (deser == null) {
      deser = _createAndCacheValueDeserializer(ctxt, factory, type);
    }
    return deser != null;
  }
  
  protected JsonDeserializer<Object> _findCachedDeserializer(JavaType type)
  {
    if (type == null) {
      throw new IllegalArgumentException("Null JavaType passed");
    }
    if (_hasCustomValueHandler(type)) {
      return null;
    }
    return (JsonDeserializer)_cachedDeserializers.get(type);
  }
  
  protected JsonDeserializer<Object> _createAndCacheValueDeserializer(DeserializationContext ctxt, DeserializerFactory factory, JavaType type)
    throws JsonMappingException
  {
    synchronized (_incompleteDeserializers)
    {
      JsonDeserializer<Object> deser = _findCachedDeserializer(type);
      if (deser != null) {
        return deser;
      }
      int count = _incompleteDeserializers.size();
      if (count > 0)
      {
        deser = (JsonDeserializer)_incompleteDeserializers.get(type);
        if (deser != null) {
          return deser;
        }
      }
      try
      {
        JsonDeserializer localJsonDeserializer = _createAndCache2(ctxt, factory, type);
        if ((count == 0) && (_incompleteDeserializers.size() > 0)) {
          _incompleteDeserializers.clear();
        }
        return localJsonDeserializer;
      }
      finally
      {
        if ((count == 0) && (_incompleteDeserializers.size() > 0)) {
          _incompleteDeserializers.clear();
        }
      }
    }
  }
  
  protected JsonDeserializer<Object> _createAndCache2(DeserializationContext ctxt, DeserializerFactory factory, JavaType type)
    throws JsonMappingException
  {
    JsonDeserializer<Object> deser;
    try
    {
      deser = _createDeserializer(ctxt, factory, type);
    }
    catch (IllegalArgumentException iae)
    {
      throw new JsonMappingException(iae.getMessage(), null, iae);
    }
    if (deser == null) {
      return null;
    }
    boolean isResolvable = deser instanceof ResolvableDeserializer;
    
    boolean addToCache = (!_hasCustomValueHandler(type)) && (deser.isCachable());
    if (isResolvable)
    {
      _incompleteDeserializers.put(type, deser);
      ((ResolvableDeserializer)deser).resolve(ctxt);
      _incompleteDeserializers.remove(type);
    }
    if (addToCache) {
      _cachedDeserializers.put(type, deser);
    }
    return deser;
  }
  
  protected JsonDeserializer<Object> _createDeserializer(DeserializationContext ctxt, DeserializerFactory factory, JavaType type)
    throws JsonMappingException
  {
    DeserializationConfig config = ctxt.getConfig();
    if ((type.isAbstract()) || (type.isMapLikeType()) || (type.isCollectionLikeType())) {
      type = factory.mapAbstractType(config, type);
    }
    BeanDescription beanDesc = config.introspect(type);
    
    JsonDeserializer<Object> deser = findDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
    if (deser != null) {
      return deser;
    }
    JavaType newType = modifyTypeByAnnotation(ctxt, beanDesc.getClassInfo(), type);
    if (newType != type)
    {
      type = newType;
      beanDesc = config.introspect(newType);
    }
    Class<?> builder = beanDesc.findPOJOBuilder();
    if (builder != null) {
      return factory.createBuilderBasedDeserializer(ctxt, type, beanDesc, builder);
    }
    Converter<Object, Object> conv = beanDesc.findDeserializationConverter();
    if (conv == null) {
      return _createDeserializer2(ctxt, factory, type, beanDesc);
    }
    JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
    if (!delegateType.hasRawClass(type.getRawClass())) {
      beanDesc = config.introspect(delegateType);
    }
    return new StdDelegatingDeserializer(conv, delegateType, _createDeserializer2(ctxt, factory, delegateType, beanDesc));
  }
  
  protected JsonDeserializer<?> _createDeserializer2(DeserializationContext ctxt, DeserializerFactory factory, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    DeserializationConfig config = ctxt.getConfig();
    if (type.isEnumType()) {
      return factory.createEnumDeserializer(ctxt, type, beanDesc);
    }
    if (type.isContainerType())
    {
      if (type.isArrayType()) {
        return factory.createArrayDeserializer(ctxt, (ArrayType)type, beanDesc);
      }
      if (type.isMapLikeType())
      {
        MapLikeType mlt = (MapLikeType)type;
        if (mlt.isTrueMapType()) {
          return factory.createMapDeserializer(ctxt, (MapType)mlt, beanDesc);
        }
        return factory.createMapLikeDeserializer(ctxt, mlt, beanDesc);
      }
      if (type.isCollectionLikeType())
      {
        JsonFormat.Value format = beanDesc.findExpectedFormat(null);
        if ((format == null) || (format.getShape() != JsonFormat.Shape.OBJECT))
        {
          CollectionLikeType clt = (CollectionLikeType)type;
          if (clt.isTrueCollectionType()) {
            return factory.createCollectionDeserializer(ctxt, (CollectionType)clt, beanDesc);
          }
          return factory.createCollectionLikeDeserializer(ctxt, clt, beanDesc);
        }
      }
    }
    if (JsonNode.class.isAssignableFrom(type.getRawClass())) {
      return factory.createTreeDeserializer(config, type, beanDesc);
    }
    return factory.createBeanDeserializer(ctxt, type, beanDesc);
  }
  
  protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann)
    throws JsonMappingException
  {
    Object deserDef = ctxt.getAnnotationIntrospector().findDeserializer(ann);
    if (deserDef == null) {
      return null;
    }
    JsonDeserializer<Object> deser = ctxt.deserializerInstance(ann, deserDef);
    
    return findConvertingDeserializer(ctxt, ann, deser);
  }
  
  protected JsonDeserializer<Object> findConvertingDeserializer(DeserializationContext ctxt, Annotated a, JsonDeserializer<Object> deser)
    throws JsonMappingException
  {
    Converter<Object, Object> conv = findConverter(ctxt, a);
    if (conv == null) {
      return deser;
    }
    JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
    return new StdDelegatingDeserializer(conv, delegateType, deser);
  }
  
  protected Converter<Object, Object> findConverter(DeserializationContext ctxt, Annotated a)
    throws JsonMappingException
  {
    Object convDef = ctxt.getAnnotationIntrospector().findDeserializationConverter(a);
    if (convDef == null) {
      return null;
    }
    return ctxt.converterInstance(a, convDef);
  }
  
  private JavaType modifyTypeByAnnotation(DeserializationContext ctxt, Annotated a, JavaType type)
    throws JsonMappingException
  {
    AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
    Class<?> subclass = intr.findDeserializationType(a, type);
    if (subclass != null) {
      try
      {
        type = ctxt.getTypeFactory().constructSpecializedType(type, subclass);
      }
      catch (IllegalArgumentException iae)
      {
        throw new JsonMappingException("Failed to narrow type " + type + " with concrete-type annotation (value " + subclass.getName() + "), method '" + a.getName() + "': " + iae.getMessage(), null, iae);
      }
    }
    if (type.isContainerType())
    {
      Class<?> keyClass = intr.findDeserializationKeyType(a, type.getKeyType());
      if (keyClass != null)
      {
        if (!(type instanceof MapLikeType)) {
          throw new JsonMappingException("Illegal key-type annotation: type " + type + " is not a Map(-like) type");
        }
        try
        {
          type = ((MapLikeType)type).narrowKey(keyClass);
        }
        catch (IllegalArgumentException iae)
        {
          throw new JsonMappingException("Failed to narrow key type " + type + " with key-type annotation (" + keyClass.getName() + "): " + iae.getMessage(), null, iae);
        }
      }
      JavaType keyType = type.getKeyType();
      if ((keyType != null) && (keyType.getValueHandler() == null))
      {
        Object kdDef = intr.findKeyDeserializer(a);
        if (kdDef != null)
        {
          KeyDeserializer kd = ctxt.keyDeserializerInstance(a, kdDef);
          if (kd != null)
          {
            type = ((MapLikeType)type).withKeyValueHandler(kd);
            keyType = type.getKeyType();
          }
        }
      }
      Class<?> cc = intr.findDeserializationContentType(a, type.getContentType());
      if (cc != null) {
        try
        {
          type = type.narrowContentsBy(cc);
        }
        catch (IllegalArgumentException iae)
        {
          throw new JsonMappingException("Failed to narrow content type " + type + " with content-type annotation (" + cc.getName() + "): " + iae.getMessage(), null, iae);
        }
      }
      JavaType contentType = type.getContentType();
      if (contentType.getValueHandler() == null)
      {
        Object cdDef = intr.findContentDeserializer(a);
        if (cdDef != null)
        {
          JsonDeserializer<?> cd = null;
          if ((cdDef instanceof JsonDeserializer))
          {
            cdDef = (JsonDeserializer)cdDef;
          }
          else
          {
            Class<?> cdClass = _verifyAsClass(cdDef, "findContentDeserializer", JsonDeserializer.None.class);
            if (cdClass != null) {
              cd = ctxt.deserializerInstance(a, cdClass);
            }
          }
          if (cd != null) {
            type = type.withContentValueHandler(cd);
          }
        }
      }
    }
    return type;
  }
  
  private boolean _hasCustomValueHandler(JavaType t)
  {
    if (t.isContainerType())
    {
      JavaType ct = t.getContentType();
      if (ct != null) {
        return (ct.getValueHandler() != null) || (ct.getTypeHandler() != null);
      }
    }
    return false;
  }
  
  private Class<?> _verifyAsClass(Object src, String methodName, Class<?> noneClass)
  {
    if (src == null) {
      return null;
    }
    if (!(src instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector." + methodName + "() returned value of type " + src.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
    }
    Class<?> cls = (Class)src;
    if ((cls == noneClass) || (ClassUtil.isBogusClass(cls))) {
      return null;
    }
    return cls;
  }
  
  protected JsonDeserializer<Object> _handleUnknownValueDeserializer(JavaType type)
    throws JsonMappingException
  {
    Class<?> rawClass = type.getRawClass();
    if (!ClassUtil.isConcrete(rawClass)) {
      throw new JsonMappingException("Can not find a Value deserializer for abstract type " + type);
    }
    throw new JsonMappingException("Can not find a Value deserializer for type " + type);
  }
  
  protected KeyDeserializer _handleUnknownKeyDeserializer(JavaType type)
    throws JsonMappingException
  {
    throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializerCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */