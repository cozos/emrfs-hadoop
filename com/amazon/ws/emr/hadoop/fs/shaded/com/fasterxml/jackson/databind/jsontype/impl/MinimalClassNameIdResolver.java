package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;

public class MinimalClassNameIdResolver
  extends ClassNameIdResolver
{
  protected final String _basePackageName;
  protected final String _basePackagePrefix;
  
  protected MinimalClassNameIdResolver(JavaType baseType, TypeFactory typeFactory)
  {
    super(baseType, typeFactory);
    String base = baseType.getRawClass().getName();
    int ix = base.lastIndexOf('.');
    if (ix < 0)
    {
      _basePackageName = "";
      _basePackagePrefix = ".";
    }
    else
    {
      _basePackagePrefix = base.substring(0, ix + 1);
      _basePackageName = base.substring(0, ix);
    }
  }
  
  public JsonTypeInfo.Id getMechanism()
  {
    return JsonTypeInfo.Id.MINIMAL_CLASS;
  }
  
  public String idFromValue(Object value)
  {
    String n = value.getClass().getName();
    if (n.startsWith(_basePackagePrefix)) {
      return n.substring(_basePackagePrefix.length() - 1);
    }
    return n;
  }
  
  protected JavaType _typeFromId(String id, TypeFactory typeFactory)
  {
    if (id.startsWith("."))
    {
      StringBuilder sb = new StringBuilder(id.length() + _basePackageName.length());
      if (_basePackageName.length() == 0) {
        sb.append(id.substring(1));
      } else {
        sb.append(_basePackageName).append(id);
      }
      id = sb.toString();
    }
    return super._typeFromId(id, typeFactory);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */