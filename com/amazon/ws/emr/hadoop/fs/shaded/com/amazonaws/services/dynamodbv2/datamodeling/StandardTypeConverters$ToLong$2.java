package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class StandardTypeConverters$ToLong$2
  extends StandardTypeConverters.ToLong<Number>
{
  StandardTypeConverters$ToLong$2()
  {
    super(null);
  }
  
  public final Long convert(Number o)
  {
    return Long.valueOf(o.longValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToLong.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */