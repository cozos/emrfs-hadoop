package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.Locale;

class DateTimeFormatterBuilder$TimeZoneOffset
  implements InternalPrinter, InternalParser
{
  private final String iZeroOffsetPrintText;
  private final String iZeroOffsetParseText;
  private final boolean iShowSeparators;
  private final int iMinFields;
  private final int iMaxFields;
  
  DateTimeFormatterBuilder$TimeZoneOffset(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    iZeroOffsetPrintText = paramString1;
    iZeroOffsetParseText = paramString2;
    iShowSeparators = paramBoolean;
    if ((paramInt1 <= 0) || (paramInt2 < paramInt1)) {
      throw new IllegalArgumentException();
    }
    if (paramInt1 > 4)
    {
      paramInt1 = 4;
      paramInt2 = 4;
    }
    iMinFields = paramInt1;
    iMaxFields = paramInt2;
  }
  
  public int estimatePrintedLength()
  {
    int i = 1 + iMinFields << 1;
    if (iShowSeparators) {
      i += iMinFields - 1;
    }
    if ((iZeroOffsetPrintText != null) && (iZeroOffsetPrintText.length() > i)) {
      i = iZeroOffsetPrintText.length();
    }
    return i;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    if (paramDateTimeZone == null) {
      return;
    }
    if ((paramInt == 0) && (iZeroOffsetPrintText != null))
    {
      paramAppendable.append(iZeroOffsetPrintText);
      return;
    }
    if (paramInt >= 0)
    {
      paramAppendable.append('+');
    }
    else
    {
      paramAppendable.append('-');
      paramInt = -paramInt;
    }
    int i = paramInt / 3600000;
    FormatUtils.appendPaddedInteger(paramAppendable, i, 2);
    if (iMaxFields == 1) {
      return;
    }
    paramInt -= i * 3600000;
    if ((paramInt == 0) && (iMinFields <= 1)) {
      return;
    }
    int j = paramInt / 60000;
    if (iShowSeparators) {
      paramAppendable.append(':');
    }
    FormatUtils.appendPaddedInteger(paramAppendable, j, 2);
    if (iMaxFields == 2) {
      return;
    }
    paramInt -= j * 60000;
    if ((paramInt == 0) && (iMinFields <= 2)) {
      return;
    }
    int k = paramInt / 1000;
    if (iShowSeparators) {
      paramAppendable.append(':');
    }
    FormatUtils.appendPaddedInteger(paramAppendable, k, 2);
    if (iMaxFields == 3) {
      return;
    }
    paramInt -= k * 1000;
    if ((paramInt == 0) && (iMinFields <= 3)) {
      return;
    }
    if (iShowSeparators) {
      paramAppendable.append('.');
    }
    FormatUtils.appendPaddedInteger(paramAppendable, paramInt, 3);
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {}
  
  public int estimateParsedLength()
  {
    return estimatePrintedLength();
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length() - paramInt;
    int j;
    if (iZeroOffsetParseText != null) {
      if (iZeroOffsetParseText.length() == 0)
      {
        if (i > 0)
        {
          j = paramCharSequence.charAt(paramInt);
          if ((j == 45) || (j == 43)) {}
        }
        else
        {
          paramDateTimeParserBucket.setOffset(Integer.valueOf(0));
          return paramInt;
        }
      }
      else if (DateTimeFormatterBuilder.csStartsWithIgnoreCase(paramCharSequence, paramInt, iZeroOffsetParseText))
      {
        paramDateTimeParserBucket.setOffset(Integer.valueOf(0));
        return paramInt + iZeroOffsetParseText.length();
      }
    }
    if (i <= 1) {
      return paramInt ^ 0xFFFFFFFF;
    }
    int k = paramCharSequence.charAt(paramInt);
    if (k == 45) {
      j = 1;
    } else if (k == 43) {
      j = 0;
    } else {
      return paramInt ^ 0xFFFFFFFF;
    }
    i--;
    paramInt++;
    if (digitCount(paramCharSequence, paramInt, 2) < 2) {
      return paramInt ^ 0xFFFFFFFF;
    }
    int m = FormatUtils.parseTwoDigits(paramCharSequence, paramInt);
    if (m > 23) {
      return paramInt ^ 0xFFFFFFFF;
    }
    int n = m * 3600000;
    i -= 2;
    paramInt += 2;
    if (i > 0)
    {
      k = paramCharSequence.charAt(paramInt);
      int i1;
      if (k == 58)
      {
        i1 = 1;
        i--;
        paramInt++;
      }
      else
      {
        if ((k < 48) || (k > 57)) {
          break label569;
        }
        i1 = 0;
      }
      int i2 = digitCount(paramCharSequence, paramInt, 2);
      if ((i2 != 0) || (i1 != 0))
      {
        if (i2 < 2) {
          return paramInt ^ 0xFFFFFFFF;
        }
        int i3 = FormatUtils.parseTwoDigits(paramCharSequence, paramInt);
        if (i3 > 59) {
          return paramInt ^ 0xFFFFFFFF;
        }
        n += i3 * 60000;
        i -= 2;
        paramInt += 2;
        if (i > 0) {
          if (i1 != 0)
          {
            if (paramCharSequence.charAt(paramInt) == ':')
            {
              i--;
              paramInt++;
            }
          }
          else
          {
            i2 = digitCount(paramCharSequence, paramInt, 2);
            if ((i2 != 0) || (i1 != 0))
            {
              if (i2 < 2) {
                return paramInt ^ 0xFFFFFFFF;
              }
              int i4 = FormatUtils.parseTwoDigits(paramCharSequence, paramInt);
              if (i4 > 59) {
                return paramInt ^ 0xFFFFFFFF;
              }
              n += i4 * 1000;
              i -= 2;
              paramInt += 2;
              if (i > 0) {
                if (i1 != 0)
                {
                  if ((paramCharSequence.charAt(paramInt) == '.') || (paramCharSequence.charAt(paramInt) == ','))
                  {
                    i--;
                    paramInt++;
                  }
                }
                else
                {
                  i2 = digitCount(paramCharSequence, paramInt, 3);
                  if ((i2 != 0) || (i1 != 0))
                  {
                    if (i2 < 1) {
                      return paramInt ^ 0xFFFFFFFF;
                    }
                    n += (paramCharSequence.charAt(paramInt++) - '0') * 100;
                    if (i2 > 1)
                    {
                      n += (paramCharSequence.charAt(paramInt++) - '0') * 10;
                      if (i2 > 2) {
                        n += paramCharSequence.charAt(paramInt++) - '0';
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label569:
    paramDateTimeParserBucket.setOffset(Integer.valueOf(j != 0 ? -n : n));
    return paramInt;
  }
  
  private int digitCount(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = Math.min(paramCharSequence.length() - paramInt1, paramInt2);
    paramInt2 = 0;
    for (; i > 0; i--)
    {
      int j = paramCharSequence.charAt(paramInt1 + paramInt2);
      if ((j < 48) || (j > 57)) {
        break;
      }
      paramInt2++;
    }
    return paramInt2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.TimeZoneOffset
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */