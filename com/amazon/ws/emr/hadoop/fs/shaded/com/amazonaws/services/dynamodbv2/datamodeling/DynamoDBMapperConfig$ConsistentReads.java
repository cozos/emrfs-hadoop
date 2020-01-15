package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public enum DynamoDBMapperConfig$ConsistentReads
{
  CONSISTENT,  EVENTUAL;
  
  private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withConsistentReads(this).build();
  
  private DynamoDBMapperConfig$ConsistentReads() {}
  
  public final DynamoDBMapperConfig config()
  {
    return config;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.ConsistentReads
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */