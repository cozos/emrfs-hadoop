package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class StandardTypeConverters$ToFloat$1
  extends StandardTypeConverters.ToFloat<Number>
{
  StandardTypeConverters$ToFloat$1()
  {
    super(null);
  }
  
  public final Float convert(Number o)
  {
    return Float.valueOf(o.floatValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToFloat.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */