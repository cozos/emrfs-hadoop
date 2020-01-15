package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnumResolver
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Class<Enum<?>> _enumClass;
  protected final Enum<?>[] _enums;
  protected final HashMap<String, Enum<?>> _enumsById;
  
  protected EnumResolver(Class<Enum<?>> enumClass, Enum<?>[] enums, HashMap<String, Enum<?>> map)
  {
    _enumClass = enumClass;
    _enums = enums;
    _enumsById = map;
  }
  
  public static EnumResolver constructFor(Class<Enum<?>> enumCls, AnnotationIntrospector ai)
  {
    Enum<?>[] enumValues = (Enum[])enumCls.getEnumConstants();
    if (enumValues == null) {
      throw new IllegalArgumentException("No enum constants for class " + enumCls.getName());
    }
    HashMap<String, Enum<?>> map = new HashMap();
    for (Enum<?> e : enumValues) {
      map.put(ai.findEnumValue(e), e);
    }
    return new EnumResolver(enumCls, enumValues, map);
  }
  
  public static EnumResolver constructUsingToString(Class<Enum<?>> enumCls)
  {
    Enum<?>[] enumValues = (Enum[])enumCls.getEnumConstants();
    HashMap<String, Enum<?>> map = new HashMap();
    
    int i = enumValues.length;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      Enum<?> e = enumValues[i];
      map.put(e.toString(), e);
    }
    return new EnumResolver(enumCls, enumValues, map);
  }
  
  public static EnumResolver constructUsingMethod(Class<Enum<?>> enumCls, Method accessor)
  {
    Enum<?>[] enumValues = (Enum[])enumCls.getEnumConstants();
    HashMap<String, Enum<?>> map = new HashMap();
    
    int i = enumValues.length;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      Enum<?> en = enumValues[i];
      try
      {
        Object o = accessor.invoke(en, new Object[0]);
        if (o != null) {
          map.put(o.toString(), en);
        }
      }
      catch (Exception e)
      {
        throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + en + ": " + e.getMessage());
      }
    }
    return new EnumResolver(enumCls, enumValues, map);
  }
  
  public static EnumResolver constructUnsafe(Class<?> rawEnumCls, AnnotationIntrospector ai)
  {
    Class<Enum<?>> enumCls = rawEnumCls;
    return constructFor(enumCls, ai);
  }
  
  public static EnumResolver constructUnsafeUsingToString(Class<?> rawEnumCls)
  {
    Class<Enum<?>> enumCls = rawEnumCls;
    return constructUsingToString(enumCls);
  }
  
  public static EnumResolver constructUnsafeUsingMethod(Class<?> rawEnumCls, Method accessor)
  {
    Class<Enum<?>> enumCls = rawEnumCls;
    return constructUsingMethod(enumCls, accessor);
  }
  
  public CompactStringObjectMap constructLookup()
  {
    return CompactStringObjectMap.construct(_enumsById);
  }
  
  public Enum<?> findEnum(String key)
  {
    return (Enum)_enumsById.get(key);
  }
  
  public Enum<?> getEnum(int index)
  {
    if ((index < 0) || (index >= _enums.length)) {
      return null;
    }
    return _enums[index];
  }
  
  public Enum<?>[] getRawEnums()
  {
    return _enums;
  }
  
  public List<Enum<?>> getEnums()
  {
    ArrayList<Enum<?>> enums = new ArrayList(_enums.length);
    for (Enum<?> e : _enums) {
      enums.add(e);
    }
    return enums;
  }
  
  public Class<Enum<?>> getEnumClass()
  {
    return _enumClass;
  }
  
  public int lastValidIndex()
  {
    return _enums.length - 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EnumResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */