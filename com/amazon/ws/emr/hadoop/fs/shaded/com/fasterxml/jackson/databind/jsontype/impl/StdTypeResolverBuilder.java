package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.Collection;

public class StdTypeResolverBuilder
  implements TypeResolverBuilder<StdTypeResolverBuilder>
{
  protected JsonTypeInfo.Id _idType;
  protected JsonTypeInfo.As _includeAs;
  protected String _typeProperty;
  protected boolean _typeIdVisible = false;
  protected Class<?> _defaultImpl;
  protected TypeIdResolver _customIdResolver;
  
  public static StdTypeResolverBuilder noTypeInfoBuilder()
  {
    return new StdTypeResolverBuilder().init(JsonTypeInfo.Id.NONE, null);
  }
  
  public StdTypeResolverBuilder init(JsonTypeInfo.Id idType, TypeIdResolver idRes)
  {
    if (idType == null) {
      throw new IllegalArgumentException("idType can not be null");
    }
    _idType = idType;
    _customIdResolver = idRes;
    
    _typeProperty = idType.getDefaultPropertyName();
    return this;
  }
  
  public TypeSerializer buildTypeSerializer(SerializationConfig config, JavaType baseType, Collection<NamedType> subtypes)
  {
    if (_idType == JsonTypeInfo.Id.NONE) {
      return null;
    }
    TypeIdResolver idRes = idResolver(config, baseType, subtypes, true, false);
    switch (_includeAs)
    {
    case WRAPPER_ARRAY: 
      return new AsArrayTypeSerializer(idRes, null);
    case PROPERTY: 
      return new AsPropertyTypeSerializer(idRes, null, _typeProperty);
    case WRAPPER_OBJECT: 
      return new AsWrapperTypeSerializer(idRes, null);
    case EXTERNAL_PROPERTY: 
      return new AsExternalTypeSerializer(idRes, null, _typeProperty);
    case EXISTING_PROPERTY: 
      return new AsExistingPropertyTypeSerializer(idRes, null, _typeProperty);
    }
    throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + _includeAs);
  }
  
  public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes)
  {
    if (_idType == JsonTypeInfo.Id.NONE) {
      return null;
    }
    TypeIdResolver idRes = idResolver(config, baseType, subtypes, false, true);
    switch (_includeAs)
    {
    case WRAPPER_ARRAY: 
      return new AsArrayTypeDeserializer(baseType, idRes, _typeProperty, _typeIdVisible, _defaultImpl);
    case PROPERTY: 
    case EXISTING_PROPERTY: 
      return new AsPropertyTypeDeserializer(baseType, idRes, _typeProperty, _typeIdVisible, _defaultImpl, _includeAs);
    case WRAPPER_OBJECT: 
      return new AsWrapperTypeDeserializer(baseType, idRes, _typeProperty, _typeIdVisible, _defaultImpl);
    case EXTERNAL_PROPERTY: 
      return new AsExternalTypeDeserializer(baseType, idRes, _typeProperty, _typeIdVisible, _defaultImpl);
    }
    throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + _includeAs);
  }
  
  public StdTypeResolverBuilder inclusion(JsonTypeInfo.As includeAs)
  {
    if (includeAs == null) {
      throw new IllegalArgumentException("includeAs can not be null");
    }
    _includeAs = includeAs;
    return this;
  }
  
  public StdTypeResolverBuilder typeProperty(String typeIdPropName)
  {
    if ((typeIdPropName == null) || (typeIdPropName.length() == 0)) {
      typeIdPropName = _idType.getDefaultPropertyName();
    }
    _typeProperty = typeIdPropName;
    return this;
  }
  
  public StdTypeResolverBuilder defaultImpl(Class<?> defaultImpl)
  {
    _defaultImpl = defaultImpl;
    return this;
  }
  
  public StdTypeResolverBuilder typeIdVisibility(boolean isVisible)
  {
    _typeIdVisible = isVisible;
    return this;
  }
  
  public Class<?> getDefaultImpl()
  {
    return _defaultImpl;
  }
  
  public String getTypeProperty()
  {
    return _typeProperty;
  }
  
  public boolean isTypeIdVisible()
  {
    return _typeIdVisible;
  }
  
  protected TypeIdResolver idResolver(MapperConfig<?> config, JavaType baseType, Collection<NamedType> subtypes, boolean forSer, boolean forDeser)
  {
    if (_customIdResolver != null) {
      return _customIdResolver;
    }
    if (_idType == null) {
      throw new IllegalStateException("Can not build, 'init()' not yet called");
    }
    switch (_idType)
    {
    case CLASS: 
      return new ClassNameIdResolver(baseType, config.getTypeFactory());
    case MINIMAL_CLASS: 
      return new MinimalClassNameIdResolver(baseType, config.getTypeFactory());
    case NAME: 
      return TypeNameIdResolver.construct(config, baseType, subtypes, forSer, forDeser);
    case NONE: 
      return null;
    }
    throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + _idType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */