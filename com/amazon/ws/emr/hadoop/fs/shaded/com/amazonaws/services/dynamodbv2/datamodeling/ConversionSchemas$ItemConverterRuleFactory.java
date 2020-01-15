package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

class ConversionSchemas$ItemConverterRuleFactory<V>
  implements StandardModelFactories.RuleFactory<V>
{
  private final StandardModelFactories.RuleFactory<V> typeConverters;
  private final ItemConverter converter;
  private final boolean customSchema;
  
  ConversionSchemas$ItemConverterRuleFactory(DynamoDBMapperConfig config, S3Link.Factory s3Links, StandardModelFactories.RuleFactory<V> typeConverters)
  {
    ConversionSchema.Dependencies depends = new ConversionSchema.Dependencies().with(S3ClientCache.class, s3Links.getS3ClientCache());
    ConversionSchema schema = config.getConversionSchema();
    
    customSchema = ((schema != ConversionSchemas.V1) && (schema != ConversionSchemas.V2_COMPATIBLE) && (schema != ConversionSchemas.V2));
    converter = schema.getConverter(depends);
    this.typeConverters = typeConverters;
  }
  
  public StandardModelFactories.Rule<V> getRule(ConvertibleType<V> type)
  {
    if ((customSchema) && (type.typeConverter() == null)) {
      return new ItemConverterRule(type, null);
    }
    return typeConverters.getRule(type);
  }
  
  private final class ItemConverterRule<V>
    implements StandardModelFactories.Rule<V>, DynamoDBTypeConverter<AttributeValue, V>
  {
    private final ConvertibleType<V> type;
    
    private ItemConverterRule()
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
        return converter.getFieldModel(type.getter()).attributeType();
      }
      catch (DynamoDBMappingException localDynamoDBMappingException) {}
      return DynamoDBMapperFieldModel.DynamoDBAttributeType.NULL;
    }
    
    public AttributeValue convert(V object)
    {
      return converter.convert(type.getter(), object);
    }
    
    public V unconvert(AttributeValue object)
    {
      return (V)converter.unconvert(type.getter(), type.setter(), object);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.ItemConverterRuleFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */