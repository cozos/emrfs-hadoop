package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Duration;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDuration;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.PeriodConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import java.io.Serializable;

public abstract class BasePeriod
  extends AbstractPeriod
  implements ReadablePeriod, Serializable
{
  private static final long serialVersionUID = -2110953284060001145L;
  private static final ReadablePeriod DUMMY_PERIOD = new AbstractPeriod()
  {
    public int getValue(int paramAnonymousInt)
    {
      return 0;
    }
    
    public PeriodType getPeriodType()
    {
      return PeriodType.time();
    }
  };
  private final PeriodType iType;
  private final int[] iValues;
  
  protected BasePeriod(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, PeriodType paramPeriodType)
  {
    paramPeriodType = checkPeriodType(paramPeriodType);
    iType = paramPeriodType;
    iValues = setPeriodInternal(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  protected BasePeriod(long paramLong1, long paramLong2, PeriodType paramPeriodType, Chronology paramChronology)
  {
    paramPeriodType = checkPeriodType(paramPeriodType);
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iType = paramPeriodType;
    iValues = paramChronology.get(this, paramLong1, paramLong2);
  }
  
  protected BasePeriod(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2, PeriodType paramPeriodType)
  {
    paramPeriodType = checkPeriodType(paramPeriodType);
    if ((paramReadableInstant1 == null) && (paramReadableInstant2 == null))
    {
      iType = paramPeriodType;
      iValues = new int[size()];
    }
    else
    {
      long l1 = DateTimeUtils.getInstantMillis(paramReadableInstant1);
      long l2 = DateTimeUtils.getInstantMillis(paramReadableInstant2);
      Chronology localChronology = DateTimeUtils.getIntervalChronology(paramReadableInstant1, paramReadableInstant2);
      iType = paramPeriodType;
      iValues = localChronology.get(this, l1, l2);
    }
  }
  
  protected BasePeriod(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2, PeriodType paramPeriodType)
  {
    if ((paramReadablePartial1 == null) || (paramReadablePartial2 == null)) {
      throw new IllegalArgumentException("ReadablePartial objects must not be null");
    }
    if (((paramReadablePartial1 instanceof BaseLocal)) && ((paramReadablePartial2 instanceof BaseLocal)) && (paramReadablePartial1.getClass() == paramReadablePartial2.getClass()))
    {
      paramPeriodType = checkPeriodType(paramPeriodType);
      long l1 = ((BaseLocal)paramReadablePartial1).getLocalMillis();
      long l2 = ((BaseLocal)paramReadablePartial2).getLocalMillis();
      Chronology localChronology1 = paramReadablePartial1.getChronology();
      localChronology1 = DateTimeUtils.getChronology(localChronology1);
      iType = paramPeriodType;
      iValues = localChronology1.get(this, l1, l2);
    }
    else
    {
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
      iType = checkPeriodType(paramPeriodType);
      Chronology localChronology2 = DateTimeUtils.getChronology(paramReadablePartial1.getChronology()).withUTC();
      iValues = localChronology2.get(this, localChronology2.set(paramReadablePartial1, 0L), localChronology2.set(paramReadablePartial2, 0L));
    }
  }
  
  protected BasePeriod(ReadableInstant paramReadableInstant, ReadableDuration paramReadableDuration, PeriodType paramPeriodType)
  {
    paramPeriodType = checkPeriodType(paramPeriodType);
    long l1 = DateTimeUtils.getInstantMillis(paramReadableInstant);
    long l2 = DateTimeUtils.getDurationMillis(paramReadableDuration);
    long l3 = FieldUtils.safeAdd(l1, l2);
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    iType = paramPeriodType;
    iValues = localChronology.get(this, l1, l3);
  }
  
  protected BasePeriod(ReadableDuration paramReadableDuration, ReadableInstant paramReadableInstant, PeriodType paramPeriodType)
  {
    paramPeriodType = checkPeriodType(paramPeriodType);
    long l1 = DateTimeUtils.getDurationMillis(paramReadableDuration);
    long l2 = DateTimeUtils.getInstantMillis(paramReadableInstant);
    long l3 = FieldUtils.safeSubtract(l2, l1);
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    iType = paramPeriodType;
    iValues = localChronology.get(this, l3, l2);
  }
  
  protected BasePeriod(long paramLong)
  {
    iType = PeriodType.standard();
    int[] arrayOfInt = ISOChronology.getInstanceUTC().get(DUMMY_PERIOD, paramLong);
    iValues = new int[8];
    System.arraycopy(arrayOfInt, 0, iValues, 4, 4);
  }
  
  protected BasePeriod(long paramLong, PeriodType paramPeriodType, Chronology paramChronology)
  {
    paramPeriodType = checkPeriodType(paramPeriodType);
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iType = paramPeriodType;
    iValues = paramChronology.get(this, paramLong);
  }
  
  protected BasePeriod(Object paramObject, PeriodType paramPeriodType, Chronology paramChronology)
  {
    PeriodConverter localPeriodConverter = ConverterManager.getInstance().getPeriodConverter(paramObject);
    paramPeriodType = paramPeriodType == null ? localPeriodConverter.getPeriodType(paramObject) : paramPeriodType;
    paramPeriodType = checkPeriodType(paramPeriodType);
    iType = paramPeriodType;
    if ((this instanceof ReadWritablePeriod))
    {
      iValues = new int[size()];
      paramChronology = DateTimeUtils.getChronology(paramChronology);
      localPeriodConverter.setInto((ReadWritablePeriod)this, paramObject, paramChronology);
    }
    else
    {
      iValues = new MutablePeriod(paramObject, paramPeriodType, paramChronology).getValues();
    }
  }
  
  protected BasePeriod(int[] paramArrayOfInt, PeriodType paramPeriodType)
  {
    iType = paramPeriodType;
    iValues = paramArrayOfInt;
  }
  
  protected PeriodType checkPeriodType(PeriodType paramPeriodType)
  {
    return DateTimeUtils.getPeriodType(paramPeriodType);
  }
  
  public PeriodType getPeriodType()
  {
    return iType;
  }
  
  public int getValue(int paramInt)
  {
    return iValues[paramInt];
  }
  
  public Duration toDurationFrom(ReadableInstant paramReadableInstant)
  {
    long l1 = DateTimeUtils.getInstantMillis(paramReadableInstant);
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    long l2 = localChronology.add(this, l1, 1);
    return new Duration(l1, l2);
  }
  
  public Duration toDurationTo(ReadableInstant paramReadableInstant)
  {
    long l1 = DateTimeUtils.getInstantMillis(paramReadableInstant);
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    long l2 = localChronology.add(this, l1, -1);
    return new Duration(l2, l1);
  }
  
  private void checkAndUpdate(DurationFieldType paramDurationFieldType, int[] paramArrayOfInt, int paramInt)
  {
    int i = indexOf(paramDurationFieldType);
    if (i == -1)
    {
      if (paramInt != 0) {
        throw new IllegalArgumentException("Period does not support field '" + paramDurationFieldType.getName() + "'");
      }
    }
    else {
      paramArrayOfInt[i] = paramInt;
    }
  }
  
  protected void setPeriod(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      setValues(new int[size()]);
    } else {
      setPeriodInternal(paramReadablePeriod);
    }
  }
  
  private void setPeriodInternal(ReadablePeriod paramReadablePeriod)
  {
    int[] arrayOfInt = new int[size()];
    int i = 0;
    for (int j = paramReadablePeriod.size(); i < j; i++)
    {
      DurationFieldType localDurationFieldType = paramReadablePeriod.getFieldType(i);
      int k = paramReadablePeriod.getValue(i);
      checkAndUpdate(localDurationFieldType, arrayOfInt, k);
    }
    setValues(arrayOfInt);
  }
  
  protected void setPeriod(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int[] arrayOfInt = setPeriodInternal(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    setValues(arrayOfInt);
  }
  
  private int[] setPeriodInternal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int[] arrayOfInt = new int[size()];
    checkAndUpdate(DurationFieldType.years(), arrayOfInt, paramInt1);
    checkAndUpdate(DurationFieldType.months(), arrayOfInt, paramInt2);
    checkAndUpdate(DurationFieldType.weeks(), arrayOfInt, paramInt3);
    checkAndUpdate(DurationFieldType.days(), arrayOfInt, paramInt4);
    checkAndUpdate(DurationFieldType.hours(), arrayOfInt, paramInt5);
    checkAndUpdate(DurationFieldType.minutes(), arrayOfInt, paramInt6);
    checkAndUpdate(DurationFieldType.seconds(), arrayOfInt, paramInt7);
    checkAndUpdate(DurationFieldType.millis(), arrayOfInt, paramInt8);
    return arrayOfInt;
  }
  
  protected void setField(DurationFieldType paramDurationFieldType, int paramInt)
  {
    setFieldInto(iValues, paramDurationFieldType, paramInt);
  }
  
  protected void setFieldInto(int[] paramArrayOfInt, DurationFieldType paramDurationFieldType, int paramInt)
  {
    int i = indexOf(paramDurationFieldType);
    if (i == -1)
    {
      if ((paramInt != 0) || (paramDurationFieldType == null)) {
        throw new IllegalArgumentException("Period does not support field '" + paramDurationFieldType + "'");
      }
    }
    else {
      paramArrayOfInt[i] = paramInt;
    }
  }
  
  protected void addField(DurationFieldType paramDurationFieldType, int paramInt)
  {
    addFieldInto(iValues, paramDurationFieldType, paramInt);
  }
  
  protected void addFieldInto(int[] paramArrayOfInt, DurationFieldType paramDurationFieldType, int paramInt)
  {
    int i = indexOf(paramDurationFieldType);
    if (i == -1)
    {
      if ((paramInt != 0) || (paramDurationFieldType == null)) {
        throw new IllegalArgumentException("Period does not support field '" + paramDurationFieldType + "'");
      }
    }
    else {
      paramArrayOfInt[i] = FieldUtils.safeAdd(paramArrayOfInt[i], paramInt);
    }
  }
  
  protected void mergePeriod(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod != null) {
      setValues(mergePeriodInto(getValues(), paramReadablePeriod));
    }
  }
  
  protected int[] mergePeriodInto(int[] paramArrayOfInt, ReadablePeriod paramReadablePeriod)
  {
    int i = 0;
    for (int j = paramReadablePeriod.size(); i < j; i++)
    {
      DurationFieldType localDurationFieldType = paramReadablePeriod.getFieldType(i);
      int k = paramReadablePeriod.getValue(i);
      checkAndUpdate(localDurationFieldType, paramArrayOfInt, k);
    }
    return paramArrayOfInt;
  }
  
  protected void addPeriod(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod != null) {
      setValues(addPeriodInto(getValues(), paramReadablePeriod));
    }
  }
  
  protected int[] addPeriodInto(int[] paramArrayOfInt, ReadablePeriod paramReadablePeriod)
  {
    int i = 0;
    for (int j = paramReadablePeriod.size(); i < j; i++)
    {
      DurationFieldType localDurationFieldType = paramReadablePeriod.getFieldType(i);
      int k = paramReadablePeriod.getValue(i);
      if (k != 0)
      {
        int m = indexOf(localDurationFieldType);
        if (m == -1) {
          throw new IllegalArgumentException("Period does not support field '" + localDurationFieldType.getName() + "'");
        }
        paramArrayOfInt[m] = FieldUtils.safeAdd(getValue(m), k);
      }
    }
    return paramArrayOfInt;
  }
  
  protected void setValue(int paramInt1, int paramInt2)
  {
    iValues[paramInt1] = paramInt2;
  }
  
  protected void setValues(int[] paramArrayOfInt)
  {
    System.arraycopy(paramArrayOfInt, 0, iValues, 0, iValues.length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BasePeriod
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */