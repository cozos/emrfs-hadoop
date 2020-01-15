package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.TimeZone;

@DynamoDBTypeConverted(converter=Converter.class)
@DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
public @interface DynamoDBTypeConvertedTimestamp
{
  String pattern() default "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  
  String timeZone() default "UTC";
  
  public static final class Converter<T>
    implements DynamoDBTypeConverter<String, T>
  {
    private final DynamoDBTypeConverter<DateTime, T> converter;
    private final DateTimeFormatter formatter;
    
    public Converter(Class<T> targetType, DynamoDBTypeConvertedTimestamp annotation)
    {
      formatter = DateTimeFormat.forPattern(annotation.pattern()).withZone(
        DateTimeZone.forTimeZone((TimeZone)StandardTypeConverters.Scalar.TIME_ZONE.convert(annotation.timeZone())));
      
      converter = StandardTypeConverters.factory().getConverter(DateTime.class, targetType);
    }
    
    public final String convert(T object)
    {
      return formatter.print((ReadableInstant)converter.convert(object));
    }
    
    public final T unconvert(String object)
    {
      return (T)converter.unconvert(formatter.parseDateTime(object));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedTimestamp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */