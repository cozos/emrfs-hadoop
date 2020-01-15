package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

class DynamoDBTypeConverterFactory$OverrideFactory
  extends DynamoDBTypeConverterFactory.DelegateFactory
{
  private final DynamoDBTypeConverterFactory.ConverterMap overrides;
  
  public DynamoDBTypeConverterFactory$OverrideFactory(DynamoDBTypeConverterFactory defaults, DynamoDBTypeConverterFactory.ConverterMap overrides)
  {
    super(defaults);
    this.overrides = overrides;
  }
  
  public <S, T> DynamoDBTypeConverter<S, T> getConverter(Class<S> sourceType, Class<T> targetType)
  {
    DynamoDBTypeConverter<S, T> converter = overrides.get(sourceType, targetType);
    if (converter == null) {
      converter = super.getConverter(sourceType, targetType);
    }
    return converter;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory.OverrideFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */