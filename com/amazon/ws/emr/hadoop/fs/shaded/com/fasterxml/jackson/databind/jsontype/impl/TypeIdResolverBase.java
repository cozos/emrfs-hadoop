package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DatabindContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;

public abstract class TypeIdResolverBase
  implements TypeIdResolver
{
  protected final TypeFactory _typeFactory;
  protected final JavaType _baseType;
  
  protected TypeIdResolverBase()
  {
    this(null, null);
  }
  
  protected TypeIdResolverBase(JavaType baseType, TypeFactory typeFactory)
  {
    _baseType = baseType;
    _typeFactory = typeFactory;
  }
  
  public void init(JavaType bt) {}
  
  public String idFromBaseType()
  {
    return idFromValueAndType(null, _baseType.getRawClass());
  }
  
  @Deprecated
  public JavaType typeFromId(String id)
  {
    return typeFromId(null, id);
  }
  
  public JavaType typeFromId(DatabindContext context, String id)
  {
    return typeFromId(id);
  }
  
  public String getDescForKnownTypeIds()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */