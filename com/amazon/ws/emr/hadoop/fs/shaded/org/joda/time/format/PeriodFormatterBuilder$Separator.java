package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.TreeSet;

class PeriodFormatterBuilder$Separator
  implements PeriodPrinter, PeriodParser
{
  private final String iText;
  private final String iFinalText;
  private final String[] iParsedForms;
  private final boolean iUseBefore;
  private final boolean iUseAfter;
  private final PeriodPrinter iBeforePrinter;
  private volatile PeriodPrinter iAfterPrinter;
  private final PeriodParser iBeforeParser;
  private volatile PeriodParser iAfterParser;
  
  PeriodFormatterBuilder$Separator(String paramString1, String paramString2, String[] paramArrayOfString, PeriodPrinter paramPeriodPrinter, PeriodParser paramPeriodParser, boolean paramBoolean1, boolean paramBoolean2)
  {
    iText = paramString1;
    iFinalText = paramString2;
    if (((paramString2 == null) || (paramString1.equals(paramString2))) && ((paramArrayOfString == null) || (paramArrayOfString.length == 0)))
    {
      iParsedForms = new String[] { paramString1 };
    }
    else
    {
      TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
      localTreeSet.add(paramString1);
      localTreeSet.add(paramString2);
      if (paramArrayOfString != null)
      {
        int i = paramArrayOfString.length;
        for (;;)
        {
          i--;
          if (i < 0) {
            break;
          }
          localTreeSet.add(paramArrayOfString[i]);
        }
      }
      ArrayList localArrayList = new ArrayList(localTreeSet);
      Collections.reverse(localArrayList);
      iParsedForms = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
    }
    iBeforePrinter = paramPeriodPrinter;
    iBeforeParser = paramPeriodParser;
    iUseBefore = paramBoolean1;
    iUseAfter = paramBoolean2;
  }
  
  public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
  {
    int i = iBeforePrinter.countFieldsToPrint(paramReadablePeriod, paramInt, paramLocale);
    if (i < paramInt) {
      i += iAfterPrinter.countFieldsToPrint(paramReadablePeriod, paramInt, paramLocale);
    }
    return i;
  }
  
  public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    PeriodPrinter localPeriodPrinter1 = iBeforePrinter;
    PeriodPrinter localPeriodPrinter2 = iAfterPrinter;
    
    int i = localPeriodPrinter1.calculatePrintedLength(paramReadablePeriod, paramLocale) + localPeriodPrinter2.calculatePrintedLength(paramReadablePeriod, paramLocale);
    if (iUseBefore)
    {
      if (localPeriodPrinter1.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0) {
        if (iUseAfter)
        {
          int j = localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 2, paramLocale);
          if (j > 0) {
            i += (j > 1 ? iText : iFinalText).length();
          }
        }
        else
        {
          i += iText.length();
        }
      }
    }
    else if ((iUseAfter) && (localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0)) {
      i += iText.length();
    }
    return i;
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    PeriodPrinter localPeriodPrinter1 = iBeforePrinter;
    PeriodPrinter localPeriodPrinter2 = iAfterPrinter;
    
    localPeriodPrinter1.printTo(paramStringBuffer, paramReadablePeriod, paramLocale);
    if (iUseBefore)
    {
      if (localPeriodPrinter1.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0) {
        if (iUseAfter)
        {
          int i = localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 2, paramLocale);
          if (i > 0) {
            paramStringBuffer.append(i > 1 ? iText : iFinalText);
          }
        }
        else
        {
          paramStringBuffer.append(iText);
        }
      }
    }
    else if ((iUseAfter) && (localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0)) {
      paramStringBuffer.append(iText);
    }
    localPeriodPrinter2.printTo(paramStringBuffer, paramReadablePeriod, paramLocale);
  }
  
  public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    throws IOException
  {
    PeriodPrinter localPeriodPrinter1 = iBeforePrinter;
    PeriodPrinter localPeriodPrinter2 = iAfterPrinter;
    
    localPeriodPrinter1.printTo(paramWriter, paramReadablePeriod, paramLocale);
    if (iUseBefore)
    {
      if (localPeriodPrinter1.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0) {
        if (iUseAfter)
        {
          int i = localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 2, paramLocale);
          if (i > 0) {
            paramWriter.write(i > 1 ? iText : iFinalText);
          }
        }
        else
        {
          paramWriter.write(iText);
        }
      }
    }
    else if ((iUseAfter) && (localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0)) {
      paramWriter.write(iText);
    }
    localPeriodPrinter2.printTo(paramWriter, paramReadablePeriod, paramLocale);
  }
  
  public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
  {
    int i = paramInt;
    paramInt = iBeforeParser.parseInto(paramReadWritablePeriod, paramString, paramInt, paramLocale);
    if (paramInt < 0) {
      return paramInt;
    }
    int j = 0;
    int k = -1;
    if (paramInt > i)
    {
      String[] arrayOfString = iParsedForms;
      int m = arrayOfString.length;
      for (int n = 0; n < m; n++)
      {
        String str = arrayOfString[n];
        if ((str == null) || (str.length() == 0) || (paramString.regionMatches(true, paramInt, str, 0, str.length())))
        {
          k = str == null ? 0 : str.length();
          paramInt += k;
          j = 1;
          break;
        }
      }
    }
    i = paramInt;
    paramInt = iAfterParser.parseInto(paramReadWritablePeriod, paramString, paramInt, paramLocale);
    if (paramInt < 0) {
      return paramInt;
    }
    if ((j != 0) && (paramInt == i) && (k > 0)) {
      return i ^ 0xFFFFFFFF;
    }
    if ((paramInt > i) && (j == 0) && (!iUseBefore)) {
      return i ^ 0xFFFFFFFF;
    }
    return paramInt;
  }
  
  Separator finish(PeriodPrinter paramPeriodPrinter, PeriodParser paramPeriodParser)
  {
    iAfterPrinter = paramPeriodPrinter;
    iAfterParser = paramPeriodParser;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.Separator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */