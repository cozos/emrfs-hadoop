package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;

public final class DynamoDBTypeConvertedJson$Converter<T>
  implements DynamoDBTypeConverter<String, T>
{
  private static final ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
  private final Class<T> targetType;
  
  public DynamoDBTypeConvertedJson$Converter(Class<T> targetType, DynamoDBTypeConvertedJson annotation)
  {
    this.targetType = (annotation.targetType() == Void.TYPE ? targetType : annotation.targetType());
  }
  
  public final String convert(T object)
  {
    try
    {
      return mapper.writeValueAsString(object);
    }
    catch (Exception e)
    {
      throw new DynamoDBMappingException("Unable to write object to JSON", e);
    }
  }
  
  public final T unconvert(String object)
  {
    try
    {
      return (T)mapper.readValue(object, targetType);
    }
    catch (Exception e)
    {
      throw new DynamoDBMappingException("Unable to read JSON string", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */