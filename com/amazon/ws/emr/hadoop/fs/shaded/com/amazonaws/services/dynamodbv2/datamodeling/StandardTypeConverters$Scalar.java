package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

 enum StandardTypeConverters$Scalar
{
  BIG_DECIMAL(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(BigDecimal.class, null, null), Number.class, StandardTypeConverters.ToBigDecimal.access$000().join(StandardTypeConverters.ToString.access$100())), String.class, StandardTypeConverters.ToBigDecimal.access$000())),  BIG_INTEGER(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(BigInteger.class, null, null), Number.class, StandardTypeConverters.ToBigInteger.access$400().join(StandardTypeConverters.ToString.access$100())), String.class, StandardTypeConverters.ToBigInteger.access$400())),  BOOLEAN(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Boolean.class, Boolean.TYPE, null), Number.class, StandardTypeConverters.ToBoolean.access$500().join(StandardTypeConverters.ToString.access$100())), String.class, StandardTypeConverters.ToBoolean.access$500())),  BYTE(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Byte.class, Byte.TYPE, null), Number.class, StandardTypeConverters.ToByte.access$700()), String.class, StandardTypeConverters.ToByte.access$600())),  BYTE_ARRAY(ScalarAttributeType.B, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(byte[].class, null, null), ByteBuffer.class, StandardTypeConverters.ToByteArray.access$900()), String.class, StandardTypeConverters.ToByteArray.access$800())),  BYTE_BUFFER(ScalarAttributeType.B, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(ByteBuffer.class, null, null), byte[].class, StandardTypeConverters.ToByteBuffer.access$1100()), String.class, StandardTypeConverters.ToByteBuffer.access$1100().join(StandardTypeConverters.ToByteArray.access$800())), UUID.class, StandardTypeConverters.ToByteBuffer.access$1000())),  CALENDAR(ScalarAttributeType.S, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Calendar.class, null, null), Date.class, StandardTypeConverters.ToCalendar.access$1300()), DateTime.class, StandardTypeConverters.ToCalendar.access$1300().join(StandardTypeConverters.ToDate.access$1500())), Long.class, StandardTypeConverters.ToCalendar.access$1300().join(StandardTypeConverters.ToDate.access$1400())), String.class, StandardTypeConverters.ToCalendar.access$1300().join(StandardTypeConverters.ToDate.access$1200()))),  CHARACTER(ScalarAttributeType.S, 
    StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Character.class, Character.TYPE, null), String.class, StandardTypeConverters.ToCharacter.access$1600())),  CURRENCY(ScalarAttributeType.S, 
    StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Currency.class, null, null), String.class, StandardTypeConverters.ToCurrency.access$1700())),  DATE(ScalarAttributeType.S, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Date.class, null, null), Calendar.class, StandardTypeConverters.ToDate.access$1800()), DateTime.class, StandardTypeConverters.ToDate.access$1500()), Long.class, StandardTypeConverters.ToDate.access$1400()), String.class, StandardTypeConverters.ToDate.access$1200())),  DATE_TIME(null, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(DateTime.class, null, null), Calendar.class, StandardTypeConverters.ToDateTime.access$1900().join(StandardTypeConverters.ToDate.access$1800())), Date.class, StandardTypeConverters.ToDateTime.access$1900()), Long.class, StandardTypeConverters.ToDateTime.access$1900().join(StandardTypeConverters.ToDate.access$1400())), String.class, StandardTypeConverters.ToDateTime.access$1900().join(StandardTypeConverters.ToDate.access$1200()))),  DOUBLE(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Double.class, Double.TYPE, null), Number.class, StandardTypeConverters.ToDouble.access$2100()), String.class, StandardTypeConverters.ToDouble.access$2000())),  FLOAT(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Float.class, Float.TYPE, null), Number.class, StandardTypeConverters.ToFloat.access$2300()), String.class, StandardTypeConverters.ToFloat.access$2200())),  INTEGER(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Integer.class, Integer.TYPE, null), Number.class, StandardTypeConverters.ToInteger.access$2500()), String.class, StandardTypeConverters.ToInteger.access$2400())),  LOCALE(ScalarAttributeType.S, 
    StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Locale.class, null, null), String.class, StandardTypeConverters.ToLocale.access$2600())),  LONG(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Long.class, Long.TYPE, null), Date.class, StandardTypeConverters.ToLong.access$2900()), DateTime.class, StandardTypeConverters.ToLong.access$2900().join(StandardTypeConverters.ToDate.access$1500())), Calendar.class, StandardTypeConverters.ToLong.access$2900().join(StandardTypeConverters.ToDate.access$1800())), Number.class, StandardTypeConverters.ToLong.access$2800()), String.class, StandardTypeConverters.ToLong.access$2700())),  S3_LINK(ScalarAttributeType.S, new StandardTypeConverters.ConverterMap(S3Link.class, null, null)),  SHORT(ScalarAttributeType.N, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(Short.class, Short.TYPE, null), Number.class, StandardTypeConverters.ToShort.access$3100()), String.class, StandardTypeConverters.ToShort.access$3000())),  STRING(ScalarAttributeType.S, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(String.class, null, null), Boolean.class, StandardTypeConverters.ToString.access$3800()), byte[].class, StandardTypeConverters.ToString.access$3700()), ByteBuffer.class, StandardTypeConverters.ToString.access$3700().join(StandardTypeConverters.ToByteArray.access$900())), Calendar.class, StandardTypeConverters.ToString.access$3600().join(StandardTypeConverters.ToDate.access$1800())), Date.class, StandardTypeConverters.ToString.access$3600()), Enum.class, StandardTypeConverters.ToString.access$3500()), Locale.class, StandardTypeConverters.ToString.access$3400()), TimeZone.class, StandardTypeConverters.ToString.access$3300()), Object.class, StandardTypeConverters.ToString.access$3200())),  TIME_ZONE(ScalarAttributeType.S, 
    StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(TimeZone.class, null, null), String.class, StandardTypeConverters.ToTimeZone.access$3900())),  URL(ScalarAttributeType.S, 
    StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(URL.class, null, null), String.class, StandardTypeConverters.ToUrl.access$4000())),  URI(ScalarAttributeType.S, 
    StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(URI.class, null, null), String.class, StandardTypeConverters.ToUri.access$4100())),  UUID(ScalarAttributeType.S, 
  
    StandardTypeConverters.ConverterMap.access$300(StandardTypeConverters.ConverterMap.access$300(new StandardTypeConverters.ConverterMap(UUID.class, null, null), ByteBuffer.class, StandardTypeConverters.ToUuid.access$4300()), String.class, StandardTypeConverters.ToUuid.access$4200())),  DEFAULT(null, new StandardTypeConverters.ConverterMap(Object.class, null, null));
  
  private final ScalarAttributeType scalarAttributeType;
  private final StandardTypeConverters.ConverterMap map;
  
  private StandardTypeConverters$Scalar(ScalarAttributeType scalarAttributeType, StandardTypeConverters.ConverterMap map)
  {
    this.scalarAttributeType = scalarAttributeType;
    this.map = map;
  }
  
  <S, T> StandardTypeConverters.Converter<S, T> getConverter(Class<S> sourceType, Class<T> targetType)
  {
    return StandardTypeConverters.ConverterMap.access$4800(map, targetType);
  }
  
  final <S> S convert(Object o)
  {
    return (S)getConverter(type(), o.getClass()).convert(o);
  }
  
  final boolean is(ScalarAttributeType scalarAttributeType)
  {
    return this.scalarAttributeType == scalarAttributeType;
  }
  
  final boolean is(Class<?> type)
  {
    return StandardTypeConverters.ConverterMap.access$4600(map, type);
  }
  
  final <S> Class<S> type()
  {
    return StandardTypeConverters.ConverterMap.access$4900(map);
  }
  
  static Scalar of(Class<?> type)
  {
    for (Scalar scalar : ) {
      if (scalar.is(type)) {
        return scalar;
      }
    }
    return DEFAULT;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Scalar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */