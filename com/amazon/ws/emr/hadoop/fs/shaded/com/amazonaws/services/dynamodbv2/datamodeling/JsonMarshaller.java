package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectWriter;

@Deprecated
public class JsonMarshaller<T>
  implements DynamoDBMarshaller<T>
{
  private static final ObjectMapper mapper = new ObjectMapper();
  private static final ObjectWriter writer = mapper.writer();
  private final Class<T> valueType;
  
  public JsonMarshaller(Class<T> valueType)
  {
    this.valueType = valueType;
  }
  
  public JsonMarshaller()
  {
    this(null);
  }
  
  protected final Class<T> getValueType()
  {
    return valueType;
  }
  
  public String marshall(T obj)
  {
    try
    {
      return writer.writeValueAsString(obj);
    }
    catch (JsonProcessingException e)
    {
      throw Throwables.failure(e, "Unable to marshall the instance of " + obj
        .getClass() + "into a string");
    }
  }
  
  public T unmarshall(Class<T> clazz, String json)
  {
    try
    {
      return (T)mapper.readValue(json, getValueType() == null ? clazz : getValueType());
    }
    catch (Exception e)
    {
      throw Throwables.failure(e, "Unable to unmarshall the string " + json + "into " + clazz);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.JsonMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */