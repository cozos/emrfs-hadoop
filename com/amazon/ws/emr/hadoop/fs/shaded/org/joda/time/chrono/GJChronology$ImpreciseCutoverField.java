package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;

final class GJChronology$ImpreciseCutoverField
  extends GJChronology.CutoverField
{
  private static final long serialVersionUID = 3410248757173576441L;
  
  GJChronology$ImpreciseCutoverField(GJChronology paramGJChronology, DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, long paramLong)
  {
    this(paramGJChronology, paramDateTimeField1, paramDateTimeField2, null, paramLong, false);
  }
  
  GJChronology$ImpreciseCutoverField(GJChronology paramGJChronology, DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, DurationField paramDurationField, long paramLong)
  {
    this(paramGJChronology, paramDateTimeField1, paramDateTimeField2, paramDurationField, paramLong, false);
  }
  
  GJChronology$ImpreciseCutoverField(GJChronology paramGJChronology, DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, DurationField paramDurationField1, DurationField paramDurationField2, long paramLong)
  {
    this(paramGJChronology, paramDateTimeField1, paramDateTimeField2, paramDurationField1, paramLong, false);
    iRangeDurationField = paramDurationField2;
  }
  
  GJChronology$ImpreciseCutoverField(GJChronology paramGJChronology, DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, DurationField paramDurationField, long paramLong, boolean paramBoolean)
  {
    super(paramGJChronology, paramDateTimeField1, paramDateTimeField2, paramLong, paramBoolean);
    if (paramDurationField == null) {
      paramDurationField = new GJChronology.LinkedDurationField(iDurationField, this);
    }
    iDurationField = paramDurationField;
  }
  
  public long add(long paramLong, int paramInt)
  {
    if (paramLong >= iCutover)
    {
      paramLong = iGregorianField.add(paramLong, paramInt);
      if (paramLong < iCutover) {
        if (paramLong + GJChronology.access$000(this$0) < iCutover)
        {
          int i;
          if (iConvertByWeekyear)
          {
            i = GJChronology.access$100(this$0).weekyear().get(paramLong);
            if (i <= 0) {
              paramLong = GJChronology.access$100(this$0).weekyear().add(paramLong, -1);
            }
          }
          else
          {
            i = GJChronology.access$100(this$0).year().get(paramLong);
            if (i <= 0) {
              paramLong = GJChronology.access$100(this$0).year().add(paramLong, -1);
            }
          }
          paramLong = gregorianToJulian(paramLong);
        }
      }
    }
    else
    {
      paramLong = iJulianField.add(paramLong, paramInt);
      if (paramLong >= iCutover) {
        if (paramLong - GJChronology.access$000(this$0) >= iCutover) {
          paramLong = julianToGregorian(paramLong);
        }
      }
    }
    return paramLong;
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= iCutover)
    {
      paramLong1 = iGregorianField.add(paramLong1, paramLong2);
      if (paramLong1 < iCutover) {
        if (paramLong1 + GJChronology.access$000(this$0) < iCutover)
        {
          int i;
          if (iConvertByWeekyear)
          {
            i = GJChronology.access$100(this$0).weekyear().get(paramLong1);
            if (i <= 0) {
              paramLong1 = GJChronology.access$100(this$0).weekyear().add(paramLong1, -1);
            }
          }
          else
          {
            i = GJChronology.access$100(this$0).year().get(paramLong1);
            if (i <= 0) {
              paramLong1 = GJChronology.access$100(this$0).year().add(paramLong1, -1);
            }
          }
          paramLong1 = gregorianToJulian(paramLong1);
        }
      }
    }
    else
    {
      paramLong1 = iJulianField.add(paramLong1, paramLong2);
      if (paramLong1 >= iCutover) {
        if (paramLong1 - GJChronology.access$000(this$0) >= iCutover) {
          paramLong1 = julianToGregorian(paramLong1);
        }
      }
    }
    return paramLong1;
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= iCutover)
    {
      if (paramLong2 >= iCutover) {
        return iGregorianField.getDifference(paramLong1, paramLong2);
      }
      paramLong1 = gregorianToJulian(paramLong1);
      return iJulianField.getDifference(paramLong1, paramLong2);
    }
    if (paramLong2 < iCutover) {
      return iJulianField.getDifference(paramLong1, paramLong2);
    }
    paramLong1 = julianToGregorian(paramLong1);
    return iGregorianField.getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= iCutover)
    {
      if (paramLong2 >= iCutover) {
        return iGregorianField.getDifferenceAsLong(paramLong1, paramLong2);
      }
      paramLong1 = gregorianToJulian(paramLong1);
      return iJulianField.getDifferenceAsLong(paramLong1, paramLong2);
    }
    if (paramLong2 < iCutover) {
      return iJulianField.getDifferenceAsLong(paramLong1, paramLong2);
    }
    paramLong1 = julianToGregorian(paramLong1);
    return iGregorianField.getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public int getMinimumValue(long paramLong)
  {
    if (paramLong >= iCutover) {
      return iGregorianField.getMinimumValue(paramLong);
    }
    return iJulianField.getMinimumValue(paramLong);
  }
  
  public int getMaximumValue(long paramLong)
  {
    if (paramLong >= iCutover) {
      return iGregorianField.getMaximumValue(paramLong);
    }
    return iJulianField.getMaximumValue(paramLong);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJChronology.ImpreciseCutoverField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */