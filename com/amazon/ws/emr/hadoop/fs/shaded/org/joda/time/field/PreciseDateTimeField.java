package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;

public class PreciseDateTimeField
  extends PreciseDurationDateTimeField
{
  private static final long serialVersionUID = -5586801265774496376L;
  private final int iRange;
  private final DurationField iRangeField;
  
  public PreciseDateTimeField(DateTimeFieldType paramDateTimeFieldType, DurationField paramDurationField1, DurationField paramDurationField2)
  {
    super(paramDateTimeFieldType, paramDurationField1);
    if (!paramDurationField2.isPrecise()) {
      throw new IllegalArgumentException("Range duration field must be precise");
    }
    long l = paramDurationField2.getUnitMillis();
    iRange = ((int)(l / getUnitMillis()));
    if (iRange < 2) {
      throw new IllegalArgumentException("The effective range must be at least 2");
    }
    iRangeField = paramDurationField2;
  }
  
  public int get(long paramLong)
  {
    if (paramLong >= 0L) {
      return (int)(paramLong / getUnitMillis() % iRange);
    }
    return iRange - 1 + (int)((paramLong + 1L) / getUnitMillis() % iRange);
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    int i = get(paramLong);
    int j = FieldUtils.getWrappedValue(i, paramInt, getMinimumValue(), getMaximumValue());
    
    return paramLong + (j - i) * getUnitMillis();
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, getMinimumValue(), getMaximumValue());
    return paramLong + (paramInt - get(paramLong)) * iUnitMillis;
  }
  
  public DurationField getRangeDurationField()
  {
    return iRangeField;
  }
  
  public int getMaximumValue()
  {
    return iRange - 1;
  }
  
  public int getRange()
  {
    return iRange;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */