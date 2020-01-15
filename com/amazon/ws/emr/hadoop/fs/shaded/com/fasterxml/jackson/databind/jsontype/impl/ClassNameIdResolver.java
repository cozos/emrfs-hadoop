package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DatabindContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.EnumMap;
import java.util.EnumSet;

public class ClassNameIdResolver
  extends TypeIdResolverBase
{
  public ClassNameIdResolver(JavaType baseType, TypeFactory typeFactory)
  {
    super(baseType, typeFactory);
  }
  
  public JsonTypeInfo.Id getMechanism()
  {
    return JsonTypeInfo.Id.CLASS;
  }
  
  public void registerSubtype(Class<?> type, String name) {}
  
  public String idFromValue(Object value)
  {
    return _idFrom(value, value.getClass());
  }
  
  public String idFromValueAndType(Object value, Class<?> type)
  {
    return _idFrom(value, type);
  }
  
  @Deprecated
  public JavaType typeFromId(String id)
  {
    return _typeFromId(id, _typeFactory);
  }
  
  public JavaType typeFromId(DatabindContext context, String id)
  {
    return _typeFromId(id, context.getTypeFactory());
  }
  
  protected JavaType _typeFromId(String id, TypeFactory typeFactory)
  {
    if (id.indexOf('<') > 0)
    {
      JavaType t = typeFactory.constructFromCanonical(id);
      
      return t;
    }
    try
    {
      Class<?> cls = typeFactory.findClass(id);
      return typeFactory.constructSpecializedType(_baseType, cls);
    }
    catch (ClassNotFoundException e)
    {
      throw new IllegalArgumentException("Invalid type id '" + id + "' (for id type 'Id.class'): no such class found");
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException("Invalid type id '" + id + "' (for id type 'Id.class'): " + e.getMessage(), e);
    }
  }
  
  protected final String _idFrom(Object value, Class<?> cls)
  {
    if ((Enum.class.isAssignableFrom(cls)) && 
      (!cls.isEnum())) {
      cls = cls.getSuperclass();
    }
    String str = cls.getName();
    if (str.startsWith("java.util"))
    {
      if ((value instanceof EnumSet))
      {
        Class<?> enumClass = ClassUtil.findEnumType((EnumSet)value);
        
        str = TypeFactory.defaultInstance().constructCollectionType(EnumSet.class, enumClass).toCanonical();
      }
      else if ((value instanceof EnumMap))
      {
        Class<?> enumClass = ClassUtil.findEnumType((EnumMap)value);
        Class<?> valueClass = Object.class;
        
        str = TypeFactory.defaultInstance().constructMapType(EnumMap.class, enumClass, valueClass).toCanonical();
      }
      else
      {
        String end = str.substring(9);
        if (((end.startsWith(".Arrays$")) || (end.startsWith(".Collections$"))) && (str.indexOf("List") >= 0)) {
          str = "java.util.ArrayList";
        }
      }
    }
    else if (str.indexOf('$') >= 0)
    {
      Class<?> outer = ClassUtil.getOuterClass(cls);
      if (outer != null)
      {
        Class<?> staticType = _baseType.getRawClass();
        if (ClassUtil.getOuterClass(staticType) == null)
        {
          cls = _baseType.getRawClass();
          str = cls.getName();
        }
      }
    }
    return str;
  }
  
  public String getDescForKnownTypeIds()
  {
    return "class name used as type id";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */