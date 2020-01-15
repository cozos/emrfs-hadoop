package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ArrayType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapType;

public class Deserializers$Base
  implements Deserializers
{
  public JsonDeserializer<?> findArrayDeserializer(ArrayType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonDeserializer<?> findCollectionDeserializer(CollectionType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonDeserializer<?> findCollectionLikeDeserializer(CollectionLikeType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonDeserializer<?> findMapDeserializer(MapType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonDeserializer<?> findMapLikeDeserializer(MapLikeType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonDeserializer<?> findEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonDeserializer<?> findTreeNodeDeserializer(Class<? extends JsonNode> nodeType, DeserializationConfig config, BeanDescription beanDesc)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc)
    throws JsonMappingException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.Deserializers.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */