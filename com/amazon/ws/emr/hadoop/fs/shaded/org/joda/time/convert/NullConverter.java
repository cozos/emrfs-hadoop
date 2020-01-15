package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritableInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;

class NullConverter
  extends AbstractConverter
  implements InstantConverter, PartialConverter, DurationConverter, PeriodConverter, IntervalConverter
{
  static final NullConverter INSTANCE = new NullConverter();
  
  public long getDurationMillis(Object paramObject)
  {
    return 0L;
  }
  
  public void setInto(ReadWritablePeriod paramReadWritablePeriod, Object paramObject, Chronology paramChronology)
  {
    paramReadWritablePeriod.setPeriod((Period)null);
  }
  
  public void setInto(ReadWritableInterval paramReadWritableInterval, Object paramObject, Chronology paramChronology)
  {
    paramReadWritableInterval.setChronology(paramChronology);
    long l = DateTimeUtils.currentTimeMillis();
    paramReadWritableInterval.setInterval(l, l);
  }
  
  public Class<?> getSupportedType()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.NullConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */