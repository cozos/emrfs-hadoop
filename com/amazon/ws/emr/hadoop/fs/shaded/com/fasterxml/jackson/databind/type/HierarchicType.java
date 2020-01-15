package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class HierarchicType
{
  protected final Type _actualType;
  protected final Class<?> _rawClass;
  protected final ParameterizedType _genericType;
  protected HierarchicType _superType;
  protected HierarchicType _subType;
  
  public HierarchicType(Type type)
  {
    _actualType = type;
    if ((type instanceof Class))
    {
      _rawClass = ((Class)type);
      _genericType = null;
    }
    else if ((type instanceof ParameterizedType))
    {
      _genericType = ((ParameterizedType)type);
      _rawClass = ((Class)_genericType.getRawType());
    }
    else
    {
      throw new IllegalArgumentException("Type " + type.getClass().getName() + " can not be used to construct HierarchicType");
    }
  }
  
  private HierarchicType(Type actualType, Class<?> rawClass, ParameterizedType genericType, HierarchicType superType, HierarchicType subType)
  {
    _actualType = actualType;
    _rawClass = rawClass;
    _genericType = genericType;
    _superType = superType;
    _subType = subType;
  }
  
  public HierarchicType deepCloneWithoutSubtype()
  {
    HierarchicType sup = _superType == null ? null : _superType.deepCloneWithoutSubtype();
    HierarchicType result = new HierarchicType(_actualType, _rawClass, _genericType, sup, null);
    if (sup != null) {
      sup.setSubType(result);
    }
    return result;
  }
  
  public void setSuperType(HierarchicType sup)
  {
    _superType = sup;
  }
  
  public final HierarchicType getSuperType()
  {
    return _superType;
  }
  
  public void setSubType(HierarchicType sub)
  {
    _subType = sub;
  }
  
  public final HierarchicType getSubType()
  {
    return _subType;
  }
  
  public final boolean isGeneric()
  {
    return _genericType != null;
  }
  
  public final ParameterizedType asGeneric()
  {
    return _genericType;
  }
  
  public final Class<?> getRawClass()
  {
    return _rawClass;
  }
  
  public String toString()
  {
    if (_genericType != null) {
      return _genericType.toString();
    }
    return _rawClass.getName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.HierarchicType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */