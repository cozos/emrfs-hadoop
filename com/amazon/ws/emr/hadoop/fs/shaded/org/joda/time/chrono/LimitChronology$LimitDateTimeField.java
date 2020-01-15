package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDateTimeField;
import java.util.Locale;

class LimitChronology$LimitDateTimeField
  extends DecoratedDateTimeField
{
  private static final long serialVersionUID = -2435306746995699312L;
  private final DurationField iDurationField;
  private final DurationField iRangeDurationField;
  private final DurationField iLeapDurationField;
  
  LimitChronology$LimitDateTimeField(LimitChronology paramLimitChronology, DateTimeField paramDateTimeField, DurationField paramDurationField1, DurationField paramDurationField2, DurationField paramDurationField3)
  {
    super(paramDateTimeField, paramDateTimeField.getType());
    iDurationField = paramDurationField1;
    iRangeDurationField = paramDurationField2;
    iLeapDurationField = paramDurationField3;
  }
  
  public int get(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    return getWrappedField().get(paramLong);
  }
  
  public String getAsText(long paramLong, Locale paramLocale)
  {
    this$0.checkLimits(paramLong, null);
    return getWrappedField().getAsText(paramLong, paramLocale);
  }
  
  public String getAsShortText(long paramLong, Locale paramLocale)
  {
    this$0.checkLimits(paramLong, null);
    return getWrappedField().getAsShortText(paramLong, paramLocale);
  }
  
  public long add(long paramLong, int paramInt)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().add(paramLong, paramInt);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong1, null);
    long l = getWrappedField().add(paramLong1, paramLong2);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().addWrapField(paramLong, paramInt);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong1, "minuend");
    this$0.checkLimits(paramLong2, "subtrahend");
    return getWrappedField().getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong1, "minuend");
    this$0.checkLimits(paramLong2, "subtrahend");
    return getWrappedField().getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public long set(long paramLong, int paramInt)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().set(paramLong, paramInt);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().set(paramLong, paramString, paramLocale);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public final DurationField getDurationField()
  {
    return iDurationField;
  }
  
  public final DurationField getRangeDurationField()
  {
    return iRangeDurationField;
  }
  
  public boolean isLeap(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    return getWrappedField().isLeap(paramLong);
  }
  
  public int getLeapAmount(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    return getWrappedField().getLeapAmount(paramLong);
  }
  
  public final DurationField getLeapDurationField()
  {
    return iLeapDurationField;
  }
  
  public long roundFloor(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().roundFloor(paramLong);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long roundCeiling(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().roundCeiling(paramLong);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long roundHalfFloor(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().roundHalfFloor(paramLong);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long roundHalfCeiling(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().roundHalfCeiling(paramLong);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long roundHalfEven(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().roundHalfEven(paramLong);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long remainder(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().remainder(paramLong);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public int getMinimumValue(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    return getWrappedField().getMinimumValue(paramLong);
  }
  
  public int getMaximumValue(long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    return getWrappedField().getMaximumValue(paramLong);
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return getWrappedField().getMaximumTextLength(paramLocale);
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    return getWrappedField().getMaximumShortTextLength(paramLocale);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.LimitChronology.LimitDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */