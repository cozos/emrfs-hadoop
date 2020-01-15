package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public final class DynamoDBMapperTableModel$Properties$Immutable<T>
  implements DynamoDBMapperTableModel.Properties<T>
{
  private final String tableName;
  
  public DynamoDBMapperTableModel$Properties$Immutable(DynamoDBMapperTableModel.Properties<T> properties)
  {
    tableName = properties.tableName();
  }
  
  public String tableName()
  {
    return tableName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperTableModel.Properties.Immutable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */