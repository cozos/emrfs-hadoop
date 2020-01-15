package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StdKeyDeserializers
  implements KeyDeserializers, Serializable
{
  private static final long serialVersionUID = 1L;
  
  public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumResolver)
  {
    return new StdKeyDeserializer.EnumKD(enumResolver, null);
  }
  
  public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumResolver, AnnotatedMethod factory)
  {
    return new StdKeyDeserializer.EnumKD(enumResolver, factory);
  }
  
  public static KeyDeserializer constructDelegatingKeyDeserializer(DeserializationConfig config, JavaType type, JsonDeserializer<?> deser)
  {
    return new StdKeyDeserializer.DelegatingKD(type.getRawClass(), deser);
  }
  
  public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig config, JavaType type)
  {
    BeanDescription beanDesc = config.introspect(type);
    
    Constructor<?> ctor = beanDesc.findSingleArgConstructor(new Class[] { String.class });
    if (ctor != null)
    {
      if (config.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(ctor);
      }
      return new StdKeyDeserializer.StringCtorKeyDeserializer(ctor);
    }
    Method m = beanDesc.findFactoryMethod(new Class[] { String.class });
    if (m != null)
    {
      if (config.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(m);
      }
      return new StdKeyDeserializer.StringFactoryKeyDeserializer(m);
    }
    return null;
  }
  
  public KeyDeserializer findKeyDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc)
    throws JsonMappingException
  {
    Class<?> raw = type.getRawClass();
    if (raw.isPrimitive()) {
      raw = ClassUtil.wrapperType(raw);
    }
    return StdKeyDeserializer.forType(raw);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */