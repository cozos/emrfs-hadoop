package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

abstract interface PeriodFormatterBuilder$PeriodFieldAffix
{
  public abstract int calculatePrintedLength(int paramInt);
  
  public abstract void printTo(StringBuffer paramStringBuffer, int paramInt);
  
  public abstract void printTo(Writer paramWriter, int paramInt)
    throws IOException;
  
  public abstract int parse(String paramString, int paramInt);
  
  public abstract int scan(String paramString, int paramInt);
  
  public abstract String[] getAffixes();
  
  public abstract void finish(Set<PeriodFieldAffix> paramSet);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */