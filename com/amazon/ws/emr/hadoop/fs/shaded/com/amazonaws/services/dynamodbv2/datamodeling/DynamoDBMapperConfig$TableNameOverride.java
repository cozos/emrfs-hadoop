package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public final class DynamoDBMapperConfig$TableNameOverride
{
  private final String tableNameOverride;
  private final String tableNamePrefix;
  
  public static TableNameOverride withTableNamePrefix(String tableNamePrefix)
  {
    return new TableNameOverride(null, tableNamePrefix);
  }
  
  public static TableNameOverride withTableNameReplacement(String tableNameReplacement)
  {
    return new TableNameOverride(tableNameReplacement, null);
  }
  
  private DynamoDBMapperConfig$TableNameOverride(String tableNameOverride, String tableNamePrefix)
  {
    this.tableNameOverride = tableNameOverride;
    this.tableNamePrefix = tableNamePrefix;
  }
  
  public DynamoDBMapperConfig$TableNameOverride(String tableNameOverride)
  {
    this(tableNameOverride, null);
  }
  
  public String getTableName()
  {
    return tableNameOverride;
  }
  
  public String getTableNamePrefix()
  {
    return tableNamePrefix;
  }
  
  private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withTableNameOverride(this).build();
  
  public final DynamoDBMapperConfig config()
  {
    return config;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.TableNameOverride
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */