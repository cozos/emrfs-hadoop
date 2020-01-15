package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.NumberAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class NumberToNumberMarshaller
  implements ArgumentMarshaller.NumberAttributeMarshaller
{
  private static final NumberToNumberMarshaller INSTANCE = new NumberToNumberMarshaller();
  
  public static NumberToNumberMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Number number = (Number)obj;
    return new AttributeValue().withN(number.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.NumberToNumberMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */