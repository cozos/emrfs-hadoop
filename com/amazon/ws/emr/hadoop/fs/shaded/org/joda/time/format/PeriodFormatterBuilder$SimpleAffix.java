package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import java.io.IOException;
import java.io.Writer;

class PeriodFormatterBuilder$SimpleAffix
  extends PeriodFormatterBuilder.IgnorableAffix
{
  private final String iText;
  
  PeriodFormatterBuilder$SimpleAffix(String paramString)
  {
    iText = paramString;
  }
  
  public int calculatePrintedLength(int paramInt)
  {
    return iText.length();
  }
  
  public void printTo(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(iText);
  }
  
  public void printTo(Writer paramWriter, int paramInt)
    throws IOException
  {
    paramWriter.write(iText);
  }
  
  public int parse(String paramString, int paramInt)
  {
    String str = iText;
    int i = str.length();
    if ((paramString.regionMatches(true, paramInt, str, 0, i)) && 
      (!matchesOtherAffix(i, paramString, paramInt))) {
      return paramInt + i;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public int scan(String paramString, int paramInt)
  {
    String str = iText;
    int i = str.length();
    int j = paramString.length();
    for (int k = paramInt; k < j; k++)
    {
      if ((paramString.regionMatches(true, k, str, 0, i)) && 
        (!matchesOtherAffix(i, paramString, k))) {
        return k;
      }
      switch (paramString.charAt(k))
      {
      case '+': 
      case ',': 
      case '-': 
      case '.': 
      case '0': 
      case '1': 
      case '2': 
      case '3': 
      case '4': 
      case '5': 
      case '6': 
      case '7': 
      case '8': 
      case '9': 
        break;
      case '/': 
      default: 
        break label148;
      }
    }
    label148:
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public String[] getAffixes()
  {
    return new String[] { iText };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.SimpleAffix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */