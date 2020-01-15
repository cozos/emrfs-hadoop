package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class CustomUnmarshaller
  extends SUnmarshaller
{
  private final Class<?> targetClass;
  private final Class<? extends DynamoDBMarshaller<?>> unmarshallerClass;
  
  public CustomUnmarshaller(Class<?> targetClass, Class<? extends DynamoDBMarshaller<?>> unmarshallerClass)
  {
    this.targetClass = targetClass;
    this.unmarshallerClass = unmarshallerClass;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    DynamoDBMarshaller unmarshaller = createUnmarshaller(unmarshallerClass);
    
    return unmarshaller.unmarshall(targetClass, value.getS());
  }
  
  private static DynamoDBMarshaller createUnmarshaller(Class<?> clazz)
  {
    try
    {
      return (DynamoDBMarshaller)clazz.newInstance();
    }
    catch (InstantiationException e)
    {
      throw new DynamoDBMappingException("Failed to instantiate custom marshaler for class " + clazz, e);
    }
    catch (IllegalAccessException e)
    {
      throw new DynamoDBMappingException("Failed to instantiate custom marshaler for class " + clazz, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.CustomUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */