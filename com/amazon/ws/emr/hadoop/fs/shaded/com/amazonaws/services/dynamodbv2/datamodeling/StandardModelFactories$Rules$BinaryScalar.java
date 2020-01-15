package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import java.nio.ByteBuffer;

class StandardModelFactories$Rules$BinaryScalar
  extends StandardModelFactories.AbstractRule<ByteBuffer, T>
{
  private StandardModelFactories$Rules$BinaryScalar(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.B, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.B)));
  }
  
  public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.access$2400(this$0, ByteBuffer.class, type), type.typeConverter() });
  }
  
  public ByteBuffer get(AttributeValue value)
  {
    return value.getB();
  }
  
  public void set(AttributeValue value, ByteBuffer o)
  {
    value.setB(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.BinaryScalar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */