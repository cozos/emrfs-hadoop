package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.Date;

final class StandardTypeConverters$ToDate$2
  extends StandardTypeConverters.ToDate<DateTime>
{
  StandardTypeConverters$ToDate$2()
  {
    super(null);
  }
  
  public final Date convert(DateTime o)
  {
    return o.toDate();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToDate.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */