package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.BooleanAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class BooleanToBooleanMarshaller
  implements ArgumentMarshaller.BooleanAttributeMarshaller
{
  private static final BooleanToBooleanMarshaller INSTANCE = new BooleanToBooleanMarshaller();
  
  public static BooleanToBooleanMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    return new AttributeValue().withBOOL((Boolean)obj);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.BooleanToBooleanMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */