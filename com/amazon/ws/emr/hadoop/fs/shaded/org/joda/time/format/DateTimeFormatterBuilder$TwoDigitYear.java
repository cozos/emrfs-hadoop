package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.Locale;

class DateTimeFormatterBuilder$TwoDigitYear
  implements InternalPrinter, InternalParser
{
  private final DateTimeFieldType iType;
  private final int iPivot;
  private final boolean iLenientParse;
  
  DateTimeFormatterBuilder$TwoDigitYear(DateTimeFieldType paramDateTimeFieldType, int paramInt, boolean paramBoolean)
  {
    iType = paramDateTimeFieldType;
    iPivot = paramInt;
    iLenientParse = paramBoolean;
  }
  
  public int estimateParsedLength()
  {
    return iLenientParse ? 4 : 2;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length() - paramInt;
    int i1;
    if (!iLenientParse)
    {
      i = Math.min(2, i);
      if (i < 2) {
        return paramInt ^ 0xFFFFFFFF;
      }
    }
    else
    {
      j = 0;
      k = 0;
      m = 0;
      while (m < i)
      {
        n = paramCharSequence.charAt(paramInt + m);
        if ((m == 0) && ((n == 45) || (n == 43)))
        {
          j = 1;
          k = n == 45 ? 1 : 0;
          if (k != 0)
          {
            m++;
          }
          else
          {
            paramInt++;
            i--;
          }
        }
        else
        {
          if ((n < 48) || (n > 57)) {
            break;
          }
          m++;
        }
      }
      if (m == 0) {
        return paramInt ^ 0xFFFFFFFF;
      }
      if ((j != 0) || (m != 2))
      {
        if (m >= 9)
        {
          n = Integer.parseInt(paramCharSequence.subSequence(paramInt, paramInt += m).toString());
        }
        else
        {
          i1 = paramInt;
          if (k != 0) {
            i1++;
          }
          try
          {
            n = paramCharSequence.charAt(i1++) - '0';
          }
          catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
          {
            return paramInt ^ 0xFFFFFFFF;
          }
          paramInt += m;
          while (i1 < paramInt) {
            n = (n << 3) + (n << 1) + paramCharSequence.charAt(i1++) - 48;
          }
          if (k != 0) {
            n = -n;
          }
        }
        paramDateTimeParserBucket.saveField(iType, n);
        return paramInt;
      }
    }
    int k = paramCharSequence.charAt(paramInt);
    if ((k < 48) || (k > 57)) {
      return paramInt ^ 0xFFFFFFFF;
    }
    int j = k - 48;
    k = paramCharSequence.charAt(paramInt + 1);
    if ((k < 48) || (k > 57)) {
      return paramInt ^ 0xFFFFFFFF;
    }
    j = (j << 3) + (j << 1) + k - 48;
    
    int m = iPivot;
    if (paramDateTimeParserBucket.getPivotYear() != null) {
      m = paramDateTimeParserBucket.getPivotYear().intValue();
    }
    int n = m - 50;
    if (n >= 0) {
      i1 = n % 100;
    } else {
      i1 = 99 + (n + 1) % 100;
    }
    j += n + (j < i1 ? 100 : 0) - i1;
    
    paramDateTimeParserBucket.saveField(iType, j);
    return paramInt + 2;
  }
  
  public int estimatePrintedLength()
  {
    return 2;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    int i = getTwoDigitYear(paramLong, paramChronology);
    if (i < 0)
    {
      paramAppendable.append(65533);
      paramAppendable.append(65533);
    }
    else
    {
      FormatUtils.appendPaddedInteger(paramAppendable, i, 2);
    }
  }
  
  private int getTwoDigitYear(long paramLong, Chronology paramChronology)
  {
    try
    {
      int i = iType.getField(paramChronology).get(paramLong);
      if (i < 0) {
        i = -i;
      }
      return i % 100;
    }
    catch (RuntimeException localRuntimeException) {}
    return -1;
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    int i = getTwoDigitYear(paramReadablePartial);
    if (i < 0)
    {
      paramAppendable.append(65533);
      paramAppendable.append(65533);
    }
    else
    {
      FormatUtils.appendPaddedInteger(paramAppendable, i, 2);
    }
  }
  
  private int getTwoDigitYear(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial.isSupported(iType)) {
      try
      {
        int i = paramReadablePartial.get(iType);
        if (i < 0) {
          i = -i;
        }
        return i % 100;
      }
      catch (RuntimeException localRuntimeException) {}
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.TwoDigitYear
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */