package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ClassKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class SimpleAbstractTypeResolver
  extends AbstractTypeResolver
  implements Serializable
{
  private static final long serialVersionUID = 8635483102371490919L;
  protected final HashMap<ClassKey, Class<?>> _mappings = new HashMap();
  
  public <T> SimpleAbstractTypeResolver addMapping(Class<T> superType, Class<? extends T> subType)
  {
    if (superType == subType) {
      throw new IllegalArgumentException("Can not add mapping from class to itself");
    }
    if (!superType.isAssignableFrom(subType)) {
      throw new IllegalArgumentException("Can not add mapping from class " + superType.getName() + " to " + subType.getName() + ", as latter is not a subtype of former");
    }
    if (!Modifier.isAbstract(superType.getModifiers())) {
      throw new IllegalArgumentException("Can not add mapping from class " + superType.getName() + " since it is not abstract");
    }
    _mappings.put(new ClassKey(superType), subType);
    return this;
  }
  
  public JavaType findTypeMapping(DeserializationConfig config, JavaType type)
  {
    Class<?> src = type.getRawClass();
    Class<?> dst = (Class)_mappings.get(new ClassKey(src));
    if (dst == null) {
      return null;
    }
    return config.getTypeFactory().constructSpecializedType(type, dst);
  }
  
  public JavaType resolveAbstractType(DeserializationConfig config, JavaType type)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */