package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import java.io.Serializable;

public abstract class BaseSingleFieldPeriod
  implements ReadablePeriod, Comparable<BaseSingleFieldPeriod>, Serializable
{
  private static final long serialVersionUID = 9386874258972L;
  private static final long START_1972 = 63072000000L;
  private volatile int iPeriod;
  
  protected static int between(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2, DurationFieldType paramDurationFieldType)
  {
    if ((paramReadableInstant1 == null) || (paramReadableInstant2 == null)) {
      throw new IllegalArgumentException("ReadableInstant objects must not be null");
    }
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant1);
    int i = paramDurationFieldType.getField(localChronology).getDifference(paramReadableInstant2.getMillis(), paramReadableInstant1.getMillis());
    return i;
  }
  
  protected static int between(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2, ReadablePeriod paramReadablePeriod)
  {
    if ((paramReadablePartial1 == null) || (paramReadablePartial2 == null)) {
      throw new IllegalArgumentException("ReadablePartial objects must not be null");
    }
    if (paramReadablePartial1.size() != paramReadablePartial2.size()) {
      throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
    }
    int i = 0;
    for (int j = paramReadablePartial1.size(); i < j; i++) {
      if (paramReadablePartial1.getFieldType(i) != paramReadablePartial2.getFieldType(i)) {
        throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
      }
    }
    if (!DateTimeUtils.isContiguous(paramReadablePartial1)) {
      throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
    }
    Chronology localChronology = DateTimeUtils.getChronology(paramReadablePartial1.getChronology()).withUTC();
    int[] arrayOfInt = localChronology.get(paramReadablePeriod, localChronology.set(paramReadablePartial1, 63072000000L), localChronology.set(paramReadablePartial2, 63072000000L));
    return arrayOfInt[0];
  }
  
  protected static int standardPeriodIn(ReadablePeriod paramReadablePeriod, long paramLong)
  {
    if (paramReadablePeriod == null) {
      return 0;
    }
    ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
    long l = 0L;
    for (int i = 0; i < paramReadablePeriod.size(); i++)
    {
      int j = paramReadablePeriod.getValue(i);
      if (j != 0)
      {
        DurationField localDurationField = paramReadablePeriod.getFieldType(i).getField(localISOChronology);
        if (!localDurationField.isPrecise()) {
          throw new IllegalArgumentException("Cannot convert period to duration as " + localDurationField.getName() + " is not precise in the period " + paramReadablePeriod);
        }
        l = FieldUtils.safeAdd(l, FieldUtils.safeMultiply(localDurationField.getUnitMillis(), j));
      }
    }
    return FieldUtils.safeToInt(l / paramLong);
  }
  
  protected BaseSingleFieldPeriod(int paramInt)
  {
    iPeriod = paramInt;
  }
  
  protected int getValue()
  {
    return iPeriod;
  }
  
  protected void setValue(int paramInt)
  {
    iPeriod = paramInt;
  }
  
  public abstract DurationFieldType getFieldType();
  
  public abstract PeriodType getPeriodType();
  
  public int size()
  {
    return 1;
  }
  
  public DurationFieldType getFieldType(int paramInt)
  {
    if (paramInt != 0) {
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    }
    return getFieldType();
  }
  
  public int getValue(int paramInt)
  {
    if (paramInt != 0) {
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    }
    return getValue();
  }
  
  public int get(DurationFieldType paramDurationFieldType)
  {
    if (paramDurationFieldType == getFieldType()) {
      return getValue();
    }
    return 0;
  }
  
  public boolean isSupported(DurationFieldType paramDurationFieldType)
  {
    return paramDurationFieldType == getFieldType();
  }
  
  public Period toPeriod()
  {
    return Period.ZERO.withFields(this);
  }
  
  public MutablePeriod toMutablePeriod()
  {
    MutablePeriod localMutablePeriod = new MutablePeriod();
    localMutablePeriod.add(this);
    return localMutablePeriod;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ReadablePeriod)) {
      return false;
    }
    ReadablePeriod localReadablePeriod = (ReadablePeriod)paramObject;
    return (localReadablePeriod.getPeriodType() == getPeriodType()) && (localReadablePeriod.getValue(0) == getValue());
  }
  
  public int hashCode()
  {
    int i = 17;
    i = 27 * i + getValue();
    i = 27 * i + getFieldType().hashCode();
    return i;
  }
  
  public int compareTo(BaseSingleFieldPeriod paramBaseSingleFieldPeriod)
  {
    if (paramBaseSingleFieldPeriod.getClass() != getClass()) {
      throw new ClassCastException(getClass() + " cannot be compared to " + paramBaseSingleFieldPeriod.getClass());
    }
    int i = paramBaseSingleFieldPeriod.getValue();
    int j = getValue();
    if (j > i) {
      return 1;
    }
    if (j < i) {
      return -1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseSingleFieldPeriod
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */