package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritableInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInterval;

class ReadableIntervalConverter
  extends AbstractConverter
  implements IntervalConverter, DurationConverter, PeriodConverter
{
  static final ReadableIntervalConverter INSTANCE = new ReadableIntervalConverter();
  
  public long getDurationMillis(Object paramObject)
  {
    return ((ReadableInterval)paramObject).toDurationMillis();
  }
  
  public void setInto(ReadWritablePeriod paramReadWritablePeriod, Object paramObject, Chronology paramChronology)
  {
    ReadableInterval localReadableInterval = (ReadableInterval)paramObject;
    paramChronology = paramChronology != null ? paramChronology : DateTimeUtils.getIntervalChronology(localReadableInterval);
    long l1 = localReadableInterval.getStartMillis();
    long l2 = localReadableInterval.getEndMillis();
    int[] arrayOfInt = paramChronology.get(paramReadWritablePeriod, l1, l2);
    for (int i = 0; i < arrayOfInt.length; i++) {
      paramReadWritablePeriod.setValue(i, arrayOfInt[i]);
    }
  }
  
  public boolean isReadableInterval(Object paramObject, Chronology paramChronology)
  {
    return true;
  }
  
  public void setInto(ReadWritableInterval paramReadWritableInterval, Object paramObject, Chronology paramChronology)
  {
    ReadableInterval localReadableInterval = (ReadableInterval)paramObject;
    paramReadWritableInterval.setInterval(localReadableInterval);
    if (paramChronology != null) {
      paramReadWritableInterval.setChronology(paramChronology);
    } else {
      paramReadWritableInterval.setChronology(localReadableInterval.getChronology());
    }
  }
  
  public Class<?> getSupportedType()
  {
    return ReadableInterval.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ReadableIntervalConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */