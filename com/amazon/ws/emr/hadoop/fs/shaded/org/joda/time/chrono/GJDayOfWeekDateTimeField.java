package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDurationDateTimeField;
import java.util.Locale;

final class GJDayOfWeekDateTimeField
  extends PreciseDurationDateTimeField
{
  private static final long serialVersionUID = -3857947176719041436L;
  private final BasicChronology iChronology;
  
  GJDayOfWeekDateTimeField(BasicChronology paramBasicChronology, DurationField paramDurationField)
  {
    super(DateTimeFieldType.dayOfWeek(), paramDurationField);
    iChronology = paramBasicChronology;
  }
  
  public int get(long paramLong)
  {
    return iChronology.getDayOfWeek(paramLong);
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).dayOfWeekValueToText(paramInt);
  }
  
  public String getAsShortText(int paramInt, Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).dayOfWeekValueToShortText(paramInt);
  }
  
  protected int convertText(String paramString, Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).dayOfWeekTextToValue(paramString);
  }
  
  public DurationField getRangeDurationField()
  {
    return iChronology.weeks();
  }
  
  public int getMinimumValue()
  {
    return 1;
  }
  
  public int getMaximumValue()
  {
    return 7;
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).getDayOfWeekMaxTextLength();
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).getDayOfWeekMaxShortTextLength();
  }
  
  private Object readResolve()
  {
    return iChronology.dayOfWeek();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJDayOfWeekDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */