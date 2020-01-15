package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.Deserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ArrayType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ClassKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleDeserializers
  implements Deserializers, Serializable
{
  private static final long serialVersionUID = -3006673354353448880L;
  protected HashMap<ClassKey, JsonDeserializer<?>> _classMappings = null;
  protected boolean _hasEnumDeserializer = false;
  
  public SimpleDeserializers() {}
  
  public SimpleDeserializers(Map<Class<?>, JsonDeserializer<?>> desers)
  {
    addDeserializers(desers);
  }
  
  public <T> void addDeserializer(Class<T> forClass, JsonDeserializer<? extends T> deser)
  {
    ClassKey key = new ClassKey(forClass);
    if (_classMappings == null) {
      _classMappings = new HashMap();
    }
    _classMappings.put(key, deser);
    if (forClass == Enum.class) {
      _hasEnumDeserializer = true;
    }
  }
  
  public void addDeserializers(Map<Class<?>, JsonDeserializer<?>> desers)
  {
    for (Map.Entry<Class<?>, JsonDeserializer<?>> entry : desers.entrySet())
    {
      Class<?> cls = (Class)entry.getKey();
      
      JsonDeserializer<Object> deser = (JsonDeserializer)entry.getValue();
      addDeserializer(cls, deser);
    }
  }
  
  public JsonDeserializer<?> findArrayDeserializer(ArrayType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return _classMappings == null ? null : (JsonDeserializer)_classMappings.get(new ClassKey(type.getRawClass()));
  }
  
  public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc)
    throws JsonMappingException
  {
    return _classMappings == null ? null : (JsonDeserializer)_classMappings.get(new ClassKey(type.getRawClass()));
  }
  
  public JsonDeserializer<?> findCollectionDeserializer(CollectionType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return _classMappings == null ? null : (JsonDeserializer)_classMappings.get(new ClassKey(type.getRawClass()));
  }
  
  public JsonDeserializer<?> findCollectionLikeDeserializer(CollectionLikeType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return _classMappings == null ? null : (JsonDeserializer)_classMappings.get(new ClassKey(type.getRawClass()));
  }
  
  public JsonDeserializer<?> findEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc)
    throws JsonMappingException
  {
    if (_classMappings == null) {
      return null;
    }
    JsonDeserializer<?> deser = (JsonDeserializer)_classMappings.get(new ClassKey(type));
    if ((deser == null) && 
      (_hasEnumDeserializer) && (type.isEnum())) {
      deser = (JsonDeserializer)_classMappings.get(new ClassKey(Enum.class));
    }
    return deser;
  }
  
  public JsonDeserializer<?> findMapDeserializer(MapType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return _classMappings == null ? null : (JsonDeserializer)_classMappings.get(new ClassKey(type.getRawClass()));
  }
  
  public JsonDeserializer<?> findMapLikeDeserializer(MapLikeType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return _classMappings == null ? null : (JsonDeserializer)_classMappings.get(new ClassKey(type.getRawClass()));
  }
  
  public JsonDeserializer<?> findTreeNodeDeserializer(Class<? extends JsonNode> nodeType, DeserializationConfig config, BeanDescription beanDesc)
    throws JsonMappingException
  {
    return _classMappings == null ? null : (JsonDeserializer)_classMappings.get(new ClassKey(nodeType));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module.SimpleDeserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */