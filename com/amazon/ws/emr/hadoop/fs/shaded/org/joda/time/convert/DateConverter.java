package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import java.util.Date;

final class DateConverter
  extends AbstractConverter
  implements InstantConverter, PartialConverter
{
  static final DateConverter INSTANCE = new DateConverter();
  
  public long getInstantMillis(Object paramObject, Chronology paramChronology)
  {
    Date localDate = (Date)paramObject;
    return localDate.getTime();
  }
  
  public Class<?> getSupportedType()
  {
    return Date.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.DateConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */