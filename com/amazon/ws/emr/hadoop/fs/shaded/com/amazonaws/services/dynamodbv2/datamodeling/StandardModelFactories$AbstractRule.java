package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

abstract class StandardModelFactories$AbstractRule<S, T>
  extends DynamoDBTypeConverter.AbstractConverter<AttributeValue, S>
  implements DynamoDBMapperFieldModel.Reflect<AttributeValue, S>, StandardModelFactories.Rule<T>
{
  protected final DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
  protected final boolean supported;
  
  protected StandardModelFactories$AbstractRule(DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType, boolean supported)
  {
    this.attributeType = attributeType;
    this.supported = supported;
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return type.attributeType() == attributeType ? true : type.attributeType() == null ? supported : false;
  }
  
  public DynamoDBMapperFieldModel.DynamoDBAttributeType getAttributeType()
  {
    return attributeType;
  }
  
  public AttributeValue convert(S o)
  {
    AttributeValue value = new AttributeValue();
    set(value, o);
    return value;
  }
  
  public S unconvert(AttributeValue o)
  {
    S value = get(o);
    if ((value == null) && (o.isNULL() == null)) {
      throw new DynamoDBMappingException("expected " + attributeType + " in value " + o);
    }
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.AbstractRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */