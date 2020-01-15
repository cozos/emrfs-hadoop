package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

class ClassUtil$EnumTypeLocator
{
  static final EnumTypeLocator instance = new EnumTypeLocator();
  private final Field enumSetTypeField;
  private final Field enumMapTypeField;
  
  private ClassUtil$EnumTypeLocator()
  {
    enumSetTypeField = locateField(EnumSet.class, "elementType", Class.class);
    enumMapTypeField = locateField(EnumMap.class, "elementType", Class.class);
  }
  
  public Class<? extends Enum<?>> enumTypeFor(EnumSet<?> set)
  {
    if (enumSetTypeField != null) {
      return (Class)get(set, enumSetTypeField);
    }
    throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
  }
  
  public Class<? extends Enum<?>> enumTypeFor(EnumMap<?, ?> set)
  {
    if (enumMapTypeField != null) {
      return (Class)get(set, enumMapTypeField);
    }
    throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
  }
  
  private Object get(Object bean, Field field)
  {
    try
    {
      return field.get(bean);
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException(e);
    }
  }
  
  private static Field locateField(Class<?> fromClass, String expectedName, Class<?> type)
  {
    Field found = null;
    
    Field[] fields = fromClass.getDeclaredFields();
    for (Field f : fields) {
      if ((expectedName.equals(f.getName())) && (f.getType() == type))
      {
        found = f;
        break;
      }
    }
    if (found == null) {
      for (Field f : fields) {
        if (f.getType() == type)
        {
          if (found != null) {
            return null;
          }
          found = f;
        }
      }
    }
    if (found != null) {
      try
      {
        found.setAccessible(true);
      }
      catch (Throwable t) {}
    }
    return found;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil.EnumTypeLocator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */