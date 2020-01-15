package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;

class ReadablePeriodConverter
  extends AbstractConverter
  implements PeriodConverter
{
  static final ReadablePeriodConverter INSTANCE = new ReadablePeriodConverter();
  
  public void setInto(ReadWritablePeriod paramReadWritablePeriod, Object paramObject, Chronology paramChronology)
  {
    paramReadWritablePeriod.setPeriod((ReadablePeriod)paramObject);
  }
  
  public PeriodType getPeriodType(Object paramObject)
  {
    ReadablePeriod localReadablePeriod = (ReadablePeriod)paramObject;
    return localReadablePeriod.getPeriodType();
  }
  
  public Class<?> getSupportedType()
  {
    return ReadablePeriod.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ReadablePeriodConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */