package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Date;

final class StandardTypeConverters$ToDate$3
  extends StandardTypeConverters.ToDate<Long>
{
  StandardTypeConverters$ToDate$3()
  {
    super(null);
  }
  
  public final Date convert(Long o)
  {
    return new Date(o.longValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToDate.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */