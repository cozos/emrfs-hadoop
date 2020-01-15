package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public final class DynamoDBTypeConverterFactory$Builder
{
  private final DynamoDBTypeConverterFactory.ConverterMap overrides = new DynamoDBTypeConverterFactory.ConverterMap(null);
  private final DynamoDBTypeConverterFactory defaults;
  
  private DynamoDBTypeConverterFactory$Builder(DynamoDBTypeConverterFactory defaults)
  {
    this.defaults = defaults;
  }
  
  public <S, T> Builder with(Class<S> sourceType, Class<T> targetType, DynamoDBTypeConverter<? extends S, ? extends T> converter)
  {
    if ((StandardTypeConverters.Vector.SET.is(sourceType)) || (StandardTypeConverters.Vector.LIST.is(sourceType)) || (StandardTypeConverters.Vector.MAP.is(sourceType))) {
      throw new DynamoDBMappingException("type [" + sourceType + "] is not supported; type-converter factory only supports scalar conversions");
    }
    overrides.put(sourceType, targetType, converter);
    return this;
  }
  
  public DynamoDBTypeConverterFactory build()
  {
    return new DynamoDBTypeConverterFactory.OverrideFactory(defaults, overrides);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */