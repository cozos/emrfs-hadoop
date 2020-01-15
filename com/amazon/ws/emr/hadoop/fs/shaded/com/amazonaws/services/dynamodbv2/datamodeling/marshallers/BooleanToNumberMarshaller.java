package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.NumberAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class BooleanToNumberMarshaller
  implements ArgumentMarshaller.NumberAttributeMarshaller
{
  private static final BooleanToNumberMarshaller INSTANCE = new BooleanToNumberMarshaller();
  
  public static BooleanToNumberMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Boolean bool = (Boolean)obj;
    if ((bool == null) || (!bool.booleanValue())) {
      return new AttributeValue().withN("0");
    }
    return new AttributeValue().withN("1");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.BooleanToNumberMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */