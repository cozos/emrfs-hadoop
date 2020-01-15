package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public class DynamoDBTypeConverterFactory$DelegateFactory
  extends DynamoDBTypeConverterFactory
{
  private final DynamoDBTypeConverterFactory delegate;
  
  public DynamoDBTypeConverterFactory$DelegateFactory(DynamoDBTypeConverterFactory delegate)
  {
    this.delegate = delegate;
  }
  
  public <S, T> DynamoDBTypeConverter<S, T> getConverter(Class<S> sourceType, Class<T> targetType)
  {
    return delegate.getConverter(sourceType, targetType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory.DelegateFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */