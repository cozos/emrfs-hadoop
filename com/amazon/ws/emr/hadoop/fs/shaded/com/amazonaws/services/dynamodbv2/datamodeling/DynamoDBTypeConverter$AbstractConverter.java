package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract class DynamoDBTypeConverter$AbstractConverter<S, T>
  implements DynamoDBTypeConverter<S, T>
{
  public static <S, U, T> DynamoDBTypeConverter.ExtendedConverter<S, U, T> join(DynamoDBTypeConverter<S, U> source, DynamoDBTypeConverter<U, T> target)
  {
    return new DynamoDBTypeConverter.ExtendedConverter(source, target);
  }
  
  public static <S, T> DynamoDBTypeConverter.NullSafeConverter<S, T> nullSafe(DynamoDBTypeConverter<S, T> converter)
  {
    return new DynamoDBTypeConverter.NullSafeConverter(converter);
  }
  
  public <U> DynamoDBTypeConverter<S, U> joinAll(DynamoDBTypeConverter<T, U>... targets)
  {
    AbstractConverter<S, U> converter = nullSafe();
    for (DynamoDBTypeConverter<T, U> target : targets) {
      if (target != null) {
        converter = converter.join(nullSafe(target));
      }
    }
    return converter;
  }
  
  public <U> DynamoDBTypeConverter.ExtendedConverter<S, T, U> join(DynamoDBTypeConverter<T, U> target)
  {
    return join(this, target);
  }
  
  public DynamoDBTypeConverter.NullSafeConverter<S, T> nullSafe()
  {
    return nullSafe(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter.AbstractConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */