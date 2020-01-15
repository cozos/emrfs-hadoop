package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;

public abstract class DecoratedDateTimeField
  extends BaseDateTimeField
{
  private static final long serialVersionUID = 203115783733757597L;
  private final DateTimeField iField;
  
  protected DecoratedDateTimeField(DateTimeField paramDateTimeField, DateTimeFieldType paramDateTimeFieldType)
  {
    super(paramDateTimeFieldType);
    if (paramDateTimeField == null) {
      throw new IllegalArgumentException("The field must not be null");
    }
    if (!paramDateTimeField.isSupported()) {
      throw new IllegalArgumentException("The field must be supported");
    }
    iField = paramDateTimeField;
  }
  
  public final DateTimeField getWrappedField()
  {
    return iField;
  }
  
  public boolean isLenient()
  {
    return iField.isLenient();
  }
  
  public int get(long paramLong)
  {
    return iField.get(paramLong);
  }
  
  public long set(long paramLong, int paramInt)
  {
    return iField.set(paramLong, paramInt);
  }
  
  public DurationField getDurationField()
  {
    return iField.getDurationField();
  }
  
  public DurationField getRangeDurationField()
  {
    return iField.getRangeDurationField();
  }
  
  public int getMinimumValue()
  {
    return iField.getMinimumValue();
  }
  
  public int getMaximumValue()
  {
    return iField.getMaximumValue();
  }
  
  public long roundFloor(long paramLong)
  {
    return iField.roundFloor(paramLong);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */