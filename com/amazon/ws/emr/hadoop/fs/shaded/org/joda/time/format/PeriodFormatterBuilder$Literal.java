package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

class PeriodFormatterBuilder$Literal
  implements PeriodPrinter, PeriodParser
{
  static final Literal EMPTY = new Literal("");
  private final String iText;
  
  PeriodFormatterBuilder$Literal(String paramString)
  {
    iText = paramString;
  }
  
  public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
  {
    return 0;
  }
  
  public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    return iText.length();
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    paramStringBuffer.append(iText);
  }
  
  public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    throws IOException
  {
    paramWriter.write(iText);
  }
  
  public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
  {
    if (paramString.regionMatches(true, paramInt, iText, 0, iText.length())) {
      return paramInt + iText.length();
    }
    return paramInt ^ 0xFFFFFFFF;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.Literal
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */