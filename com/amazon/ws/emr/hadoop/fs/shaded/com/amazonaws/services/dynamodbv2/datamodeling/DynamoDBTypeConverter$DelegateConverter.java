package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public class DynamoDBTypeConverter$DelegateConverter<S, T>
  extends DynamoDBTypeConverter.AbstractConverter<S, T>
{
  private final DynamoDBTypeConverter<S, T> delegate;
  
  public DynamoDBTypeConverter$DelegateConverter(DynamoDBTypeConverter<S, T> delegate)
  {
    this.delegate = delegate;
  }
  
  public S convert(T object)
  {
    return (S)delegate.convert(object);
  }
  
  public T unconvert(S object)
  {
    return (T)delegate.unconvert(object);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter.DelegateConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */