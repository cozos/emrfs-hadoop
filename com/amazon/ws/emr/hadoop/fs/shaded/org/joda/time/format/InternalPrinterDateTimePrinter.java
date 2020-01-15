package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

class InternalPrinterDateTimePrinter
  implements DateTimePrinter, InternalPrinter
{
  private final InternalPrinter underlying;
  
  static DateTimePrinter of(InternalPrinter paramInternalPrinter)
  {
    if ((paramInternalPrinter instanceof DateTimePrinterInternalPrinter)) {
      return ((DateTimePrinterInternalPrinter)paramInternalPrinter).getUnderlying();
    }
    if ((paramInternalPrinter instanceof DateTimePrinter)) {
      return (DateTimePrinter)paramInternalPrinter;
    }
    if (paramInternalPrinter == null) {
      return null;
    }
    return new InternalPrinterDateTimePrinter(paramInternalPrinter);
  }
  
  private InternalPrinterDateTimePrinter(InternalPrinter paramInternalPrinter)
  {
    underlying = paramInternalPrinter;
  }
  
  public int estimatePrintedLength()
  {
    return underlying.estimatePrintedLength();
  }
  
  public void printTo(StringBuffer paramStringBuffer, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
  {
    try
    {
      underlying.printTo(paramStringBuffer, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
    }
    catch (IOException localIOException) {}
  }
  
  public void printTo(Writer paramWriter, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    underlying.printTo(paramWriter, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    underlying.printTo(paramAppendable, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadablePartial paramReadablePartial, Locale paramLocale)
  {
    try
    {
      underlying.printTo(paramStringBuffer, paramReadablePartial, paramLocale);
    }
    catch (IOException localIOException) {}
  }
  
  public void printTo(Writer paramWriter, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    underlying.printTo(paramWriter, paramReadablePartial, paramLocale);
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    underlying.printTo(paramAppendable, paramReadablePartial, paramLocale);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof InternalPrinterDateTimePrinter))
    {
      InternalPrinterDateTimePrinter localInternalPrinterDateTimePrinter = (InternalPrinterDateTimePrinter)paramObject;
      return underlying.equals(underlying);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.InternalPrinterDateTimePrinter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */