package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.MillisDurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDateTimeField;
import java.io.IOException;
import java.util.Locale;

class DateTimeFormatterBuilder$Fraction
  implements InternalPrinter, InternalParser
{
  private final DateTimeFieldType iFieldType;
  protected int iMinDigits;
  protected int iMaxDigits;
  
  protected DateTimeFormatterBuilder$Fraction(DateTimeFieldType paramDateTimeFieldType, int paramInt1, int paramInt2)
  {
    iFieldType = paramDateTimeFieldType;
    if (paramInt2 > 18) {
      paramInt2 = 18;
    }
    iMinDigits = paramInt1;
    iMaxDigits = paramInt2;
  }
  
  public int estimatePrintedLength()
  {
    return iMaxDigits;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    printTo(paramAppendable, paramLong, paramChronology);
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    long l = paramReadablePartial.getChronology().set(paramReadablePartial, 0L);
    printTo(paramAppendable, l, paramReadablePartial.getChronology());
  }
  
  protected void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology)
    throws IOException
  {
    DateTimeField localDateTimeField = iFieldType.getField(paramChronology);
    int i = iMinDigits;
    long l1;
    try
    {
      l1 = localDateTimeField.remainder(paramLong);
    }
    catch (RuntimeException localRuntimeException)
    {
      DateTimeFormatterBuilder.appendUnknownString(paramAppendable, i);
      return;
    }
    if (l1 == 0L)
    {
      for (;;)
      {
        i--;
        if (i < 0) {
          break;
        }
        paramAppendable.append('0');
      }
      return;
    }
    long[] arrayOfLong = getFractionData(l1, localDateTimeField);
    long l2 = arrayOfLong[0];
    int j = (int)arrayOfLong[1];
    String str;
    if ((l2 & 0x7FFFFFFF) == l2) {
      str = Integer.toString((int)l2);
    } else {
      str = Long.toString(l2);
    }
    int k = str.length();
    int m = j;
    while (k < m)
    {
      paramAppendable.append('0');
      i--;
      m--;
    }
    if (i < m)
    {
      while ((i < m) && 
        (k > 1) && (str.charAt(k - 1) == '0'))
      {
        m--;
        k--;
      }
      if (k < str.length())
      {
        for (int n = 0; n < k; n++) {
          paramAppendable.append(str.charAt(n));
        }
        return;
      }
    }
    paramAppendable.append(str);
  }
  
  private long[] getFractionData(long paramLong, DateTimeField paramDateTimeField)
  {
    long l1 = paramDateTimeField.getDurationField().getUnitMillis();
    
    int i = iMaxDigits;
    long l2;
    for (;;)
    {
      switch (i)
      {
      default: 
        l2 = 1L; break;
      case 1: 
        l2 = 10L; break;
      case 2: 
        l2 = 100L; break;
      case 3: 
        l2 = 1000L; break;
      case 4: 
        l2 = 10000L; break;
      case 5: 
        l2 = 100000L; break;
      case 6: 
        l2 = 1000000L; break;
      case 7: 
        l2 = 10000000L; break;
      case 8: 
        l2 = 100000000L; break;
      case 9: 
        l2 = 1000000000L; break;
      case 10: 
        l2 = 10000000000L; break;
      case 11: 
        l2 = 100000000000L; break;
      case 12: 
        l2 = 1000000000000L; break;
      case 13: 
        l2 = 10000000000000L; break;
      case 14: 
        l2 = 100000000000000L; break;
      case 15: 
        l2 = 1000000000000000L; break;
      case 16: 
        l2 = 10000000000000000L; break;
      case 17: 
        l2 = 100000000000000000L; break;
      case 18: 
        l2 = 1000000000000000000L;
      }
      if (l1 * l2 / l2 == l1) {
        break;
      }
      i--;
    }
    return new long[] { paramLong * l2 / l1, i };
  }
  
  public int estimateParsedLength()
  {
    return iMaxDigits;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    DateTimeField localDateTimeField = iFieldType.getField(paramDateTimeParserBucket.getChronology());
    
    int i = Math.min(iMaxDigits, paramCharSequence.length() - paramInt);
    
    long l1 = 0L;
    long l2 = localDateTimeField.getDurationField().getUnitMillis() * 10L;
    int j = 0;
    while (j < i)
    {
      int k = paramCharSequence.charAt(paramInt + j);
      if ((k < 48) || (k > 57)) {
        break;
      }
      j++;
      long l3 = l2 / 10L;
      l1 += (k - 48) * l3;
      l2 = l3;
    }
    l1 /= 10L;
    if (j == 0) {
      return paramInt ^ 0xFFFFFFFF;
    }
    if (l1 > 2147483647L) {
      return paramInt ^ 0xFFFFFFFF;
    }
    PreciseDateTimeField localPreciseDateTimeField = new PreciseDateTimeField(DateTimeFieldType.millisOfSecond(), MillisDurationField.INSTANCE, localDateTimeField.getDurationField());
    
    paramDateTimeParserBucket.saveField(localPreciseDateTimeField, (int)l1);
    
    return paramInt + j;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.Fraction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */