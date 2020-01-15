package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.UUID;

public final class DynamoDBGeneratedUuid$Generator<T>
  extends DynamoDBAutoGenerator.AbstractGenerator<T>
{
  private final DynamoDBTypeConverter<T, UUID> converter;
  
  public DynamoDBGeneratedUuid$Generator(Class<T> targetType, DynamoDBGeneratedUuid annotation)
  {
    super(annotation.value());
    converter = StandardTypeConverters.factory().getConverter(targetType, UUID.class);
  }
  
  public final T generate(T currentValue)
  {
    return (T)converter.convert(UUID.randomUUID());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBGeneratedUuid.Generator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */