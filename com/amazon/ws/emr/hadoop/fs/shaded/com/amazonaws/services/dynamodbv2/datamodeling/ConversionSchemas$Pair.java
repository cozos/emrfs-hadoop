package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

class ConversionSchemas$Pair<T>
{
  public final Class<?> key;
  public final T value;
  
  public static Pair<ArgumentMarshaller> of(Class<?> key, ArgumentMarshaller value)
  {
    return new Pair(key, value);
  }
  
  public static Pair<ArgumentUnmarshaller> of(Class<?> key, ArgumentUnmarshaller value)
  {
    return new Pair(key, value);
  }
  
  private ConversionSchemas$Pair(Class<?> key, T value)
  {
    this.key = key;
    this.value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.Pair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */