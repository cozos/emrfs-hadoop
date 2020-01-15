package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.MapAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ItemConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

public class ObjectToMapMarshaller
  implements ArgumentMarshaller.MapAttributeMarshaller
{
  private static final ObjectToMapMarshaller INSTANCE = new ObjectToMapMarshaller();
  private final ItemConverter converter;
  
  public static ObjectToMapMarshaller instance()
  {
    return INSTANCE;
  }
  
  private ObjectToMapMarshaller()
  {
    converter = null;
  }
  
  public ObjectToMapMarshaller(ItemConverter converter)
  {
    if (converter == null) {
      throw new NullPointerException("converter");
    }
    this.converter = converter;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Map<String, AttributeValue> values = converter.convert(obj);
    return new AttributeValue().withM(values);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectToMapMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */