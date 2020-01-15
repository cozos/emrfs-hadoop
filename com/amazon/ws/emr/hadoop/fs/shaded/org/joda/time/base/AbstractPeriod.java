package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import org.joda.convert.ToString;

public abstract class AbstractPeriod
  implements ReadablePeriod
{
  public int size()
  {
    return getPeriodType().size();
  }
  
  public DurationFieldType getFieldType(int paramInt)
  {
    return getPeriodType().getFieldType(paramInt);
  }
  
  public DurationFieldType[] getFieldTypes()
  {
    DurationFieldType[] arrayOfDurationFieldType = new DurationFieldType[size()];
    for (int i = 0; i < arrayOfDurationFieldType.length; i++) {
      arrayOfDurationFieldType[i] = getFieldType(i);
    }
    return arrayOfDurationFieldType;
  }
  
  public int[] getValues()
  {
    int[] arrayOfInt = new int[size()];
    for (int i = 0; i < arrayOfInt.length; i++) {
      arrayOfInt[i] = getValue(i);
    }
    return arrayOfInt;
  }
  
  public int get(DurationFieldType paramDurationFieldType)
  {
    int i = indexOf(paramDurationFieldType);
    if (i == -1) {
      return 0;
    }
    return getValue(i);
  }
  
  public boolean isSupported(DurationFieldType paramDurationFieldType)
  {
    return getPeriodType().isSupported(paramDurationFieldType);
  }
  
  public int indexOf(DurationFieldType paramDurationFieldType)
  {
    return getPeriodType().indexOf(paramDurationFieldType);
  }
  
  public Period toPeriod()
  {
    return new Period(this);
  }
  
  public MutablePeriod toMutablePeriod()
  {
    return new MutablePeriod(this);
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
    if (size() != localReadablePeriod.size()) {
      return false;
    }
    int i = 0;
    for (int j = size(); i < j; i++) {
      if ((getValue(i) != localReadablePeriod.getValue(i)) || (getFieldType(i) != localReadablePeriod.getFieldType(i))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = 17;
    int j = 0;
    for (int k = size(); j < k; j++)
    {
      i = 27 * i + getValue(j);
      i = 27 * i + getFieldType(j).hashCode();
    }
    return i;
  }
  
  @ToString
  public String toString()
  {
    return ISOPeriodFormat.standard().print(this);
  }
  
  public String toString(PeriodFormatter paramPeriodFormatter)
  {
    if (paramPeriodFormatter == null) {
      return toString();
    }
    return paramPeriodFormatter.print(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.AbstractPeriod
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */