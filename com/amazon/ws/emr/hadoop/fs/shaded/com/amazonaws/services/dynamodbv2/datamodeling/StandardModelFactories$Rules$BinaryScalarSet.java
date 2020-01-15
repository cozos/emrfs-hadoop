package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

class StandardModelFactories$Rules$BinaryScalarSet
  extends StandardModelFactories.AbstractRule<List<ByteBuffer>, Collection<T>>
{
  private StandardModelFactories$Rules$BinaryScalarSet(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.BS, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.B, StandardTypeConverters.Vector.SET)));
  }
  
  public DynamoDBTypeConverter<AttributeValue, Collection<T>> newConverter(ConvertibleType<Collection<T>> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.SET.join(StandardModelFactories.Rules.access$2400(this$0, ByteBuffer.class, type.param(0))), type.typeConverter() });
  }
  
  public List<ByteBuffer> get(AttributeValue value)
  {
    return value.getBS();
  }
  
  public void set(AttributeValue value, List<ByteBuffer> o)
  {
    value.setBS(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.BinaryScalarSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */