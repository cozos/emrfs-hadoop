package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class DynamoDBVersioned$Generator$Sequences$2
  implements DynamoDBVersioned.Generator.Sequence<Byte>
{
  public final Byte init()
  {
    return Byte.valueOf();
  }
  
  public final Byte next(Byte o)
  {
    return Byte.valueOf((byte)((o.byteValue() + 1) % 127));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersioned.Generator.Sequences.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */