package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public class DynamoDBTypeConverter$ExtendedConverter<S, U, T>
  extends DynamoDBTypeConverter.AbstractConverter<S, T>
{
  private final DynamoDBTypeConverter<S, U> source;
  private final DynamoDBTypeConverter<U, T> target;
  
  public DynamoDBTypeConverter$ExtendedConverter(DynamoDBTypeConverter<S, U> source, DynamoDBTypeConverter<U, T> target)
  {
    this.source = source;
    this.target = target;
  }
  
  public S convert(T o)
  {
    return (S)source.convert(target.convert(o));
  }
  
  public T unconvert(S o)
  {
    return (T)target.unconvert(source.unconvert(o));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter.ExtendedConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */