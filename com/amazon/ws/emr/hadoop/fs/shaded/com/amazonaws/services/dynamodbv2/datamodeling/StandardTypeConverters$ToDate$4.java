package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.Date;

final class StandardTypeConverters$ToDate$4
  extends StandardTypeConverters.ToDate<String>
{
  StandardTypeConverters$ToDate$4()
  {
    super(null);
  }
  
  public final Date convert(String o)
  {
    return DateUtils.parseISO8601Date(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToDate.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */