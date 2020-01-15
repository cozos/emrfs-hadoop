package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Deprecated
@DynamoDB
@DynamoDBTypeConverted(converter=Converter.class)
@DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
public @interface DynamoDBMarshalling
{
  Class<? extends DynamoDBMarshaller<? extends Object>> marshallerClass();
  
  public static final class Converter<T>
    implements DynamoDBTypeConverter<String, T>
  {
    private final Class<DynamoDBMarshaller<T>> marshallerClass;
    private final Class<T> targetType;
    
    public Converter(Class<T> targetType, DynamoDBMarshalling annotation)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */