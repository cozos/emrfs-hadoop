package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.math.BigInteger;

final class DynamoDBVersioned$Generator$Sequences$1
  implements DynamoDBVersioned.Generator.Sequence<BigInteger>
{
  public final BigInteger init()
  {
    return BigInteger.ONE;
  }
  
  public final BigInteger next(BigInteger o)
  {
    return o.add(BigInteger.ONE);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersioned.Generator.Sequences.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */