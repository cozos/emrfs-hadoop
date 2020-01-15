package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class StandardTypeConverters$ToEnum$FromString<S extends Enum<S>>
  extends StandardTypeConverters.ToEnum<S, String>
{
  private final Class<S> sourceType;
  
  private StandardTypeConverters$ToEnum$FromString(Class<S> sourceType)
  {
    super(null);
    this.sourceType = sourceType;
  }
  
  public final S convert(String o)
  {
    return Enum.valueOf(sourceType, o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToEnum.FromString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */