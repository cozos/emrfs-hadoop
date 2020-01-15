package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.Date;

final class StandardTypeConverters$ToDateTime$1
  extends StandardTypeConverters.ToDateTime<Date>
{
  StandardTypeConverters$ToDateTime$1()
  {
    super(null);
  }
  
  public final DateTime convert(Date o)
  {
    return new DateTime(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToDateTime.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */