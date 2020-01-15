package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class DynamoDBVersioned$Generator$Sequences$4
  implements DynamoDBVersioned.Generator.Sequence<Long>
{
  public final Long init()
  {
    return Long.valueOf(1L);
  }
  
  public final Long next(Long o)
  {
    return Long.valueOf(o.longValue() + 1L);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersioned.Generator.Sequences.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */