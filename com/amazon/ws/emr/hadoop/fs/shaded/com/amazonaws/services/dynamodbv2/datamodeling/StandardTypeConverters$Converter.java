package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

abstract class StandardTypeConverters$Converter<S, T>
{
  final <U> Converter<S, U> join(final Converter<T, U> target)
  {
    final Converter<S, T> source = this;
    new Converter()
    {
      public S convert(U o)
      {
        return (S)source.convert(target.convert(o));
      }
    };
  }
  
  public abstract S convert(T paramT);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */