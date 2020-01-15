package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.Locale;

class DateTimeFormatterBuilder$StringLiteral
  implements InternalPrinter, InternalParser
{
  private final String iValue;
  
  DateTimeFormatterBuilder$StringLiteral(String paramString)
  {
    iValue = paramString;
  }
  
  public int estimatePrintedLength()
  {
    return iValue.length();
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    paramAppendable.append(iValue);
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    paramAppendable.append(iValue);
  }
  
  public int estimateParsedLength()
  {
    return iValue.length();
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    if (DateTimeFormatterBuilder.csStartsWithIgnoreCase(paramCharSequence, paramInt, iValue)) {
      return paramInt + iValue.length();
    }
    return paramInt ^ 0xFFFFFFFF;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.StringLiteral
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */