package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

public abstract interface DynamoDBTypeConverter<S, T>
{
  public abstract S convert(T paramT);
  
  public abstract T unconvert(S paramS);
  
  @SdkInternalApi
  public static abstract class AbstractConverter<S, T>
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
  
  public static class ExtendedConverter<S, U, T>
    extends DynamoDBTypeConverter.AbstractConverter<S, T>
  {
    private final DynamoDBTypeConverter<S, U> source;
    private final DynamoDBTypeConverter<U, T> target;
    
    public ExtendedConverter(DynamoDBTypeConverter<S, U> source, DynamoDBTypeConverter<U, T> target)
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
  
  public static class DelegateConverter<S, T>
    extends DynamoDBTypeConverter.AbstractConverter<S, T>
  {
    private final DynamoDBTypeConverter<S, T> delegate;
    
    public DelegateConverter(DynamoDBTypeConverter<S, T> delegate)
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
  
  public static class NullSafeConverter<S, T>
    extends DynamoDBTypeConverter.DelegateConverter<S, T>
  {
    public NullSafeConverter(DynamoDBTypeConverter<S, T> delegate)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */