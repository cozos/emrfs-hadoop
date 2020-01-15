package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;

final class StandardBeanProperties$DeclaringReflect<T, V>
  implements DynamoDBMapperFieldModel.Reflect<T, V>
{
  private final DynamoDBMapperFieldModel.Reflect<T, V> reflect;
  private final DynamoDBMapperFieldModel.Reflect<T, T> declaring;
  private final Class<T> targetType;
  
  private StandardBeanProperties$DeclaringReflect(Method getter, DynamoDBMapperFieldModel.Reflect<T, T> declaring, Class<T> targetType)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardBeanProperties.DeclaringReflect
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */