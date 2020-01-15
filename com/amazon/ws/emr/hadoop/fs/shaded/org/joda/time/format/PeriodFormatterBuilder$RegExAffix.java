package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PeriodFormatterBuilder$RegExAffix
  extends PeriodFormatterBuilder.IgnorableAffix
{
  private static final Comparator<String> LENGTH_DESC_COMPARATOR = new Comparator()
  {
    public int compare(String paramAnonymousString1, String paramAnonymousString2)
    {
      return paramAnonymousString2.length() - paramAnonymousString1.length();
    }
  };
  private final String[] iSuffixes;
  private final Pattern[] iPatterns;
  private final String[] iSuffixesSortedDescByLength;
  
  PeriodFormatterBuilder$RegExAffix(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    iSuffixes = ((String[])paramArrayOfString2.clone());
    iPatterns = new Pattern[paramArrayOfString1.length];
    for (int i = 0; i < paramArrayOfString1.length; i++)
    {
      Pattern localPattern = (Pattern)PeriodFormatterBuilder.access$200().get(paramArrayOfString1[i]);
      if (localPattern == null)
      {
        localPattern = Pattern.compile(paramArrayOfString1[i]);
        PeriodFormatterBuilder.access$200().putIfAbsent(paramArrayOfString1[i], localPattern);
      }
      iPatterns[i] = localPattern;
    }
    iSuffixesSortedDescByLength = ((String[])iSuffixes.clone());
    Arrays.sort(iSuffixesSortedDescByLength, LENGTH_DESC_COMPARATOR);
  }
  
  private int selectSuffixIndex(int paramInt)
  {
    String str = String.valueOf(paramInt);
    for (int i = 0; i < iPatterns.length; i++) {
      if (iPatterns[i].matcher(str).matches()) {
        return i;
      }
    }
    return iPatterns.length - 1;
  }
  
  public int calculatePrintedLength(int paramInt)
  {
    return iSuffixes[selectSuffixIndex(paramInt)].length();
  }
  
  public void printTo(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(iSuffixes[selectSuffixIndex(paramInt)]);
  }
  
  public void printTo(Writer paramWriter, int paramInt)
    throws IOException
  {
    paramWriter.write(iSuffixes[selectSuffixIndex(paramInt)]);
  }
  
  public int parse(String paramString, int paramInt)
  {
    for (String str : iSuffixesSortedDescByLength) {
      if ((paramString.regionMatches(true, paramInt, str, 0, str.length())) && 
        (!matchesOtherAffix(str.length(), paramString, paramInt))) {
        return paramInt + str.length();
      }
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public int scan(String paramString, int paramInt)
  {
    int i = paramString.length();
    for (int j = paramInt; j < i; j++) {
      for (String str : iSuffixesSortedDescByLength) {
        if ((paramString.regionMatches(true, j, str, 0, str.length())) && 
          (!matchesOtherAffix(str.length(), paramString, j))) {
          return j;
        }
      }
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public String[] getAffixes()
  {
    return (String[])iSuffixes.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.RegExAffix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */