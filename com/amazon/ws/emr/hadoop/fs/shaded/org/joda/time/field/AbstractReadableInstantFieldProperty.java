package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Interval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.Serializable;
import java.util.Locale;

public abstract class AbstractReadableInstantFieldProperty
  implements Serializable
{
  private static final long serialVersionUID = 1971226328211649661L;
  
  public abstract DateTimeField getField();
  
  public DateTimeFieldType getFieldType()
  {
    return getField().getType();
  }
  
  public String getName()
  {
    return getField().getName();
  }
  
  protected abstract long getMillis();
  
  protected Chronology getChronology()
  {
    throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
  }
  
  public int get()
  {
    return getField().get(getMillis());
  }
  
  public String getAsString()
  {
    return Integer.toString(get());
  }
  
  public String getAsText()
  {
    return getAsText(null);
  }
  
  public String getAsText(Locale paramLocale)
  {
    return getField().getAsText(getMillis(), paramLocale);
  }
  
  public String getAsShortText()
  {
    return getAsShortText(null);
  }
  
  public String getAsShortText(Locale paramLocale)
  {
    return getField().getAsShortText(getMillis(), paramLocale);
  }
  
  public int getDifference(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      return getField().getDifference(getMillis(), DateTimeUtils.currentTimeMillis());
    }
    return getField().getDifference(getMillis(), paramReadableInstant.getMillis());
  }
  
  public long getDifferenceAsLong(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      return getField().getDifferenceAsLong(getMillis(), DateTimeUtils.currentTimeMillis());
    }
    return getField().getDifferenceAsLong(getMillis(), paramReadableInstant.getMillis());
  }
  
  public DurationField getDurationField()
  {
    return getField().getDurationField();
  }
  
  public DurationField getRangeDurationField()
  {
    return getField().getRangeDurationField();
  }
  
  public boolean isLeap()
  {
    return getField().isLeap(getMillis());
  }
  
  public int getLeapAmount()
  {
    return getField().getLeapAmount(getMillis());
  }
  
  public DurationField getLeapDurationField()
  {
    return getField().getLeapDurationField();
  }
  
  public int getMinimumValueOverall()
  {
    return getField().getMinimumValue();
  }
  
  public int getMinimumValue()
  {
    return getField().getMinimumValue(getMillis());
  }
  
  public int getMaximumValueOverall()
  {
    return getField().getMaximumValue();
  }
  
  public int getMaximumValue()
  {
    return getField().getMaximumValue(getMillis());
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return getField().getMaximumTextLength(paramLocale);
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    return getField().getMaximumShortTextLength(paramLocale);
  }
  
  public long remainder()
  {
    return getField().remainder(getMillis());
  }
  
  public Interval toInterval()
  {
    DateTimeField localDateTimeField = getField();
    long l1 = localDateTimeField.roundFloor(getMillis());
    long l2 = localDateTimeField.add(l1, 1);
    Interval localInterval = new Interval(l1, l2, getChronology());
    return localInterval;
  }
  
  public int compareTo(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      throw new IllegalArgumentException("The instant must not be null");
    }
    int i = get();
    int j = paramReadableInstant.get(getFieldType());
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
  
  public int compareTo(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      throw new IllegalArgumentException("The partial must not be null");
    }
    int i = get();
    int j = paramReadablePartial.get(getFieldType());
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AbstractReadableInstantFieldProperty)) {
      return false;
    }
    AbstractReadableInstantFieldProperty localAbstractReadableInstantFieldProperty = (AbstractReadableInstantFieldProperty)paramObject;
    return (get() == localAbstractReadableInstantFieldProperty.get()) && (getFieldType().equals(localAbstractReadableInstantFieldProperty.getFieldType())) && (FieldUtils.equals(getChronology(), localAbstractReadableInstantFieldProperty.getChronology()));
  }
  
  public int hashCode()
  {
    return get() * 17 + getFieldType().hashCode() + getChronology().hashCode();
  }
  
  public String toString()
  {
    return "Property[" + getName() + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */