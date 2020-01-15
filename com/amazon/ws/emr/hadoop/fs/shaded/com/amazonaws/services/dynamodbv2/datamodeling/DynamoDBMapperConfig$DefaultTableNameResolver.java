package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public class DynamoDBMapperConfig$DefaultTableNameResolver
  implements DynamoDBMapperConfig.TableNameResolver
{
  public static final DefaultTableNameResolver INSTANCE = new DefaultTableNameResolver();
  
  public String getTableName(Class<?> clazz, DynamoDBMapperConfig config)
  {
    DynamoDBMapperConfig.TableNameOverride override = config.getTableNameOverride();
    if (override != null)
    {
      String tableName = override.getTableName();
      if (tableName != null) {
        return tableName;
      }
    }
    StandardBeanProperties.Beans<?> beans = StandardBeanProperties.of(clazz);
    if (beans.properties().tableName() == null) {
      throw new DynamoDBMappingException(clazz + " not annotated with @DynamoDBTable");
    }
    String prefix = override == null ? null : override.getTableNamePrefix();
    return prefix + beans.properties().tableName();
  }
  
  private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withTableNameResolver(this).build();
  
  public final DynamoDBMapperConfig config()
  {
    return config;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.DefaultTableNameResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */