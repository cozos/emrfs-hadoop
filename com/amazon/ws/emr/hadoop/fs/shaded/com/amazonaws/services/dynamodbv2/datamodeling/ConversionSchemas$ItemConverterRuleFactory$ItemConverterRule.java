package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

final class ConversionSchemas$ItemConverterRuleFactory$ItemConverterRule<V>
  implements StandardModelFactories.Rule<V>, DynamoDBTypeConverter<AttributeValue, V>
{
  private final ConvertibleType<V> type;
  
  private ConversionSchemas$ItemConverterRuleFactory$ItemConverterRule(ConvertibleType<V> arg1)
  {
    this.type = type;
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return true;
  }
  
  public DynamoDBTypeConverter<AttributeValue, V> newConverter(ConvertibleType<V> type)
  {
    return this;
  }
  
  public DynamoDBMapperFieldModel.DynamoDBAttributeType getAttributeType()
  {
    try
    {
      return ConversionSchemas.ItemConverterRuleFactory.access$2400(this$0).getFieldModel(type.getter()).attributeType();
    }
    catch (DynamoDBMappingException localDynamoDBMappingException) {}
    return DynamoDBMapperFieldModel.DynamoDBAttributeType.NULL;
  }
  
  public AttributeValue convert(V object)
  {
    return ConversionSchemas.ItemConverterRuleFactory.access$2400(this$0).convert(type.getter(), object);
  }
  
  public V unconvert(AttributeValue object)
  {
    return (V)ConversionSchemas.ItemConverterRuleFactory.access$2400(this$0).unconvert(type.getter(), type.setter(), object);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.ItemConverterRuleFactory.ItemConverterRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */