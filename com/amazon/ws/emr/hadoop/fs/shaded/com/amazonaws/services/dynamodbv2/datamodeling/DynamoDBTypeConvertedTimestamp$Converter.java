package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import java.util.TimeZone;

public final class DynamoDBTypeConvertedTimestamp$Converter<T>
  implements DynamoDBTypeConverter<String, T>
{
  private final DynamoDBTypeConverter<DateTime, T> converter;
  private final DateTimeFormatter formatter;
  
  public DynamoDBTypeConvertedTimestamp$Converter(Class<T> targetType, DynamoDBTypeConvertedTimestamp annotation)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedTimestamp.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */