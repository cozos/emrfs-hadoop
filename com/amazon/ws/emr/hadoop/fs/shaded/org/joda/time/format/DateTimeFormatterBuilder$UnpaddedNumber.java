package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.Locale;

class DateTimeFormatterBuilder$UnpaddedNumber
  extends DateTimeFormatterBuilder.NumberFormatter
{
  protected DateTimeFormatterBuilder$UnpaddedNumber(DateTimeFieldType paramDateTimeFieldType, int paramInt, boolean paramBoolean)
  {
    super(paramDateTimeFieldType, paramInt, paramBoolean);
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
      FormatUtils.appendUnpaddedInteger(paramAppendable, localDateTimeField.get(paramLong));
    }
    catch (RuntimeException localRuntimeException)
    {
      paramAppendable.append(65533);
    }
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    if (paramReadablePartial.isSupported(iFieldType)) {
      try
      {
        FormatUtils.appendUnpaddedInteger(paramAppendable, paramReadablePartial.get(iFieldType));
      }
      catch (RuntimeException localRuntimeException)
      {
        paramAppendable.append(65533);
      }
    } else {
      paramAppendable.append(65533);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.UnpaddedNumber
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */