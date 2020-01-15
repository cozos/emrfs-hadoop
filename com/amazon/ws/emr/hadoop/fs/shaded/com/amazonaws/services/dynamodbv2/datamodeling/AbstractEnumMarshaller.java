package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Throwables;

@Deprecated
public abstract class AbstractEnumMarshaller<T extends Enum<T>>
  implements DynamoDBMarshaller<T>
{
  public String marshall(T obj)
  {
    try
    {
      return obj.name();
    }
    catch (RuntimeException e)
    {
      throw Throwables.failure(e, "Unable to marshall the instance of " + obj.getClass() + " into a string");
    }
  }
  
  public T unmarshall(Class<T> clazz, String obj)
  {
    try
    {
      return Enum.valueOf(clazz, obj);
    }
    catch (RuntimeException e)
    {
      throw Throwables.failure(e, "Unable to unmarshall the string " + obj + " into " + clazz);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.AbstractEnumMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */