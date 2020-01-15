package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import java.util.HashSet;
import java.util.Set;

abstract class PeriodFormatterBuilder$IgnorableAffix
  implements PeriodFormatterBuilder.PeriodFieldAffix
{
  private volatile String[] iOtherAffixes;
  
  public void finish(Set<PeriodFormatterBuilder.PeriodFieldAffix> paramSet)
  {
    if (iOtherAffixes == null)
    {
      int i = Integer.MAX_VALUE;
      Object localObject1 = null;
      String[] arrayOfString;
      for (arrayOfString : getAffixes()) {
        if (arrayOfString.length() < i)
        {
          i = arrayOfString.length();
          localObject1 = arrayOfString;
        }
      }
      ??? = new HashSet();
      for (PeriodFormatterBuilder.PeriodFieldAffix localPeriodFieldAffix : paramSet) {
        if (localPeriodFieldAffix != null) {
          for (String str : localPeriodFieldAffix.getAffixes()) {
            if ((str.length() > i) || ((str.equalsIgnoreCase((String)localObject1)) && (!str.equals(localObject1)))) {
              ((Set)???).add(str);
            }
          }
        }
      }
      iOtherAffixes = ((String[])((Set)???).toArray(new String[((Set)???).size()]));
    }
  }
  
  protected boolean matchesOtherAffix(int paramInt1, String paramString, int paramInt2)
  {
    if (iOtherAffixes != null) {
      for (String str : iOtherAffixes)
      {
        int k = str.length();
        if (((paramInt1 < k) && (paramString.regionMatches(true, paramInt2, str, 0, k))) || ((paramInt1 == k) && (paramString.regionMatches(false, paramInt2, str, 0, k)))) {
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.IgnorableAffix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */