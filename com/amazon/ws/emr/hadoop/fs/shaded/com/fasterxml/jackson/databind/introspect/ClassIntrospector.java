package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;

public abstract class ClassIntrospector
{
  public abstract BeanDescription forSerialization(SerializationConfig paramSerializationConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forDeserialization(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forDeserializationWithBuilder(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forCreation(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forClassAnnotations(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forDirectClassAnnotations(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public static abstract interface MixInResolver
  {
    public abstract Class<?> findMixInClassFor(Class<?> paramClass);
    
    public abstract MixInResolver copy();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ClassIntrospector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */