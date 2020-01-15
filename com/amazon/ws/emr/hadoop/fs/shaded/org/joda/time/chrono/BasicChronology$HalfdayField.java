package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDateTimeField;
import java.util.Locale;

class BasicChronology$HalfdayField
  extends PreciseDateTimeField
{
  private static final long serialVersionUID = 581601443656929254L;
  
  BasicChronology$HalfdayField()
  {
    super(DateTimeFieldType.halfdayOfDay(), BasicChronology.access$000(), BasicChronology.access$100());
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).halfdayValueToText(paramInt);
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    return set(paramLong, GJLocaleSymbols.forLocale(paramLocale).halfdayTextToValue(paramString));
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).getHalfdayMaxTextLength();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicChronology.HalfdayField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */