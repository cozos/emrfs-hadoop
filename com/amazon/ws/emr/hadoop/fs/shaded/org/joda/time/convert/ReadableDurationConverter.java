package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDuration;

class ReadableDurationConverter
  extends AbstractConverter
  implements DurationConverter, PeriodConverter
{
  static final ReadableDurationConverter INSTANCE = new ReadableDurationConverter();
  
  public long getDurationMillis(Object paramObject)
  {
    return ((ReadableDuration)paramObject).getMillis();
  }
  
  public void setInto(ReadWritablePeriod paramReadWritablePeriod, Object paramObject, Chronology paramChronology)
  {
    ReadableDuration localReadableDuration = (ReadableDuration)paramObject;
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    long l = localReadableDuration.getMillis();
    int[] arrayOfInt = paramChronology.get(paramReadWritablePeriod, l);
    for (int i = 0; i < arrayOfInt.length; i++) {
      paramReadWritablePeriod.setValue(i, arrayOfInt[i]);
    }
  }
  
  public Class<?> getSupportedType()
  {
    return ReadableDuration.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ReadableDurationConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */