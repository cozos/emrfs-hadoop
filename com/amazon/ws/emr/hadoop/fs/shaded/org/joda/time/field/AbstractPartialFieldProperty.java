package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.util.Locale;

public abstract class AbstractPartialFieldProperty
{
  public abstract DateTimeField getField();
  
  public DateTimeFieldType getFieldType()
  {
    return getField().getType();
  }
  
  public String getName()
  {
    return getField().getName();
  }
  
  protected abstract ReadablePartial getReadablePartial();
  
  public abstract int get();
  
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
    return getField().getAsText(getReadablePartial(), get(), paramLocale);
  }
  
  public String getAsShortText()
  {
    return getAsShortText(null);
  }
  
  public String getAsShortText(Locale paramLocale)
  {
    return getField().getAsShortText(getReadablePartial(), get(), paramLocale);
  }
  
  public DurationField getDurationField()
  {
    return getField().getDurationField();
  }
  
  public DurationField getRangeDurationField()
  {
    return getField().getRangeDurationField();
  }
  
  public int getMinimumValueOverall()
  {
    return getField().getMinimumValue();
  }
  
  public int getMinimumValue()
  {
    return getField().getMinimumValue(getReadablePartial());
  }
  
  public int getMaximumValueOverall()
  {
    return getField().getMaximumValue();
  }
  
  public int getMaximumValue()
  {
    return getField().getMaximumValue(getReadablePartial());
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return getField().getMaximumTextLength(paramLocale);
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    return getField().getMaximumShortTextLength(paramLocale);
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
      throw new IllegalArgumentException("The instant must not be null");
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
    if (!(paramObject instanceof AbstractPartialFieldProperty)) {
      return false;
    }
    AbstractPartialFieldProperty localAbstractPartialFieldProperty = (AbstractPartialFieldProperty)paramObject;
    return (get() == localAbstractPartialFieldProperty.get()) && (getFieldType() == localAbstractPartialFieldProperty.getFieldType()) && (FieldUtils.equals(getReadablePartial().getChronology(), localAbstractPartialFieldProperty.getReadablePartial().getChronology()));
  }
  
  public int hashCode()
  {
    int i = 19;
    i = 13 * i + get();
    i = 13 * i + getFieldType().hashCode();
    i = 13 * i + getReadablePartial().getChronology().hashCode();
    return i;
  }
  
  public String toString()
  {
    return "Property[" + getName() + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */