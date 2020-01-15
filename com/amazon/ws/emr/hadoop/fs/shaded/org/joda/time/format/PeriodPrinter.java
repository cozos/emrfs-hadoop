package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

public abstract interface PeriodPrinter
{
  public abstract int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale);
  
  public abstract int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale);
  
  public abstract void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale);
  
  public abstract void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodPrinter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */