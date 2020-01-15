package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDateTimeField;
import java.util.Locale;

class GJChronology$CutoverField
  extends BaseDateTimeField
{
  private static final long serialVersionUID = 3528501219481026402L;
  final DateTimeField iJulianField;
  final DateTimeField iGregorianField;
  final long iCutover;
  final boolean iConvertByWeekyear;
  protected DurationField iDurationField;
  protected DurationField iRangeDurationField;
  
  GJChronology$CutoverField(GJChronology paramGJChronology, DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, long paramLong)
  {
    this(paramGJChronology, paramDateTimeField1, paramDateTimeField2, paramLong, false);
  }
  
  GJChronology$CutoverField(GJChronology paramGJChronology, DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, long paramLong, boolean paramBoolean)
  {
    this(paramGJChronology, paramDateTimeField1, paramDateTimeField2, null, paramLong, paramBoolean);
  }
  
  GJChronology$CutoverField(GJChronology paramGJChronology, DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, DurationField paramDurationField, long paramLong, boolean paramBoolean)
  {
    super(paramDateTimeField2.getType());
    iJulianField = paramDateTimeField1;
    iGregorianField = paramDateTimeField2;
    iCutover = paramLong;
    iConvertByWeekyear = paramBoolean;
    
    iDurationField = paramDateTimeField2.getDurationField();
    if (paramDurationField == null)
    {
      paramDurationField = paramDateTimeField2.getRangeDurationField();
      if (paramDurationField == null) {
        paramDurationField = paramDateTimeField1.getRangeDurationField();
      }
    }
    iRangeDurationField = paramDurationField;
  }
  
  public boolean isLenient()
  {
    return false;
  }
  
  public int get(long paramLong)
  {
    if (paramLong >= iCutover) {
      return iGregorianField.get(paramLong);
    }
    return iJulianField.get(paramLong);
  }
  
  public String getAsText(long paramLong, Locale paramLocale)
  {
    if (paramLong >= iCutover) {
      return iGregorianField.getAsText(paramLong, paramLocale);
    }
    return iJulianField.getAsText(paramLong, paramLocale);
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return iGregorianField.getAsText(paramInt, paramLocale);
  }
  
  public String getAsShortText(long paramLong, Locale paramLocale)
  {
    if (paramLong >= iCutover) {
      return iGregorianField.getAsShortText(paramLong, paramLocale);
    }
    return iJulianField.getAsShortText(paramLong, paramLocale);
  }
  
  public String getAsShortText(int paramInt, Locale paramLocale)
  {
    return iGregorianField.getAsShortText(paramInt, paramLocale);
  }
  
  public long add(long paramLong, int paramInt)
  {
    return iGregorianField.add(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return iGregorianField.add(paramLong1, paramLong2);
  }
  
  public int[] add(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramArrayOfInt;
    }
    if (DateTimeUtils.isContiguous(paramReadablePartial))
    {
      long l = 0L;
      int i = 0;
      for (int j = paramReadablePartial.size(); i < j; i++) {
        l = paramReadablePartial.getFieldType(i).getField(this$0).set(l, paramArrayOfInt[i]);
      }
      l = add(l, paramInt2);
      return this$0.get(paramReadablePartial, l);
    }
    return super.add(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return iGregorianField.getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return iGregorianField.getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public long set(long paramLong, int paramInt)
  {
    if (paramLong >= iCutover)
    {
      paramLong = iGregorianField.set(paramLong, paramInt);
      if (paramLong < iCutover)
      {
        if (paramLong + GJChronology.access$000(this$0) < iCutover) {
          paramLong = gregorianToJulian(paramLong);
        }
        if (get(paramLong) != paramInt) {
          throw new IllegalFieldValueException(iGregorianField.getType(), Integer.valueOf(paramInt), null, null);
        }
      }
    }
    else
    {
      paramLong = iJulianField.set(paramLong, paramInt);
      if (paramLong >= iCutover)
      {
        if (paramLong - GJChronology.access$000(this$0) >= iCutover) {
          paramLong = julianToGregorian(paramLong);
        }
        if (get(paramLong) != paramInt) {
          throw new IllegalFieldValueException(iJulianField.getType(), Integer.valueOf(paramInt), null, null);
        }
      }
    }
    return paramLong;
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    if (paramLong >= iCutover)
    {
      paramLong = iGregorianField.set(paramLong, paramString, paramLocale);
      if (paramLong < iCutover) {
        if (paramLong + GJChronology.access$000(this$0) < iCutover) {
          paramLong = gregorianToJulian(paramLong);
        }
      }
    }
    else
    {
      paramLong = iJulianField.set(paramLong, paramString, paramLocale);
      if (paramLong >= iCutover) {
        if (paramLong - GJChronology.access$000(this$0) >= iCutover) {
          paramLong = julianToGregorian(paramLong);
        }
      }
    }
    return paramLong;
  }
  
  public DurationField getDurationField()
  {
    return iDurationField;
  }
  
  public DurationField getRangeDurationField()
  {
    return iRangeDurationField;
  }
  
  public boolean isLeap(long paramLong)
  {
    if (paramLong >= iCutover) {
      return iGregorianField.isLeap(paramLong);
    }
    return iJulianField.isLeap(paramLong);
  }
  
  public int getLeapAmount(long paramLong)
  {
    if (paramLong >= iCutover) {
      return iGregorianField.getLeapAmount(paramLong);
    }
    return iJulianField.getLeapAmount(paramLong);
  }
  
  public DurationField getLeapDurationField()
  {
    return iGregorianField.getLeapDurationField();
  }
  
  public int getMinimumValue()
  {
    return iJulianField.getMinimumValue();
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial)
  {
    return iJulianField.getMinimumValue(paramReadablePartial);
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    return iJulianField.getMinimumValue(paramReadablePartial, paramArrayOfInt);
  }
  
  public int getMinimumValue(long paramLong)
  {
    if (paramLong < iCutover) {
      return iJulianField.getMinimumValue(paramLong);
    }
    int i = iGregorianField.getMinimumValue(paramLong);
    
    paramLong = iGregorianField.set(paramLong, i);
    if (paramLong < iCutover) {
      i = iGregorianField.get(iCutover);
    }
    return i;
  }
  
  public int getMaximumValue()
  {
    return iGregorianField.getMaximumValue();
  }
  
  public int getMaximumValue(long paramLong)
  {
    if (paramLong >= iCutover) {
      return iGregorianField.getMaximumValue(paramLong);
    }
    int i = iJulianField.getMaximumValue(paramLong);
    
    paramLong = iJulianField.set(paramLong, i);
    if (paramLong >= iCutover) {
      i = iJulianField.get(iJulianField.add(iCutover, -1));
    }
    return i;
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial)
  {
    long l = GJChronology.getInstanceUTC().set(paramReadablePartial, 0L);
    return getMaximumValue(l);
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    GJChronology localGJChronology = GJChronology.getInstanceUTC();
    long l = 0L;
    int i = 0;
    for (int j = paramReadablePartial.size(); i < j; i++)
    {
      DateTimeField localDateTimeField = paramReadablePartial.getFieldType(i).getField(localGJChronology);
      if (paramArrayOfInt[i] <= localDateTimeField.getMaximumValue(l)) {
        l = localDateTimeField.set(l, paramArrayOfInt[i]);
      }
    }
    return getMaximumValue(l);
  }
  
  public long roundFloor(long paramLong)
  {
    if (paramLong >= iCutover)
    {
      paramLong = iGregorianField.roundFloor(paramLong);
      if (paramLong < iCutover) {
        if (paramLong + GJChronology.access$000(this$0) < iCutover) {
          paramLong = gregorianToJulian(paramLong);
        }
      }
    }
    else
    {
      paramLong = iJulianField.roundFloor(paramLong);
    }
    return paramLong;
  }
  
  public long roundCeiling(long paramLong)
  {
    if (paramLong >= iCutover)
    {
      paramLong = iGregorianField.roundCeiling(paramLong);
    }
    else
    {
      paramLong = iJulianField.roundCeiling(paramLong);
      if (paramLong >= iCutover) {
        if (paramLong - GJChronology.access$000(this$0) >= iCutover) {
          paramLong = julianToGregorian(paramLong);
        }
      }
    }
    return paramLong;
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return Math.max(iJulianField.getMaximumTextLength(paramLocale), iGregorianField.getMaximumTextLength(paramLocale));
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    return Math.max(iJulianField.getMaximumShortTextLength(paramLocale), iGregorianField.getMaximumShortTextLength(paramLocale));
  }
  
  protected long julianToGregorian(long paramLong)
  {
    if (iConvertByWeekyear) {
      return this$0.julianToGregorianByWeekyear(paramLong);
    }
    return this$0.julianToGregorianByYear(paramLong);
  }
  
  protected long gregorianToJulian(long paramLong)
  {
    if (iConvertByWeekyear) {
      return this$0.gregorianToJulianByWeekyear(paramLong);
    }
    return this$0.gregorianToJulianByYear(paramLong);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJChronology.CutoverField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */