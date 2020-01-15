package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import java.io.Serializable;

public class DelegatedDurationField
  extends DurationField
  implements Serializable
{
  private static final long serialVersionUID = -5576443481242007829L;
  private final DurationField iField;
  private final DurationFieldType iType;
  
  protected DelegatedDurationField(DurationField paramDurationField)
  {
    this(paramDurationField, null);
  }
  
  protected DelegatedDurationField(DurationField paramDurationField, DurationFieldType paramDurationFieldType)
  {
    if (paramDurationField == null) {
      throw new IllegalArgumentException("The field must not be null");
    }
    iField = paramDurationField;
    iType = (paramDurationFieldType == null ? paramDurationField.getType() : paramDurationFieldType);
  }
  
  public final DurationField getWrappedField()
  {
    return iField;
  }
  
  public DurationFieldType getType()
  {
    return iType;
  }
  
  public String getName()
  {
    return iType.getName();
  }
  
  public boolean isSupported()
  {
    return iField.isSupported();
  }
  
  public boolean isPrecise()
  {
    return iField.isPrecise();
  }
  
  public int getValue(long paramLong)
  {
    return iField.getValue(paramLong);
  }
  
  public long getValueAsLong(long paramLong)
  {
    return iField.getValueAsLong(paramLong);
  }
  
  public int getValue(long paramLong1, long paramLong2)
  {
    return iField.getValue(paramLong1, paramLong2);
  }
  
  public long getValueAsLong(long paramLong1, long paramLong2)
  {
    return iField.getValueAsLong(paramLong1, paramLong2);
  }
  
  public long getMillis(int paramInt)
  {
    return iField.getMillis(paramInt);
  }
  
  public long getMillis(long paramLong)
  {
    return iField.getMillis(paramLong);
  }
  
  public long getMillis(int paramInt, long paramLong)
  {
    return iField.getMillis(paramInt, paramLong);
  }
  
  public long getMillis(long paramLong1, long paramLong2)
  {
    return iField.getMillis(paramLong1, paramLong2);
  }
  
  public long add(long paramLong, int paramInt)
  {
    return iField.add(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return iField.add(paramLong1, paramLong2);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return iField.getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return iField.getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public long getUnitMillis()
  {
    return iField.getUnitMillis();
  }
  
  public int compareTo(DurationField paramDurationField)
  {
    return iField.compareTo(paramDurationField);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DelegatedDurationField)) {
      return iField.equals(iField);
    }
    return false;
  }
  
  public int hashCode()
  {
    return iField.hashCode() ^ iType.hashCode();
  }
  
  public String toString()
  {
    return "DurationField[" + iType + ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DelegatedDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */