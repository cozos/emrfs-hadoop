package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;

public abstract class ImpreciseDateTimeField
  extends BaseDateTimeField
{
  private static final long serialVersionUID = 7190739608550251860L;
  final long iUnitMillis;
  private final DurationField iDurationField;
  
  public ImpreciseDateTimeField(DateTimeFieldType paramDateTimeFieldType, long paramLong)
  {
    super(paramDateTimeFieldType);
    iUnitMillis = paramLong;
    iDurationField = new LinkedDurationField(paramDateTimeFieldType.getDurationType());
  }
  
  public abstract int get(long paramLong);
  
  public abstract long set(long paramLong, int paramInt);
  
  public abstract long add(long paramLong, int paramInt);
  
  public abstract long add(long paramLong1, long paramLong2);
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return FieldUtils.safeToInt(getDifferenceAsLong(paramLong1, paramLong2));
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -getDifferenceAsLong(paramLong2, paramLong1);
    }
    long l = (paramLong1 - paramLong2) / iUnitMillis;
    if (add(paramLong2, l) < paramLong1)
    {
      do
      {
        l += 1L;
      } while (add(paramLong2, l) <= paramLong1);
      l -= 1L;
    }
    else if (add(paramLong2, l) > paramLong1)
    {
      do
      {
        l -= 1L;
      } while (add(paramLong2, l) > paramLong1);
    }
    return l;
  }
  
  public final DurationField getDurationField()
  {
    return iDurationField;
  }
  
  public abstract DurationField getRangeDurationField();
  
  public abstract long roundFloor(long paramLong);
  
  protected final long getDurationUnitMillis()
  {
    return iUnitMillis;
  }
  
  private final class LinkedDurationField
    extends BaseDurationField
  {
    private static final long serialVersionUID = -203813474600094134L;
    
    LinkedDurationField(DurationFieldType paramDurationFieldType)
    {
      super();
    }
    
    public boolean isPrecise()
    {
      return false;
    }
    
    public long getUnitMillis()
    {
      return iUnitMillis;
    }
    
    public int getValue(long paramLong1, long paramLong2)
    {
      return ImpreciseDateTimeField.this.getDifference(paramLong2 + paramLong1, paramLong2);
    }
    
    public long getValueAsLong(long paramLong1, long paramLong2)
    {
      return ImpreciseDateTimeField.this.getDifferenceAsLong(paramLong2 + paramLong1, paramLong2);
    }
    
    public long getMillis(int paramInt, long paramLong)
    {
      return ImpreciseDateTimeField.this.add(paramLong, paramInt) - paramLong;
    }
    
    public long getMillis(long paramLong1, long paramLong2)
    {
      return ImpreciseDateTimeField.this.add(paramLong2, paramLong1) - paramLong2;
    }
    
    public long add(long paramLong, int paramInt)
    {
      return ImpreciseDateTimeField.this.add(paramLong, paramInt);
    }
    
    public long add(long paramLong1, long paramLong2)
    {
      return ImpreciseDateTimeField.this.add(paramLong1, paramLong2);
    }
    
    public int getDifference(long paramLong1, long paramLong2)
    {
      return ImpreciseDateTimeField.this.getDifference(paramLong1, paramLong2);
    }
    
    public long getDifferenceAsLong(long paramLong1, long paramLong2)
    {
      return ImpreciseDateTimeField.this.getDifferenceAsLong(paramLong1, paramLong2);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.ImpreciseDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */