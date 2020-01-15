package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.UnsupportedDurationField;
import java.util.Locale;

final class GJEraDateTimeField
  extends BaseDateTimeField
{
  private static final long serialVersionUID = 4240986525305515528L;
  private final BasicChronology iChronology;
  
  GJEraDateTimeField(BasicChronology paramBasicChronology)
  {
    super(DateTimeFieldType.era());
    iChronology = paramBasicChronology;
  }
  
  public boolean isLenient()
  {
    return false;
  }
  
  public int get(long paramLong)
  {
    if (iChronology.getYear(paramLong) <= 0) {
      return 0;
    }
    return 1;
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).eraValueToText(paramInt);
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, 0, 1);
    
    int i = get(paramLong);
    if (i != paramInt)
    {
      int j = iChronology.getYear(paramLong);
      return iChronology.setYear(paramLong, -j);
    }
    return paramLong;
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    return set(paramLong, GJLocaleSymbols.forLocale(paramLocale).eraTextToValue(paramString));
  }
  
  public long roundFloor(long paramLong)
  {
    if (get(paramLong) == 1) {
      return iChronology.setYear(0L, 1);
    }
    return Long.MIN_VALUE;
  }
  
  public long roundCeiling(long paramLong)
  {
    if (get(paramLong) == 0) {
      return iChronology.setYear(0L, 1);
    }
    return Long.MAX_VALUE;
  }
  
  public long roundHalfFloor(long paramLong)
  {
    return roundFloor(paramLong);
  }
  
  public long roundHalfCeiling(long paramLong)
  {
    return roundFloor(paramLong);
  }
  
  public long roundHalfEven(long paramLong)
  {
    return roundFloor(paramLong);
  }
  
  public DurationField getDurationField()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.eras());
  }
  
  public DurationField getRangeDurationField()
  {
    return null;
  }
  
  public int getMinimumValue()
  {
    return 0;
  }
  
  public int getMaximumValue()
  {
    return 1;
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).getEraMaxTextLength();
  }
  
  private Object readResolve()
  {
    return iChronology.era();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJEraDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */