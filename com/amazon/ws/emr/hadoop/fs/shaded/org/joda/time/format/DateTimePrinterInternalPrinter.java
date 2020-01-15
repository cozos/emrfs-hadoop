package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

class DateTimePrinterInternalPrinter
  implements InternalPrinter
{
  private final DateTimePrinter underlying;
  
  static InternalPrinter of(DateTimePrinter paramDateTimePrinter)
  {
    if ((paramDateTimePrinter instanceof InternalPrinterDateTimePrinter)) {
      return (InternalPrinter)paramDateTimePrinter;
    }
    if (paramDateTimePrinter == null) {
      return null;
    }
    return new DateTimePrinterInternalPrinter(paramDateTimePrinter);
  }
  
  private DateTimePrinterInternalPrinter(DateTimePrinter paramDateTimePrinter)
  {
    underlying = paramDateTimePrinter;
  }
  
  DateTimePrinter getUnderlying()
  {
    return underlying;
  }
  
  public int estimatePrintedLength()
  {
    return underlying.estimatePrintedLength();
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    if ((paramAppendable instanceof StringBuffer))
    {
      localObject = (StringBuffer)paramAppendable;
      underlying.printTo((StringBuffer)localObject, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
    }
    if ((paramAppendable instanceof Writer))
    {
      localObject = (Writer)paramAppendable;
      underlying.printTo((Writer)localObject, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
    }
    Object localObject = new StringBuffer(estimatePrintedLength());
    underlying.printTo((StringBuffer)localObject, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
    paramAppendable.append((CharSequence)localObject);
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    if ((paramAppendable instanceof StringBuffer))
    {
      localObject = (StringBuffer)paramAppendable;
      underlying.printTo((StringBuffer)localObject, paramReadablePartial, paramLocale);
    }
    if ((paramAppendable instanceof Writer))
    {
      localObject = (Writer)paramAppendable;
      underlying.printTo((Writer)localObject, paramReadablePartial, paramLocale);
    }
    Object localObject = new StringBuffer(estimatePrintedLength());
    underlying.printTo((StringBuffer)localObject, paramReadablePartial, paramLocale);
    paramAppendable.append((CharSequence)localObject);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimePrinterInternalPrinter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */