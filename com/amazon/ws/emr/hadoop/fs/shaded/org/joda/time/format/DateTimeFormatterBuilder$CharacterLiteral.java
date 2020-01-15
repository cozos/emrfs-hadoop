package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.Locale;

class DateTimeFormatterBuilder$CharacterLiteral
  implements InternalPrinter, InternalParser
{
  private final char iValue;
  
  DateTimeFormatterBuilder$CharacterLiteral(char paramChar)
  {
    iValue = paramChar;
  }
  
  public int estimatePrintedLength()
  {
    return 1;
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
    return 1;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    if (paramInt >= paramCharSequence.length()) {
      return paramInt ^ 0xFFFFFFFF;
    }
    char c1 = paramCharSequence.charAt(paramInt);
    char c2 = iValue;
    if (c1 != c2)
    {
      c1 = Character.toUpperCase(c1);
      c2 = Character.toUpperCase(c2);
      if (c1 != c2)
      {
        c1 = Character.toLowerCase(c1);
        c2 = Character.toLowerCase(c2);
        if (c1 != c2) {
          return paramInt ^ 0xFFFFFFFF;
        }
      }
    }
    return paramInt + 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.CharacterLiteral
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */