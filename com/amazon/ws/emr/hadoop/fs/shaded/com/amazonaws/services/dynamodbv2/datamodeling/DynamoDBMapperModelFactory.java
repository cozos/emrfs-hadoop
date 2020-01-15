package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract interface DynamoDBMapperModelFactory
{
  public abstract TableFactory getTableFactory(DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public static abstract interface TableFactory
  {
    public abstract <T> DynamoDBMapperTableModel<T> getTable(Class<T> paramClass);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperModelFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */