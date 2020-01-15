package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class DynamoDBVersioned$Generator$Sequences$3
  implements DynamoDBVersioned.Generator.Sequence<Integer>
{
  public final Integer init()
  {
    return Integer.valueOf(1);
  }
  
  public final Integer next(Integer o)
  {
    return Integer.valueOf(o.intValue() + 1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersioned.Generator.Sequences.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */