package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

class PeriodFormat$DynamicWordBased
  implements PeriodPrinter, PeriodParser
{
  private final PeriodFormatter iFormatter;
  
  PeriodFormat$DynamicWordBased(PeriodFormatter paramPeriodFormatter)
  {
    iFormatter = paramPeriodFormatter;
  }
  
  public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
  {
    return getPrinter(paramLocale).countFieldsToPrint(paramReadablePeriod, paramInt, paramLocale);
  }
  
  public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    return getPrinter(paramLocale).calculatePrintedLength(paramReadablePeriod, paramLocale);
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    getPrinter(paramLocale).printTo(paramStringBuffer, paramReadablePeriod, paramLocale);
  }
  
  public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    throws IOException
  {
    getPrinter(paramLocale).printTo(paramWriter, paramReadablePeriod, paramLocale);
  }
  
  private PeriodPrinter getPrinter(Locale paramLocale)
  {
    if ((paramLocale != null) && (!paramLocale.equals(iFormatter.getLocale()))) {
      return PeriodFormat.wordBased(paramLocale).getPrinter();
    }
    return iFormatter.getPrinter();
  }
  
  public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
  {
    return getParser(paramLocale).parseInto(paramReadWritablePeriod, paramString, paramInt, paramLocale);
  }
  
  private PeriodParser getParser(Locale paramLocale)
  {
    if ((paramLocale != null) && (!paramLocale.equals(iFormatter.getLocale()))) {
      return PeriodFormat.wordBased(paramLocale).getParser();
    }
    return iFormatter.getParser();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormat.DynamicWordBased
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */