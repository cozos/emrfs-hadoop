package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract class DynamoDBAutoGenerator$AbstractGenerator<T>
  implements DynamoDBAutoGenerator<T>
{
  private final DynamoDBAutoGenerateStrategy strategy;
  
  protected DynamoDBAutoGenerator$AbstractGenerator(DynamoDBAutoGenerateStrategy strategy)
  {
    this.strategy = strategy;
  }
  
  public DynamoDBAutoGenerateStrategy getGenerateStrategy()
  {
    return strategy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerator.AbstractGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */