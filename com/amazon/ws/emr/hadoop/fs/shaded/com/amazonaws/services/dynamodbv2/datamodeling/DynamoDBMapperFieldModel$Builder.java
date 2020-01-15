package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

class DynamoDBMapperFieldModel$Builder<T, V>
{
  private final DynamoDBMapperFieldModel.Properties<V> properties;
  private DynamoDBTypeConverter<AttributeValue, V> converter;
  private DynamoDBMapperFieldModel.Reflect<T, V> reflect;
  private DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
  private Class<T> targetType;
  
  public DynamoDBMapperFieldModel$Builder(Class<T> targetType, DynamoDBMapperFieldModel.Properties<V> properties)
  {
    this.properties = properties;
    this.targetType = targetType;
  }
  
  public final Builder<T, V> with(DynamoDBTypeConverter<AttributeValue, V> converter)
  {
    this.converter = converter;
    return this;
  }
  
  public final Builder<T, V> with(DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType)
  {
    this.attributeType = attributeType;
    return this;
  }
  
  public final Builder<T, V> with(DynamoDBMapperFieldModel.Reflect<T, V> reflect)
  {
    this.reflect = reflect;
    return this;
  }
  
  public final DynamoDBMapperFieldModel<T, V> build()
  {
    DynamoDBMapperFieldModel<T, V> result = new DynamoDBMapperFieldModel(this, null);
    if (((result.keyType() != null) || (result.indexed())) && (!result.attributeType().name().matches("[BNS]"))) {
      throw new DynamoDBMappingException(String.format("%s[%s]; only scalar (B, N, or S) type allowed for key", new Object[] {targetType
      
        .getSimpleName(), result.name() }));
    }
    if ((result.keyType() != null) && (result.getGenerateStrategy() == DynamoDBAutoGenerateStrategy.ALWAYS)) {
      throw new DynamoDBMappingException(String.format("%s[%s]; auto-generated key and ALWAYS not allowed", new Object[] {targetType
      
        .getSimpleName(), result.name() }));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */