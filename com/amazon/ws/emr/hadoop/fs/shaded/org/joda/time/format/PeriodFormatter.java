package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

public class PeriodFormatter
{
  private final PeriodPrinter iPrinter;
  private final PeriodParser iParser;
  private final Locale iLocale;
  private final PeriodType iParseType;
  
  public PeriodFormatter(PeriodPrinter paramPeriodPrinter, PeriodParser paramPeriodParser)
  {
    iPrinter = paramPeriodPrinter;
    iParser = paramPeriodParser;
    iLocale = null;
    iParseType = null;
  }
  
  PeriodFormatter(PeriodPrinter paramPeriodPrinter, PeriodParser paramPeriodParser, Locale paramLocale, PeriodType paramPeriodType)
  {
    iPrinter = paramPeriodPrinter;
    iParser = paramPeriodParser;
    iLocale = paramLocale;
    iParseType = paramPeriodType;
  }
  
  public boolean isPrinter()
  {
    return iPrinter != null;
  }
  
  public PeriodPrinter getPrinter()
  {
    return iPrinter;
  }
  
  public boolean isParser()
  {
    return iParser != null;
  }
  
  public PeriodParser getParser()
  {
    return iParser;
  }
  
  public PeriodFormatter withLocale(Locale paramLocale)
  {
    if ((paramLocale == getLocale()) || ((paramLocale != null) && (paramLocale.equals(getLocale())))) {
      return this;
    }
    return new PeriodFormatter(iPrinter, iParser, paramLocale, iParseType);
  }
  
  public Locale getLocale()
  {
    return iLocale;
  }
  
  public PeriodFormatter withParseType(PeriodType paramPeriodType)
  {
    if (paramPeriodType == iParseType) {
      return this;
    }
    return new PeriodFormatter(iPrinter, iParser, iLocale, paramPeriodType);
  }
  
  public PeriodType getParseType()
  {
    return iParseType;
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod)
  {
    checkPrinter();
    checkPeriod(paramReadablePeriod);
    
    getPrinter().printTo(paramStringBuffer, paramReadablePeriod, iLocale);
  }
  
  public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod)
    throws IOException
  {
    checkPrinter();
    checkPeriod(paramReadablePeriod);
    
    getPrinter().printTo(paramWriter, paramReadablePeriod, iLocale);
  }
  
  public String print(ReadablePeriod paramReadablePeriod)
  {
    checkPrinter();
    checkPeriod(paramReadablePeriod);
    
    PeriodPrinter localPeriodPrinter = getPrinter();
    StringBuffer localStringBuffer = new StringBuffer(localPeriodPrinter.calculatePrintedLength(paramReadablePeriod, iLocale));
    localPeriodPrinter.printTo(localStringBuffer, paramReadablePeriod, iLocale);
    return localStringBuffer.toString();
  }
  
  private void checkPrinter()
  {
    if (iPrinter == null) {
      throw new UnsupportedOperationException("Printing not supported");
    }
  }
  
  private void checkPeriod(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      throw new IllegalArgumentException("Period must not be null");
    }
  }
  
  public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt)
  {
    checkParser();
    checkPeriod(paramReadWritablePeriod);
    
    return getParser().parseInto(paramReadWritablePeriod, paramString, paramInt, iLocale);
  }
  
  public Period parsePeriod(String paramString)
  {
    checkParser();
    
    return parseMutablePeriod(paramString).toPeriod();
  }
  
  public MutablePeriod parseMutablePeriod(String paramString)
  {
    checkParser();
    
    MutablePeriod localMutablePeriod = new MutablePeriod(0L, iParseType);
    int i = getParser().parseInto(localMutablePeriod, paramString, 0, iLocale);
    if (i >= 0)
    {
      if (i >= paramString.length()) {
        return localMutablePeriod;
      }
    }
    else {
      i ^= 0xFFFFFFFF;
    }
    throw new IllegalArgumentException(FormatUtils.createErrorMessage(paramString, i));
  }
  
  private void checkParser()
  {
    if (iParser == null) {
      throw new UnsupportedOperationException("Parsing not supported");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */