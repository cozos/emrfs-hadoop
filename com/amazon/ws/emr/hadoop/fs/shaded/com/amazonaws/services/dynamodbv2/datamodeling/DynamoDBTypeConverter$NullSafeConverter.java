package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public class DynamoDBTypeConverter$NullSafeConverter<S, T>
  extends DynamoDBTypeConverter.DelegateConverter<S, T>
{
  public DynamoDBTypeConverter$NullSafeConverter(DynamoDBTypeConverter<S, T> delegate)
  {
    super(delegate);
  }
  
  public S convert(T object)
  {
    return object == null ? null : super.convert(object);
  }
  
  public T unconvert(S object)
  {
    return object == null ? null : super.unconvert(object);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter.NullSafeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */