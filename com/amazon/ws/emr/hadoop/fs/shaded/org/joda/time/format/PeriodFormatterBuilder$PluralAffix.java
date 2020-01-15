package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import java.io.IOException;
import java.io.Writer;

class PeriodFormatterBuilder$PluralAffix
  extends PeriodFormatterBuilder.IgnorableAffix
{
  private final String iSingularText;
  private final String iPluralText;
  
  PeriodFormatterBuilder$PluralAffix(String paramString1, String paramString2)
  {
    iSingularText = paramString1;
    iPluralText = paramString2;
  }
  
  public int calculatePrintedLength(int paramInt)
  {
    return (paramInt == 1 ? iSingularText : iPluralText).length();
  }
  
  public void printTo(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(paramInt == 1 ? iSingularText : iPluralText);
  }
  
  public void printTo(Writer paramWriter, int paramInt)
    throws IOException
  {
    paramWriter.write(paramInt == 1 ? iSingularText : iPluralText);
  }
  
  public int parse(String paramString, int paramInt)
  {
    Object localObject1 = iPluralText;
    Object localObject2 = iSingularText;
    if (((String)localObject1).length() < ((String)localObject2).length())
    {
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    if ((paramString.regionMatches(true, paramInt, (String)localObject1, 0, ((String)localObject1).length())) && 
      (!matchesOtherAffix(((String)localObject1).length(), paramString, paramInt))) {
      return paramInt + ((String)localObject1).length();
    }
    if ((paramString.regionMatches(true, paramInt, (String)localObject2, 0, ((String)localObject2).length())) && 
      (!matchesOtherAffix(((String)localObject2).length(), paramString, paramInt))) {
      return paramInt + ((String)localObject2).length();
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public int scan(String paramString, int paramInt)
  {
    Object localObject1 = iPluralText;
    Object localObject2 = iSingularText;
    if (((String)localObject1).length() < ((String)localObject2).length())
    {
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    int i = ((String)localObject1).length();
    int j = ((String)localObject2).length();
    
    int k = paramString.length();
    for (int m = paramInt; m < k; m++)
    {
      if ((paramString.regionMatches(true, m, (String)localObject1, 0, i)) && 
        (!matchesOtherAffix(((String)localObject1).length(), paramString, m))) {
        return m;
      }
      if ((paramString.regionMatches(true, m, (String)localObject2, 0, j)) && 
        (!matchesOtherAffix(((String)localObject2).length(), paramString, m))) {
        return m;
      }
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public String[] getAffixes()
  {
    return new String[] { iSingularText, iPluralText };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.PluralAffix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */