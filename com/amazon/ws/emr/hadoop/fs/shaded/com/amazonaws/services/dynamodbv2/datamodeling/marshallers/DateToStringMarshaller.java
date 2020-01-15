package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.Date;

public class DateToStringMarshaller
  implements ArgumentMarshaller.StringAttributeMarshaller
{
  private static final DateToStringMarshaller INSTANCE = new DateToStringMarshaller();
  
  public static DateToStringMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    return new AttributeValue().withS(
      DateUtils.formatISO8601Date((Date)obj));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.DateToStringMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */