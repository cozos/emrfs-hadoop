package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class DynamoDBVersioned$Generator$Sequences$5
  implements DynamoDBVersioned.Generator.Sequence<Short>
{
  public final Short init()
  {
    return Short.valueOf();
  }
  
  public final Short next(Short o)
  {
    return Short.valueOf((short)(o.shortValue() + 1));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersioned.Generator.Sequences.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */