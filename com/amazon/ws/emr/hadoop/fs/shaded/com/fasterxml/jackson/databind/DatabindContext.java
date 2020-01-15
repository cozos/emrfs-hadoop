package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;

public abstract class DatabindContext
{
  public abstract MapperConfig<?> getConfig();
  
  public abstract AnnotationIntrospector getAnnotationIntrospector();
  
  public final boolean isEnabled(MapperFeature feature)
  {
    return getConfig().isEnabled(feature);
  }
  
  public final boolean canOverrideAccessModifiers()
  {
    return getConfig().canOverrideAccessModifiers();
  }
  
  public abstract Class<?> getActiveView();
  
  public abstract Locale getLocale();
  
  public abstract TimeZone getTimeZone();
  
  public abstract Object getAttribute(Object paramObject);
  
  public abstract DatabindContext setAttribute(Object paramObject1, Object paramObject2);
  
  public JavaType constructType(Type type)
  {
    return getTypeFactory().constructType(type);
  }
  
  public JavaType constructSpecializedType(JavaType baseType, Class<?> subclass)
  {
    if (baseType.getRawClass() == subclass) {
      return baseType;
    }
    return getConfig().constructSpecializedType(baseType, subclass);
  }
  
  public abstract TypeFactory getTypeFactory();
  
  public ObjectIdGenerator<?> objectIdGeneratorInstance(Annotated annotated, ObjectIdInfo objectIdInfo)
    throws JsonMappingException
  {
    Class<?> implClass = objectIdInfo.getGeneratorType();
    MapperConfig<?> config = getConfig();
    HandlerInstantiator hi = config.getHandlerInstantiator();
    ObjectIdGenerator<?> gen = hi == null ? null : hi.objectIdGeneratorInstance(config, annotated, implClass);
    if (gen == null) {
      gen = (ObjectIdGenerator)ClassUtil.createInstance(implClass, config.canOverrideAccessModifiers());
    }
    return gen.forScope(objectIdInfo.getScope());
  }
  
  public ObjectIdResolver objectIdResolverInstance(Annotated annotated, ObjectIdInfo objectIdInfo)
  {
    Class<? extends ObjectIdResolver> implClass = objectIdInfo.getResolverType();
    MapperConfig<?> config = getConfig();
    HandlerInstantiator hi = config.getHandlerInstantiator();
    ObjectIdResolver resolver = hi == null ? null : hi.resolverIdGeneratorInstance(config, annotated, implClass);
    if (resolver == null) {
      resolver = (ObjectIdResolver)ClassUtil.createInstance(implClass, config.canOverrideAccessModifiers());
    }
    return resolver;
  }
  
  public Converter<Object, Object> converterInstance(Annotated annotated, Object converterDef)
    throws JsonMappingException
  {
    if (converterDef == null) {
      return null;
    }
    if ((converterDef instanceof Converter)) {
      return (Converter)converterDef;
    }
    if (!(converterDef instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + converterDef.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }
    Class<?> converterClass = (Class)converterDef;
    if ((converterClass == Converter.None.class) || (ClassUtil.isBogusClass(converterClass))) {
      return null;
    }
    if (!Converter.class.isAssignableFrom(converterClass)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + converterClass.getName() + "; expected Class<Converter>");
    }
    MapperConfig<?> config = getConfig();
    HandlerInstantiator hi = config.getHandlerInstantiator();
    Converter<?, ?> conv = hi == null ? null : hi.converterInstance(config, annotated, converterClass);
    if (conv == null) {
      conv = (Converter)ClassUtil.createInstance(converterClass, config.canOverrideAccessModifiers());
    }
    return conv;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DatabindContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */