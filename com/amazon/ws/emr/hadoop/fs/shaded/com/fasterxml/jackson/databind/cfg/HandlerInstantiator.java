package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;

public abstract class HandlerInstantiator
{
  public abstract JsonDeserializer<?> deserializerInstance(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public abstract KeyDeserializer keyDeserializerInstance(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public abstract JsonSerializer<?> serializerInstance(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public abstract TypeResolverBuilder<?> typeResolverBuilderInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public abstract TypeIdResolver typeIdResolverInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public ValueInstantiator valueInstantiatorInstance(MapperConfig<?> config, Annotated annotated, Class<?> resolverClass)
  {
    return null;
  }
  
  public ObjectIdGenerator<?> objectIdGeneratorInstance(MapperConfig<?> config, Annotated annotated, Class<?> implClass)
  {
    return null;
  }
  
  public ObjectIdResolver resolverIdGeneratorInstance(MapperConfig<?> config, Annotated annotated, Class<?> implClass)
  {
    return null;
  }
  
  public PropertyNamingStrategy namingStrategyInstance(MapperConfig<?> config, Annotated annotated, Class<?> implClass)
  {
    return null;
  }
  
  public Converter<?, ?> converterInstance(MapperConfig<?> config, Annotated annotated, Class<?> implClass)
  {
    return null;
  }
  
  public VirtualBeanPropertyWriter virtualPropertyWriterInstance(MapperConfig<?> config, Class<?> implClass)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.HandlerInstantiator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */