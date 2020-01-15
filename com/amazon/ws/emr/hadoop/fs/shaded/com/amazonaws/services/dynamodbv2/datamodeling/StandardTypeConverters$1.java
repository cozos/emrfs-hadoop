package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

class StandardTypeConverters$1
  implements DynamoDBTypeConverter<S, T>
{
  StandardTypeConverters$1(StandardTypeConverters this$0, StandardTypeConverters.Converter paramConverter1, StandardTypeConverters.Converter paramConverter2) {}
  
  public final S convert(T o)
  {
    return (S)val$toSource.convert(o);
  }
  
  public final T unconvert(S o)
  {
    return (T)val$toTarget.convert(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */