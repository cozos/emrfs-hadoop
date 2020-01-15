package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.SimpleObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.InjectableValues;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer.None;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public abstract class DefaultDeserializationContext
  extends DeserializationContext
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected transient LinkedHashMap<ObjectIdGenerator.IdKey, ReadableObjectId> _objectIds;
  private List<ObjectIdResolver> _objectIdResolvers;
  
  protected DefaultDeserializationContext(DeserializerFactory df, DeserializerCache cache)
  {
    super(df, cache);
  }
  
  protected DefaultDeserializationContext(DefaultDeserializationContext src, DeserializationConfig config, JsonParser jp, InjectableValues values)
  {
    super(src, config, jp, values);
  }
  
  protected DefaultDeserializationContext(DefaultDeserializationContext src, DeserializerFactory factory)
  {
    super(src, factory);
  }
  
  protected DefaultDeserializationContext(DefaultDeserializationContext src)
  {
    super(src);
  }
  
  public DefaultDeserializationContext copy()
  {
    throw new IllegalStateException("DefaultDeserializationContext sub-class not overriding copy()");
  }
  
  public ReadableObjectId findObjectId(Object id, ObjectIdGenerator<?> gen, ObjectIdResolver resolverType)
  {
    if (id == null) {
      return null;
    }
    ObjectIdGenerator.IdKey key = gen.key(id);
    if (_objectIds == null)
    {
      _objectIds = new LinkedHashMap();
    }
    else
    {
      ReadableObjectId entry = (ReadableObjectId)_objectIds.get(key);
      if (entry != null) {
        return entry;
      }
    }
    ObjectIdResolver resolver = null;
    if (_objectIdResolvers == null) {
      _objectIdResolvers = new ArrayList(8);
    } else {
      for (ObjectIdResolver res : _objectIdResolvers) {
        if (res.canUseFor(resolverType))
        {
          resolver = res;
          break;
        }
      }
    }
    if (resolver == null)
    {
      resolver = resolverType.newForDeserialization(this);
      _objectIdResolvers.add(resolver);
    }
    ReadableObjectId entry = new ReadableObjectId(key);
    entry.setResolver(resolver);
    _objectIds.put(key, entry);
    return entry;
  }
  
  @Deprecated
  public ReadableObjectId findObjectId(Object id, ObjectIdGenerator<?> gen)
  {
    return findObjectId(id, gen, new SimpleObjectIdResolver());
  }
  
  public void checkUnresolvedObjectId()
    throws UnresolvedForwardReference
  {
    if (_objectIds == null) {
      return;
    }
    if (!isEnabled(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS)) {
      return;
    }
    UnresolvedForwardReference exception = null;
    for (Map.Entry<ObjectIdGenerator.IdKey, ReadableObjectId> entry : _objectIds.entrySet())
    {
      ReadableObjectId roid = (ReadableObjectId)entry.getValue();
      if ((roid.hasReferringProperties()) && 
      
        (!tryToResolveUnresolvedObjectId(roid)))
      {
        if (exception == null) {
          exception = new UnresolvedForwardReference("Unresolved forward references for: ");
        }
        key = getKeykey;
        for (iterator = roid.referringProperties(); iterator.hasNext();)
        {
          ReadableObjectId.Referring referring = (ReadableObjectId.Referring)iterator.next();
          exception.addUnresolvedId(key, referring.getBeanType(), referring.getLocation());
        }
      }
    }
    Object key;
    Iterator<ReadableObjectId.Referring> iterator;
    if (exception != null) {
      throw exception;
    }
  }
  
  protected boolean tryToResolveUnresolvedObjectId(ReadableObjectId roid)
  {
    return roid.tryToResolveUnresolved(this);
  }
  
  public JsonDeserializer<Object> deserializerInstance(Annotated ann, Object deserDef)
    throws JsonMappingException
  {
    if (deserDef == null) {
      return null;
    }
    JsonDeserializer<?> deser;
    JsonDeserializer<?> deser;
    if ((deserDef instanceof JsonDeserializer))
    {
      deser = (JsonDeserializer)deserDef;
    }
    else
    {
      if (!(deserDef instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + deserDef.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
      }
      Class<?> deserClass = (Class)deserDef;
      if ((deserClass == JsonDeserializer.None.class) || (ClassUtil.isBogusClass(deserClass))) {
        return null;
      }
      if (!JsonDeserializer.class.isAssignableFrom(deserClass)) {
        throw new IllegalStateException("AnnotationIntrospector returned Class " + deserClass.getName() + "; expected Class<JsonDeserializer>");
      }
      HandlerInstantiator hi = _config.getHandlerInstantiator();
      deser = hi == null ? null : hi.deserializerInstance(_config, ann, deserClass);
      if (deser == null) {
        deser = (JsonDeserializer)ClassUtil.createInstance(deserClass, _config.canOverrideAccessModifiers());
      }
    }
    if ((deser instanceof ResolvableDeserializer)) {
      ((ResolvableDeserializer)deser).resolve(this);
    }
    return deser;
  }
  
  public final KeyDeserializer keyDeserializerInstance(Annotated ann, Object deserDef)
    throws JsonMappingException
  {
    if (deserDef == null) {
      return null;
    }
    KeyDeserializer deser;
    KeyDeserializer deser;
    if ((deserDef instanceof KeyDeserializer))
    {
      deser = (KeyDeserializer)deserDef;
    }
    else
    {
      if (!(deserDef instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + deserDef.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
      }
      Class<?> deserClass = (Class)deserDef;
      if ((deserClass == KeyDeserializer.None.class) || (ClassUtil.isBogusClass(deserClass))) {
        return null;
      }
      if (!KeyDeserializer.class.isAssignableFrom(deserClass)) {
        throw new IllegalStateException("AnnotationIntrospector returned Class " + deserClass.getName() + "; expected Class<KeyDeserializer>");
      }
      HandlerInstantiator hi = _config.getHandlerInstantiator();
      deser = hi == null ? null : hi.keyDeserializerInstance(_config, ann, deserClass);
      if (deser == null) {
        deser = (KeyDeserializer)ClassUtil.createInstance(deserClass, _config.canOverrideAccessModifiers());
      }
    }
    if ((deser instanceof ResolvableDeserializer)) {
      ((ResolvableDeserializer)deser).resolve(this);
    }
    return deser;
  }
  
  public abstract DefaultDeserializationContext with(DeserializerFactory paramDeserializerFactory);
  
  public abstract DefaultDeserializationContext createInstance(DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues);
  
  public static final class Impl
    extends DefaultDeserializationContext
  {
    private static final long serialVersionUID = 1L;
    
    public Impl(DeserializerFactory df)
    {
      super(null);
    }
    
    protected Impl(Impl src, DeserializationConfig config, JsonParser jp, InjectableValues values)
    {
      super(config, jp, values);
    }
    
    protected Impl(Impl src)
    {
      super();
    }
    
    protected Impl(Impl src, DeserializerFactory factory)
    {
      super(factory);
    }
    
    public DefaultDeserializationContext copy()
    {
      if (getClass() != Impl.class) {
        return super.copy();
      }
      return new Impl(this);
    }
    
    public DefaultDeserializationContext createInstance(DeserializationConfig config, JsonParser jp, InjectableValues values)
    {
      return new Impl(this, config, jp, values);
    }
    
    public DefaultDeserializationContext with(DeserializerFactory factory)
    {
      return new Impl(this, factory);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DefaultDeserializationContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */