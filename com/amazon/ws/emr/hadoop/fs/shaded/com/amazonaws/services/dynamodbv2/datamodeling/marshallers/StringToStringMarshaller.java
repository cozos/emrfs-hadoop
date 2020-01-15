package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class StringToStringMarshaller
  implements ArgumentMarshaller.StringAttributeMarshaller
{
  private static final StringToStringMarshaller INSTANCE = new StringToStringMarshaller();
  
  public static StringToStringMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    String string = (String)obj;
    if (string.length() == 0) {
      return null;
    }
    return new AttributeValue().withS(string);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.StringToStringMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */