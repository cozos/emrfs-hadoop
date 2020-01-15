package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public final class DynamoDBMarshalling$Converter<T>
  implements DynamoDBTypeConverter<String, T>
{
  private final Class<DynamoDBMarshaller<T>> marshallerClass;
  private final Class<T> targetType;
  
  public DynamoDBMarshalling$Converter(Class<T> targetType, DynamoDBMarshalling annotation)
  {
    marshallerClass = annotation.marshallerClass();
    this.targetType = targetType;
  }
  
  public final String convert(T object)
  {
    return marshaller().marshall(object);
  }
  
  public final T unconvert(String object)
  {
    return (T)marshaller().unmarshall(targetType, object);
  }
  
  private DynamoDBMarshaller<T> marshaller()
  {
    try
    {
      return (DynamoDBMarshaller)marshallerClass.newInstance();
    }
    catch (Exception e)
    {
      throw new DynamoDBMappingException("Unable to instantiate marshaller " + marshallerClass, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */