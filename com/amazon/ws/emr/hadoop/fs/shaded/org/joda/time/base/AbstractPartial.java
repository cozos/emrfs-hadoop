package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;

public abstract class AbstractPartial
  implements ReadablePartial, Comparable<ReadablePartial>
{
  protected abstract DateTimeField getField(int paramInt, Chronology paramChronology);
  
  public DateTimeFieldType getFieldType(int paramInt)
  {
    return getField(paramInt, getChronology()).getType();
  }
  
  public DateTimeFieldType[] getFieldTypes()
  {
    DateTimeFieldType[] arrayOfDateTimeFieldType = new DateTimeFieldType[size()];
    for (int i = 0; i < arrayOfDateTimeFieldType.length; i++) {
      arrayOfDateTimeFieldType[i] = getFieldType(i);
    }
    return arrayOfDateTimeFieldType;
  }
  
  public DateTimeField getField(int paramInt)
  {
    return getField(paramInt, getChronology());
  }
  
  public DateTimeField[] getFields()
  {
    DateTimeField[] arrayOfDateTimeField = new DateTimeField[size()];
    for (int i = 0; i < arrayOfDateTimeField.length; i++) {
      arrayOfDateTimeField[i] = getField(i);
    }
    return arrayOfDateTimeField;
  }
  
  public int[] getValues()
  {
    int[] arrayOfInt = new int[size()];
    for (int i = 0; i < arrayOfInt.length; i++) {
      arrayOfInt[i] = getValue(i);
    }
    return arrayOfInt;
  }
  
  public int get(DateTimeFieldType paramDateTimeFieldType)
  {
    return getValue(indexOfSupported(paramDateTimeFieldType));
  }
  
  public boolean isSupported(DateTimeFieldType paramDateTimeFieldType)
  {
    return indexOf(paramDateTimeFieldType) != -1;
  }
  
  public int indexOf(DateTimeFieldType paramDateTimeFieldType)
  {
    int i = 0;
    for (int j = size(); i < j; i++) {
      if (getFieldType(i) == paramDateTimeFieldType) {
        return i;
      }
    }
    return -1;
  }
  
  protected int indexOfSupported(DateTimeFieldType paramDateTimeFieldType)
  {
    int i = indexOf(paramDateTimeFieldType);
    if (i == -1) {
      throw new IllegalArgumentException("Field '" + paramDateTimeFieldType + "' is not supported");
    }
    return i;
  }
  
  protected int indexOf(DurationFieldType paramDurationFieldType)
  {
    int i = 0;
    for (int j = size(); i < j; i++) {
      if (getFieldType(i).getDurationType() == paramDurationFieldType) {
        return i;
      }
    }
    return -1;
  }
  
  protected int indexOfSupported(DurationFieldType paramDurationFieldType)
  {
    int i = indexOf(paramDurationFieldType);
    if (i == -1) {
      throw new IllegalArgumentException("Field '" + paramDurationFieldType + "' is not supported");
    }
    return i;
  }
  
  public DateTime toDateTime(ReadableInstant paramReadableInstant)
  {
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    long l1 = DateTimeUtils.getInstantMillis(paramReadableInstant);
    long l2 = localChronology.set(this, l1);
    return new DateTime(l2, localChronology);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ReadablePartial)) {
      return false;
    }
    ReadablePartial localReadablePartial = (ReadablePartial)paramObject;
    if (size() != localReadablePartial.size()) {
      return false;
    }
    int i = 0;
    for (int j = size(); i < j; i++) {
      if ((getValue(i) != localReadablePartial.getValue(i)) || (getFieldType(i) != localReadablePartial.getFieldType(i))) {
        return false;
      }
    }
    return FieldUtils.equals(getChronology(), localReadablePartial.getChronology());
  }
  
  public int hashCode()
  {
    int i = 157;
    int j = 0;
    for (int k = size(); j < k; j++)
    {
      i = 23 * i + getValue(j);
      i = 23 * i + getFieldType(j).hashCode();
    }
    i += getChronology().hashCode();
    return i;
  }
  
  public int compareTo(ReadablePartial paramReadablePartial)
  {
    if (this == paramReadablePartial) {
      return 0;
    }
    if (size() != paramReadablePartial.size()) {
      throw new ClassCastException("ReadablePartial objects must have matching field types");
    }
    int i = 0;
    for (int j = size(); i < j; i++) {
      if (getFieldType(i) != paramReadablePartial.getFieldType(i)) {
        throw new ClassCastException("ReadablePartial objects must have matching field types");
      }
    }
    i = 0;
    for (j = size(); i < j; i++)
    {
      if (getValue(i) > paramReadablePartial.getValue(i)) {
        return 1;
      }
      if (getValue(i) < paramReadablePartial.getValue(i)) {
        return -1;
      }
    }
    return 0;
  }
  
  public boolean isAfter(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      throw new IllegalArgumentException("Partial cannot be null");
    }
    return compareTo(paramReadablePartial) > 0;
  }
  
  public boolean isBefore(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      throw new IllegalArgumentException("Partial cannot be null");
    }
    return compareTo(paramReadablePartial) < 0;
  }
  
  public boolean isEqual(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      throw new IllegalArgumentException("Partial cannot be null");
    }
    return compareTo(paramReadablePartial) == 0;
  }
  
  public String toString(DateTimeFormatter paramDateTimeFormatter)
  {
    if (paramDateTimeFormatter == null) {
      return toString();
    }
    return paramDateTimeFormatter.print(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.AbstractPartial
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */