package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.Calendar;

public class CalendarToStringMarshaller
  implements ArgumentMarshaller.StringAttributeMarshaller
{
  private static final CalendarToStringMarshaller INSTANCE = new CalendarToStringMarshaller();
  
  public static CalendarToStringMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    return new AttributeValue().withS(
      DateUtils.formatISO8601Date(((Calendar)obj).getTime()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CalendarToStringMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */