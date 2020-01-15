package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

class PeriodFormatterBuilder$CompositeAffix
  extends PeriodFormatterBuilder.IgnorableAffix
{
  private final PeriodFormatterBuilder.PeriodFieldAffix iLeft;
  private final PeriodFormatterBuilder.PeriodFieldAffix iRight;
  private final String[] iLeftRightCombinations;
  
  PeriodFormatterBuilder$CompositeAffix(PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix1, PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix2)
  {
    iLeft = paramPeriodFieldAffix1;
    iRight = paramPeriodFieldAffix2;
    
    HashSet localHashSet = new HashSet();
    for (String str1 : iLeft.getAffixes()) {
      for (String str2 : iRight.getAffixes()) {
        localHashSet.add(str1 + str2);
      }
    }
    iLeftRightCombinations = ((String[])localHashSet.toArray(new String[localHashSet.size()]));
  }
  
  public int calculatePrintedLength(int paramInt)
  {
    return iLeft.calculatePrintedLength(paramInt) + iRight.calculatePrintedLength(paramInt);
  }
  
  public void printTo(StringBuffer paramStringBuffer, int paramInt)
  {
    iLeft.printTo(paramStringBuffer, paramInt);
    iRight.printTo(paramStringBuffer, paramInt);
  }
  
  public void printTo(Writer paramWriter, int paramInt)
    throws IOException
  {
    iLeft.printTo(paramWriter, paramInt);
    iRight.printTo(paramWriter, paramInt);
  }
  
  public int parse(String paramString, int paramInt)
  {
    int i = iLeft.parse(paramString, paramInt);
    if (i >= 0)
    {
      i = iRight.parse(paramString, i);
      if ((i >= 0) && (matchesOtherAffix(parse(paramString, i) - i, paramString, paramInt))) {
        return paramInt ^ 0xFFFFFFFF;
      }
    }
    return i;
  }
  
  public int scan(String paramString, int paramInt)
  {
    int i = iLeft.scan(paramString, paramInt);
    if (i >= 0)
    {
      int j = iRight.scan(paramString, iLeft.parse(paramString, i));
      if ((j < 0) || (!matchesOtherAffix(iRight.parse(paramString, j) - i, paramString, paramInt)))
      {
        if (i > 0) {
          return i;
        }
        return j;
      }
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public String[] getAffixes()
  {
    return (String[])iLeftRightCombinations.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.CompositeAffix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */