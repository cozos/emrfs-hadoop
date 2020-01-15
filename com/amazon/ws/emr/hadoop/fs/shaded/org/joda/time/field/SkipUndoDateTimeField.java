package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;

public final class SkipUndoDateTimeField
  extends DelegatedDateTimeField
{
  private static final long serialVersionUID = -5875876968979L;
  private final Chronology iChronology;
  private final int iSkip;
  private transient int iMinValue;
  
  public SkipUndoDateTimeField(Chronology paramChronology, DateTimeField paramDateTimeField)
  {
    this(paramChronology, paramDateTimeField, 0);
  }
  
  public SkipUndoDateTimeField(Chronology paramChronology, DateTimeField paramDateTimeField, int paramInt)
  {
    super(paramDateTimeField);
    iChronology = paramChronology;
    int i = super.getMinimumValue();
    if (i < paramInt) {
      iMinValue = (i + 1);
    } else if (i == paramInt + 1) {
      iMinValue = paramInt;
    } else {
      iMinValue = i;
    }
    iSkip = paramInt;
  }
  
  public int get(long paramLong)
  {
    int i = super.get(paramLong);
    if (i < iSkip) {
      i++;
    }
    return i;
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, iMinValue, getMaximumValue());
    if (paramInt <= iSkip) {
      paramInt--;
    }
    return super.set(paramLong, paramInt);
  }
  
  public int getMinimumValue()
  {
    return iMinValue;
  }
  
  private Object readResolve()
  {
    return getType().getField(iChronology);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.SkipUndoDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */