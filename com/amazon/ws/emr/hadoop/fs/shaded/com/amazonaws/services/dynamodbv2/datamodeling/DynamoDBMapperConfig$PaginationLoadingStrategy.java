package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public enum DynamoDBMapperConfig$PaginationLoadingStrategy
{
  LAZY_LOADING,  ITERATION_ONLY,  EAGER_LOADING;
  
  private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withPaginationLoadingStrategy(this).build();
  
  private DynamoDBMapperConfig$PaginationLoadingStrategy() {}
  
  public final DynamoDBMapperConfig config()
  {
    return config;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.PaginationLoadingStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */