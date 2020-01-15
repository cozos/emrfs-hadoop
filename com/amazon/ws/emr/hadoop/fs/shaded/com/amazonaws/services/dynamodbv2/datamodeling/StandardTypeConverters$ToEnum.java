package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

abstract class StandardTypeConverters$ToEnum<S extends Enum<S>, T>
  extends StandardTypeConverters.Converter<S, T>
{
  private static final class FromString<S extends Enum<S>>
    extends StandardTypeConverters.ToEnum<S, String>
  {
    private final Class<S> sourceType;
    
    private FromString(Class<S> sourceType)
    {
      super();
      this.sourceType = sourceType;
    }
    
    public final S convert(String o)
    {
      return Enum.valueOf(sourceType, o);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToEnum
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */