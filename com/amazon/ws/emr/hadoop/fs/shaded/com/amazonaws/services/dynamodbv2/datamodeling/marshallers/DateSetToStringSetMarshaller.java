package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringSetAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class DateSetToStringSetMarshaller
  implements ArgumentMarshaller.StringSetAttributeMarshaller
{
  private static final DateSetToStringSetMarshaller INSTANCE = new DateSetToStringSetMarshaller();
  
  public static DateSetToStringSetMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Set<Date> dates = (Set)obj;
    
    List<String> timestamps = new ArrayList(dates.size());
    for (Date date : dates) {
      timestamps.add(DateUtils.formatISO8601Date(date));
    }
    return new AttributeValue().withSS(timestamps);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.DateSetToStringSetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */