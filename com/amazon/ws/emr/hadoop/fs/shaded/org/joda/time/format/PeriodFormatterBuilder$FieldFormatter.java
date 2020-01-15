package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

class PeriodFormatterBuilder$FieldFormatter
  implements PeriodPrinter, PeriodParser
{
  private final int iMinPrintedDigits;
  private final int iPrintZeroSetting;
  private final int iMaxParsedDigits;
  private final boolean iRejectSignedValues;
  private final int iFieldType;
  private final FieldFormatter[] iFieldFormatters;
  private final PeriodFormatterBuilder.PeriodFieldAffix iPrefix;
  private final PeriodFormatterBuilder.PeriodFieldAffix iSuffix;
  
  PeriodFormatterBuilder$FieldFormatter(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, FieldFormatter[] paramArrayOfFieldFormatter, PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix1, PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix2)
  {
    iMinPrintedDigits = paramInt1;
    iPrintZeroSetting = paramInt2;
    iMaxParsedDigits = paramInt3;
    iRejectSignedValues = paramBoolean;
    iFieldType = paramInt4;
    iFieldFormatters = paramArrayOfFieldFormatter;
    iPrefix = paramPeriodFieldAffix1;
    iSuffix = paramPeriodFieldAffix2;
  }
  
  PeriodFormatterBuilder$FieldFormatter(FieldFormatter paramFieldFormatter, PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix)
  {
    iMinPrintedDigits = iMinPrintedDigits;
    iPrintZeroSetting = iPrintZeroSetting;
    iMaxParsedDigits = iMaxParsedDigits;
    iRejectSignedValues = iRejectSignedValues;
    iFieldType = iFieldType;
    iFieldFormatters = iFieldFormatters;
    iPrefix = iPrefix;
    if (iSuffix != null) {
      paramPeriodFieldAffix = new PeriodFormatterBuilder.CompositeAffix(iSuffix, paramPeriodFieldAffix);
    }
    iSuffix = paramPeriodFieldAffix;
  }
  
  public void finish(FieldFormatter[] paramArrayOfFieldFormatter)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    for (FieldFormatter localFieldFormatter : paramArrayOfFieldFormatter) {
      if ((localFieldFormatter != null) && (!equals(localFieldFormatter)))
      {
        localHashSet1.add(iPrefix);
        localHashSet2.add(iSuffix);
      }
    }
    if (iPrefix != null) {
      iPrefix.finish(localHashSet1);
    }
    if (iSuffix != null) {
      iSuffix.finish(localHashSet2);
    }
  }
  
  public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
  {
    if (paramInt <= 0) {
      return 0;
    }
    if ((iPrintZeroSetting == 4) || (getFieldValue(paramReadablePeriod) != Long.MAX_VALUE)) {
      return 1;
    }
    return 0;
  }
  
  public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    long l = getFieldValue(paramReadablePeriod);
    if (l == Long.MAX_VALUE) {
      return 0;
    }
    int i = Math.max(FormatUtils.calculateDigitCount(l), iMinPrintedDigits);
    if (iFieldType >= 8)
    {
      i = l < 0L ? Math.max(i, 5) : Math.max(i, 4);
      
      i++;
      if ((iFieldType == 9) && (Math.abs(l) % 1000L == 0L)) {
        i -= 4;
      }
      l /= 1000L;
    }
    int j = (int)l;
    if (iPrefix != null) {
      i += iPrefix.calculatePrintedLength(j);
    }
    if (iSuffix != null) {
      i += iSuffix.calculatePrintedLength(j);
    }
    return i;
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    long l = getFieldValue(paramReadablePeriod);
    if (l == Long.MAX_VALUE) {
      return;
    }
    int i = (int)l;
    if (iFieldType >= 8) {
      i = (int)(l / 1000L);
    }
    if (iPrefix != null) {
      iPrefix.printTo(paramStringBuffer, i);
    }
    int j = paramStringBuffer.length();
    int k = iMinPrintedDigits;
    if (k <= 1) {
      FormatUtils.appendUnpaddedInteger(paramStringBuffer, i);
    } else {
      FormatUtils.appendPaddedInteger(paramStringBuffer, i, k);
    }
    if (iFieldType >= 8)
    {
      int m = (int)(Math.abs(l) % 1000L);
      if ((iFieldType == 8) || (m > 0))
      {
        if ((l < 0L) && (l > -1000L)) {
          paramStringBuffer.insert(j, '-');
        }
        paramStringBuffer.append('.');
        FormatUtils.appendPaddedInteger(paramStringBuffer, m, 3);
      }
    }
    if (iSuffix != null) {
      iSuffix.printTo(paramStringBuffer, i);
    }
  }
  
  public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    throws IOException
  {
    long l = getFieldValue(paramReadablePeriod);
    if (l == Long.MAX_VALUE) {
      return;
    }
    int i = (int)l;
    if (iFieldType >= 8) {
      i = (int)(l / 1000L);
    }
    if (iPrefix != null) {
      iPrefix.printTo(paramWriter, i);
    }
    int j = iMinPrintedDigits;
    if (j <= 1) {
      FormatUtils.writeUnpaddedInteger(paramWriter, i);
    } else {
      FormatUtils.writePaddedInteger(paramWriter, i, j);
    }
    if (iFieldType >= 8)
    {
      int k = (int)(Math.abs(l) % 1000L);
      if ((iFieldType == 8) || (k > 0))
      {
        paramWriter.write(46);
        FormatUtils.writePaddedInteger(paramWriter, k, 3);
      }
    }
    if (iSuffix != null) {
      iSuffix.printTo(paramWriter, i);
    }
  }
  
  public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
  {
    int i = iPrintZeroSetting == 4 ? 1 : 0;
    if (paramInt >= paramString.length()) {
      return i != 0 ? paramInt ^ 0xFFFFFFFF : paramInt;
    }
    if (iPrefix != null)
    {
      paramInt = iPrefix.parse(paramString, paramInt);
      if (paramInt >= 0)
      {
        i = 1;
      }
      else
      {
        if (i == 0) {
          return paramInt ^ 0xFFFFFFFF;
        }
        return paramInt;
      }
    }
    int j = -1;
    if ((iSuffix != null) && (i == 0))
    {
      j = iSuffix.scan(paramString, paramInt);
      if (j >= 0)
      {
        i = 1;
      }
      else
      {
        if (i == 0) {
          return j ^ 0xFFFFFFFF;
        }
        return j;
      }
    }
    if ((i == 0) && (!isSupported(paramReadWritablePeriod.getPeriodType(), iFieldType))) {
      return paramInt;
    }
    int k;
    if (j > 0) {
      k = Math.min(iMaxParsedDigits, j - paramInt);
    } else {
      k = Math.min(iMaxParsedDigits, paramString.length() - paramInt);
    }
    int m = 0;
    int n = -1;
    int i1 = 0;
    int i2 = 0;
    int i3;
    while (m < k)
    {
      i3 = paramString.charAt(paramInt + m);
      if ((m == 0) && ((i3 == 45) || (i3 == 43)) && (!iRejectSignedValues))
      {
        i2 = i3 == 45 ? 1 : 0;
        if ((m + 1 >= k) || ((i3 = paramString.charAt(paramInt + m + 1)) < '0') || (i3 > 57)) {
          break;
        }
        if (i2 != 0) {
          m++;
        } else {
          paramInt++;
        }
        k = Math.min(k + 1, paramString.length() - paramInt);
      }
      else
      {
        if ((i3 >= 48) && (i3 <= 57))
        {
          i1 = 1;
        }
        else
        {
          if (((i3 != 46) && (i3 != 44)) || ((iFieldType != 8) && (iFieldType != 9))) {
            break;
          }
          if (n >= 0) {
            break;
          }
          n = paramInt + m + 1;
          
          k = Math.min(k + 1, paramString.length() - paramInt);
        }
        m++;
      }
    }
    if (i1 == 0) {
      return paramInt ^ 0xFFFFFFFF;
    }
    if ((j >= 0) && (paramInt + m != j)) {
      return paramInt;
    }
    if ((iFieldType != 8) && (iFieldType != 9))
    {
      setFieldValue(paramReadWritablePeriod, iFieldType, parseInt(paramString, paramInt, m));
    }
    else if (n < 0)
    {
      setFieldValue(paramReadWritablePeriod, 6, parseInt(paramString, paramInt, m));
      setFieldValue(paramReadWritablePeriod, 7, 0);
    }
    else
    {
      i3 = parseInt(paramString, paramInt, n - paramInt - 1);
      setFieldValue(paramReadWritablePeriod, 6, i3);
      
      int i4 = paramInt + m - n;
      int i5;
      if (i4 <= 0)
      {
        i5 = 0;
      }
      else
      {
        if (i4 >= 3)
        {
          i5 = parseInt(paramString, n, 3);
        }
        else
        {
          i5 = parseInt(paramString, n, i4);
          if (i4 == 1) {
            i5 *= 100;
          } else {
            i5 *= 10;
          }
        }
        if ((i2 != 0) || (i3 < 0)) {
          i5 = -i5;
        }
      }
      setFieldValue(paramReadWritablePeriod, 7, i5);
    }
    paramInt += m;
    if ((paramInt >= 0) && (iSuffix != null)) {
      paramInt = iSuffix.parse(paramString, paramInt);
    }
    return paramInt;
  }
  
  private int parseInt(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 10) {
      return Integer.parseInt(paramString.substring(paramInt1, paramInt1 + paramInt2));
    }
    if (paramInt2 <= 0) {
      return 0;
    }
    int i = paramString.charAt(paramInt1++);
    paramInt2--;
    int j;
    if (i == 45)
    {
      paramInt2--;
      if (paramInt2 < 0) {
        return 0;
      }
      j = 1;
      i = paramString.charAt(paramInt1++);
    }
    else
    {
      j = 0;
    }
    i -= 48;
    while (paramInt2-- > 0) {
      i = (i << 3) + (i << 1) + paramString.charAt(paramInt1++) - 48;
    }
    return j != 0 ? -i : i;
  }
  
  long getFieldValue(ReadablePeriod paramReadablePeriod)
  {
    PeriodType localPeriodType;
    if (iPrintZeroSetting == 4) {
      localPeriodType = null;
    } else {
      localPeriodType = paramReadablePeriod.getPeriodType();
    }
    if ((localPeriodType != null) && (!isSupported(localPeriodType, iFieldType))) {
      return Long.MAX_VALUE;
    }
    long l;
    int i;
    switch (iFieldType)
    {
    default: 
      return Long.MAX_VALUE;
    case 0: 
      l = paramReadablePeriod.get(DurationFieldType.years());
      break;
    case 1: 
      l = paramReadablePeriod.get(DurationFieldType.months());
      break;
    case 2: 
      l = paramReadablePeriod.get(DurationFieldType.weeks());
      break;
    case 3: 
      l = paramReadablePeriod.get(DurationFieldType.days());
      break;
    case 4: 
      l = paramReadablePeriod.get(DurationFieldType.hours());
      break;
    case 5: 
      l = paramReadablePeriod.get(DurationFieldType.minutes());
      break;
    case 6: 
      l = paramReadablePeriod.get(DurationFieldType.seconds());
      break;
    case 7: 
      l = paramReadablePeriod.get(DurationFieldType.millis());
      break;
    case 8: 
    case 9: 
      i = paramReadablePeriod.get(DurationFieldType.seconds());
      int j = paramReadablePeriod.get(DurationFieldType.millis());
      l = i * 1000L + j;
    }
    if (l == 0L) {
      switch (iPrintZeroSetting)
      {
      case 5: 
        return Long.MAX_VALUE;
      case 2: 
        if ((isZero(paramReadablePeriod)) && (iFieldFormatters[iFieldType] == this)) {
          for (i = iFieldType + 1; i <= 9; i++) {
            if ((isSupported(localPeriodType, i)) && (iFieldFormatters[i] != null)) {
              return Long.MAX_VALUE;
            }
          }
        } else {
          return Long.MAX_VALUE;
        }
        break;
      case 1: 
        if ((isZero(paramReadablePeriod)) && (iFieldFormatters[iFieldType] == this))
        {
          i = Math.min(iFieldType, 8);
          i--;
          for (; (i >= 0) && (i <= 9); i--) {
            if ((isSupported(localPeriodType, i)) && (iFieldFormatters[i] != null)) {
              return Long.MAX_VALUE;
            }
          }
        }
        else
        {
          return Long.MAX_VALUE;
        }
        break;
      }
    }
    return l;
  }
  
  boolean isZero(ReadablePeriod paramReadablePeriod)
  {
    int i = 0;
    for (int j = paramReadablePeriod.size(); i < j; i++) {
      if (paramReadablePeriod.getValue(i) != 0) {
        return false;
      }
    }
    return true;
  }
  
  boolean isSupported(PeriodType paramPeriodType, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return paramPeriodType.isSupported(DurationFieldType.years());
    case 1: 
      return paramPeriodType.isSupported(DurationFieldType.months());
    case 2: 
      return paramPeriodType.isSupported(DurationFieldType.weeks());
    case 3: 
      return paramPeriodType.isSupported(DurationFieldType.days());
    case 4: 
      return paramPeriodType.isSupported(DurationFieldType.hours());
    case 5: 
      return paramPeriodType.isSupported(DurationFieldType.minutes());
    case 6: 
      return paramPeriodType.isSupported(DurationFieldType.seconds());
    case 7: 
      return paramPeriodType.isSupported(DurationFieldType.millis());
    }
    return (paramPeriodType.isSupported(DurationFieldType.seconds())) || (paramPeriodType.isSupported(DurationFieldType.millis()));
  }
  
  void setFieldValue(ReadWritablePeriod paramReadWritablePeriod, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      break;
    case 0: 
      paramReadWritablePeriod.setYears(paramInt2);
      break;
    case 1: 
      paramReadWritablePeriod.setMonths(paramInt2);
      break;
    case 2: 
      paramReadWritablePeriod.setWeeks(paramInt2);
      break;
    case 3: 
      paramReadWritablePeriod.setDays(paramInt2);
      break;
    case 4: 
      paramReadWritablePeriod.setHours(paramInt2);
      break;
    case 5: 
      paramReadWritablePeriod.setMinutes(paramInt2);
      break;
    case 6: 
      paramReadWritablePeriod.setSeconds(paramInt2);
      break;
    case 7: 
      paramReadWritablePeriod.setMillis(paramInt2);
    }
  }
  
  int getFieldType()
  {
    return iFieldType;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.FieldFormatter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */