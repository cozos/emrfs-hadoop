package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;

abstract class DateTimeFormatterBuilder$NumberFormatter
  implements InternalPrinter, InternalParser
{
  protected final DateTimeFieldType iFieldType;
  protected final int iMaxParsedDigits;
  protected final boolean iSigned;
  
  DateTimeFormatterBuilder$NumberFormatter(DateTimeFieldType paramDateTimeFieldType, int paramInt, boolean paramBoolean)
  {
    iFieldType = paramDateTimeFieldType;
    iMaxParsedDigits = paramInt;
    iSigned = paramBoolean;
  }
  
  public int estimateParsedLength()
  {
    return iMaxParsedDigits;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    int i = Math.min(iMaxParsedDigits, paramCharSequence.length() - paramInt);
    
    int j = 0;
    int k = 0;
    int m = 0;
    int n;
    while (m < i)
    {
      n = paramCharSequence.charAt(paramInt + m);
      if ((m == 0) && ((n == 45) || (n == 43)) && (iSigned))
      {
        j = n == 45 ? 1 : 0;
        k = n == 43 ? 1 : 0;
        if ((m + 1 >= i) || ((n = paramCharSequence.charAt(paramInt + m + 1)) < '0') || (n > 57)) {
          break;
        }
        m++;
        
        i = Math.min(i + 1, paramCharSequence.length() - paramInt);
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
    if (m >= 9)
    {
      if (k != 0) {
        n = Integer.parseInt(paramCharSequence.subSequence(paramInt + 1, paramInt += m).toString());
      } else {
        n = Integer.parseInt(paramCharSequence.subSequence(paramInt, paramInt += m).toString());
      }
    }
    else
    {
      int i1 = paramInt;
      if ((j != 0) || (k != 0)) {
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
      if (j != 0) {
        n = -n;
      }
    }
    paramDateTimeParserBucket.saveField(iFieldType, n);
    return paramInt;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.NumberFormatter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */