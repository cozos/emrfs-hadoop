package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.Locale;

class DateTimeFormatterBuilder$PaddedNumber
  extends DateTimeFormatterBuilder.NumberFormatter
{
  protected final int iMinPrintedDigits;
  
  protected DateTimeFormatterBuilder$PaddedNumber(DateTimeFieldType paramDateTimeFieldType, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super(paramDateTimeFieldType, paramInt1, paramBoolean);
    iMinPrintedDigits = paramInt2;
  }
  
  public int estimatePrintedLength()
  {
    return iMaxParsedDigits;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    try
    {
      DateTimeField localDateTimeField = iFieldType.getField(paramChronology);
      FormatUtils.appendPaddedInteger(paramAppendable, localDateTimeField.get(paramLong), iMinPrintedDigits);
    }
    catch (RuntimeException localRuntimeException)
    {
      DateTimeFormatterBuilder.appendUnknownString(paramAppendable, iMinPrintedDigits);
    }
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    if (paramReadablePartial.isSupported(iFieldType)) {
      try
      {
        FormatUtils.appendPaddedInteger(paramAppendable, paramReadablePartial.get(iFieldType), iMinPrintedDigits);
      }
      catch (RuntimeException localRuntimeException)
      {
        DateTimeFormatterBuilder.appendUnknownString(paramAppendable, iMinPrintedDigits);
      }
    } else {
      DateTimeFormatterBuilder.appendUnknownString(paramAppendable, iMinPrintedDigits);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.PaddedNumber
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */