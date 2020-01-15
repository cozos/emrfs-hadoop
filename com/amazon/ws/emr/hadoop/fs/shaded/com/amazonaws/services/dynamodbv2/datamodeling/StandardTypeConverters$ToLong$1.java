package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Date;

final class StandardTypeConverters$ToLong$1
  extends StandardTypeConverters.ToLong<Date>
{
  StandardTypeConverters$ToLong$1()
  {
    super(null);
  }
  
  public final Long convert(Date o)
  {
    return Long.valueOf(o.getTime());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToLong.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */