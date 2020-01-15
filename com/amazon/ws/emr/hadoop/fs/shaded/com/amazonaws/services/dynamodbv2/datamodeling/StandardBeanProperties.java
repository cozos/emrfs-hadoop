package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SdkInternalApi
final class StandardBeanProperties
{
  static final <T> Beans<T> of(Class<T> clazz)
  {
    return CachedBeans.CACHE.getBeans(clazz);
  }
  
  private static final class CachedBeans<T>
  {
    private static final CachedBeans<Object> CACHE = new CachedBeans();
    private final ConcurrentMap<Class<T>, StandardBeanProperties.Beans<T>> cache = new ConcurrentHashMap();
    
    private final StandardBeanProperties.Beans<T> getBeans(Class<T> clazz)
    {
      if (!cache.containsKey(clazz))
      {
        StandardAnnotationMaps.TableMap<T> annotations = StandardAnnotationMaps.of(clazz);
        StandardBeanProperties.BeanMap<T, Object> map = new StandardBeanProperties.BeanMap(clazz, false);
        cache.putIfAbsent(clazz, new StandardBeanProperties.Beans(annotations, map, null));
      }
      return (StandardBeanProperties.Beans)cache.get(clazz);
    }
  }
  
  static final class Beans<T>
  {
    private final DynamoDBMapperTableModel.Properties<T> properties;
    private final Map<String, StandardBeanProperties.Bean<T, Object>> map;
    
    private Beans(StandardAnnotationMaps.TableMap<T> annotations, Map<String, StandardBeanProperties.Bean<T, Object>> map)
    {
      properties = new DynamoDBMapperTableModel.Properties.Immutable(annotations);
      this.map = Collections.unmodifiableMap(map);
    }
    
    final DynamoDBMapperTableModel.Properties<T> properties()
    {
      return properties;
    }
    
    final Map<String, StandardBeanProperties.Bean<T, Object>> map()
    {
      return map;
    }
  }
  
  static final class Bean<T, V>
  {
    private final DynamoDBMapperFieldModel.Properties<V> properties;
    private final ConvertibleType<V> type;
    private final DynamoDBMapperFieldModel.Reflect<T, V> reflect;
    
    private Bean(StandardAnnotationMaps.FieldMap<V> annotations, DynamoDBMapperFieldModel.Reflect<T, V> reflect, Method getter)
    {
      properties = new DynamoDBMapperFieldModel.Properties.Immutable(annotations);
      type = ConvertibleType.of(getter, annotations);
      this.reflect = reflect;
    }
    
    final DynamoDBMapperFieldModel.Properties<V> properties()
    {
      return properties;
    }
    
    final ConvertibleType<V> type()
    {
      return type;
    }
    
    final DynamoDBMapperFieldModel.Reflect<T, V> reflect()
    {
      return reflect;
    }
  }
  
  static final class MethodReflect<T, V>
    implements DynamoDBMapperFieldModel.Reflect<T, V>
  {
    private final Method getter;
    private final Method setter;
    
    private MethodReflect(Method getter)
    {
      setter = setterOf(getter);
      this.getter = getter;
    }
    
    public V get(T object)
    {
      try
      {
        return (V)getter.invoke(object, new Object[0]);
      }
      catch (Exception e)
      {
        throw new DynamoDBMappingException("could not invoke " + getter + " on " + object.getClass(), e);
      }
    }
    
    public void set(T object, V value)
    {
      try
      {
        setter.invoke(object, new Object[] { value });
      }
      catch (Exception e)
      {
        throw new DynamoDBMappingException("could not invoke " + setter + " on " + object.getClass() + " with value " + value + " of type " + (value == null ? null : value.getClass()), e);
      }
    }
    
    static Method setterOf(Method getter)
    {
      try
      {
        String name = "set" + getter.getName().replaceFirst("^(get|is)", "");
        return getter.getDeclaringClass().getMethod(name, new Class[] { getter.getReturnType() });
      }
      catch (Exception localException) {}
      return null;
    }
  }
  
  static final class DeclaringReflect<T, V>
    implements DynamoDBMapperFieldModel.Reflect<T, V>
  {
    private final DynamoDBMapperFieldModel.Reflect<T, V> reflect;
    private final DynamoDBMapperFieldModel.Reflect<T, T> declaring;
    private final Class<T> targetType;
    
    private DeclaringReflect(Method getter, DynamoDBMapperFieldModel.Reflect<T, T> declaring, Class<T> targetType)
    {
      reflect = new StandardBeanProperties.MethodReflect(getter, null);
      this.declaring = declaring;
      this.targetType = targetType;
    }
    
    public V get(T object)
    {
      T declaringObject = declaring.get(object);
      if (declaringObject == null) {
        return null;
      }
      return (V)reflect.get(declaringObject);
    }
    
    public void set(T object, V value)
    {
      T declaringObject = declaring.get(object);
      if (declaringObject == null) {
        declaring.set(object, declaringObject = newInstance(targetType));
      }
      reflect.set(declaringObject, value);
    }
    
    static <T> T newInstance(Class<T> targetType)
    {
      try
      {
        return (T)targetType.newInstance();
      }
      catch (Exception e)
      {
        throw new DynamoDBMappingException("could not instantiate " + targetType, e);
      }
    }
  }
  
  static final class BeanMap<T, V>
    extends LinkedHashMap<String, StandardBeanProperties.Bean<T, V>>
  {
    private final Class<T> clazz;
    
    BeanMap(Class<T> clazz, boolean inherited)
    {
      this.clazz = clazz;
      putAll(clazz, inherited);
    }
    
    private void putAll(Class<T> clazz, boolean inherited)
    {
      for (Method method : clazz.getMethods()) {
        if (canMap(method, inherited))
        {
          StandardAnnotationMaps.FieldMap<V> annotations = StandardAnnotationMaps.of(method, null);
          if (!annotations.ignored())
          {
            DynamoDBMapperFieldModel.Reflect<T, V> reflect = new StandardBeanProperties.MethodReflect(method, null);
            putOrFlatten(annotations, reflect, method);
          }
        }
      }
    }
    
    private void putOrFlatten(StandardAnnotationMaps.FieldMap<V> annotations, DynamoDBMapperFieldModel.Reflect<T, V> reflect, Method getter)
    {
      if (annotations.flattened())
      {
        flatten(annotations.targetType(), annotations.attributes(), reflect);
      }
      else
      {
        StandardBeanProperties.Bean<T, V> bean = new StandardBeanProperties.Bean(annotations, reflect, getter, null);
        if (put(bean.properties().attributeName(), bean) != null) {
          throw new DynamoDBMappingException("duplicate attribute name " + bean.properties().attributeName());
        }
      }
    }
    
    private void flatten(Class<T> targetType, Map<String, String> attributes, DynamoDBMapperFieldModel.Reflect<T, T> declaring)
    {
      for (Method method : targetType.getMethods()) {
        if (canMap(method, true))
        {
          String name = StandardBeanProperties.fieldNameOf(method);
          if ((name = (String)attributes.remove(name)) != null)
          {
            StandardAnnotationMaps.FieldMap<V> annotations = StandardAnnotationMaps.of(method, name);
            if (!annotations.ignored())
            {
              DynamoDBMapperFieldModel.Reflect<T, V> reflect = new StandardBeanProperties.DeclaringReflect(method, declaring, targetType, null);
              putOrFlatten(annotations, reflect, method);
            }
          }
        }
      }
      if (!attributes.isEmpty()) {
        throw new DynamoDBMappingException("contains unknown flattened attribute(s): " + attributes);
      }
    }
    
    private boolean canMap(Method method, boolean inherited)
    {
      if (!method.getName().matches("^(get|is).+")) {
        return false;
      }
      if (method.getParameterTypes().length != 0) {
        return false;
      }
      if ((method.isBridge()) || (method.isSynthetic())) {
        return false;
      }
      if (method.getDeclaringClass() == Object.class) {
        return false;
      }
      if ((!inherited) && (method.getDeclaringClass() != clazz) && 
        (StandardAnnotationMaps.of(method.getDeclaringClass()).attributeType() == null)) {
        return false;
      }
      return true;
    }
  }
  
  static final String fieldNameOf(Method getter)
  {
    String name = getter.getName().replaceFirst("^(get|is)", "");
    return StringUtils.lowerCase(name.substring(0, 1)) + name.substring(1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardBeanProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */