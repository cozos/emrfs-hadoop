package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class StandardTypeConverters$ToString$1
  extends StandardTypeConverters.ToString<Boolean>
{
  StandardTypeConverters$ToString$1()
  {
    super(null);
  }
  
  public final String convert(Boolean o)
  {
    return Boolean.TRUE.equals(o) ? "1" : "0";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToString.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */