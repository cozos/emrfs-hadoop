package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public enum DynamoDBMapperConfig$SaveBehavior
{
  UPDATE,  UPDATE_SKIP_NULL_ATTRIBUTES,  CLOBBER,  PUT,  APPEND_SET;
  
  private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withSaveBehavior(this).build();
  
  private DynamoDBMapperConfig$SaveBehavior() {}
  
  public final DynamoDBMapperConfig config()
  {
    return config;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.SaveBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */