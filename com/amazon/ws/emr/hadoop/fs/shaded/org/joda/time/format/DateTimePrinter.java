package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

public abstract interface DateTimePrinter
{
  public abstract int estimatePrintedLength();
  
  public abstract void printTo(StringBuffer paramStringBuffer, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale);
  
  public abstract void printTo(Writer paramWriter, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException;
  
  public abstract void printTo(StringBuffer paramStringBuffer, ReadablePartial paramReadablePartial, Locale paramLocale);
  
  public abstract void printTo(Writer paramWriter, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimePrinter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */