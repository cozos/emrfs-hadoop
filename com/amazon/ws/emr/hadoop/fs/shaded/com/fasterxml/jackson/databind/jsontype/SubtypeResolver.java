package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.util.Collection;

public abstract class SubtypeResolver
{
  public abstract void registerSubtypes(NamedType... paramVarArgs);
  
  public abstract void registerSubtypes(Class<?>... paramVarArgs);
  
  public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> config, AnnotatedMember property, JavaType baseType)
  {
    return collectAndResolveSubtypes(property, config, config.getAnnotationIntrospector(), baseType);
  }
  
  public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> config, AnnotatedClass baseType)
  {
    return collectAndResolveSubtypes(baseType, config, config.getAnnotationIntrospector());
  }
  
  public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> config, AnnotatedMember property, JavaType baseType)
  {
    return collectAndResolveSubtypes(property, config, config.getAnnotationIntrospector(), baseType);
  }
  
  public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> config, AnnotatedClass baseType)
  {
    return collectAndResolveSubtypes(baseType, config, config.getAnnotationIntrospector());
  }
  
  @Deprecated
  public abstract Collection<NamedType> collectAndResolveSubtypes(AnnotatedMember paramAnnotatedMember, MapperConfig<?> paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector, JavaType paramJavaType);
  
  @Deprecated
  public abstract Collection<NamedType> collectAndResolveSubtypes(AnnotatedClass paramAnnotatedClass, MapperConfig<?> paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.SubtypeResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */