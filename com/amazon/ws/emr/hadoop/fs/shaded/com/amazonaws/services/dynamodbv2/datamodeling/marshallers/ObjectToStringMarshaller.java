package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class ObjectToStringMarshaller
  implements ArgumentMarshaller.StringAttributeMarshaller
{
  private static final ObjectToStringMarshaller INSTANCE = new ObjectToStringMarshaller();
  
  public static ObjectToStringMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    return new AttributeValue().withS(obj.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectToStringMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */