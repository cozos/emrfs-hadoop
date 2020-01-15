package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;

final class StandardBeanProperties$MethodReflect<T, V>
  implements DynamoDBMapperFieldModel.Reflect<T, V>
{
  private final Method getter;
  private final Method setter;
  
  private StandardBeanProperties$MethodReflect(Method getter)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardBeanProperties.MethodReflect
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */