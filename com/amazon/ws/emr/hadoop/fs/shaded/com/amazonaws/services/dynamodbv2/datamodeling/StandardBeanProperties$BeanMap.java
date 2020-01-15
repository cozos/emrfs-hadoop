package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

final class StandardBeanProperties$BeanMap<T, V>
  extends LinkedHashMap<String, StandardBeanProperties.Bean<T, V>>
{
  private final Class<T> clazz;
  
  StandardBeanProperties$BeanMap(Class<T> clazz, boolean inherited)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardBeanProperties.BeanMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */