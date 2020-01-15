package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

class StandardTypeConverters$Converter$1
  extends StandardTypeConverters.Converter<S, U>
{
  StandardTypeConverters$Converter$1(StandardTypeConverters.Converter this$0, StandardTypeConverters.Converter paramConverter1, StandardTypeConverters.Converter paramConverter2) {}
  
  public S convert(U o)
  {
    return (S)val$source.convert(val$target.convert(o));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Converter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */