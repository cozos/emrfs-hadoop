package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class CustomMarshaller
  implements ArgumentMarshaller.StringAttributeMarshaller
{
  private final Class<? extends DynamoDBMarshaller<?>> marshallerClass;
  
  public CustomMarshaller(Class<? extends DynamoDBMarshaller<?>> marshallerClass)
  {
    this.marshallerClass = marshallerClass;
  }
  
  public AttributeValue marshall(Object obj)
  {
    DynamoDBMarshaller<Object> marshaler = createMarshaller(marshallerClass);
    
    String stringValue = marshaler.marshall(obj);
    if (stringValue == null) {
      return null;
    }
    return new AttributeValue(stringValue);
  }
  
  private static DynamoDBMarshaller<Object> createMarshaller(Class<?> clazz)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CustomMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */