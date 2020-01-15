package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import java.util.ArrayList;
import java.util.Iterator;

final class DateTimeZoneBuilder$RuleSet
{
  private static final int YEAR_LIMIT;
  private int iStandardOffset;
  private ArrayList<DateTimeZoneBuilder.Rule> iRules;
  private String iInitialNameKey;
  private int iInitialSaveMillis;
  private int iUpperYear;
  private DateTimeZoneBuilder.OfYear iUpperOfYear;
  
  static
  {
    long l = DateTimeUtils.currentTimeMillis();
    YEAR_LIMIT = ISOChronology.getInstanceUTC().year().get(l) + 100;
  }
  
  DateTimeZoneBuilder$RuleSet()
  {
    iRules = new ArrayList(10);
    iUpperYear = Integer.MAX_VALUE;
  }
  
  DateTimeZoneBuilder$RuleSet(RuleSet paramRuleSet)
  {
    iStandardOffset = iStandardOffset;
    iRules = new ArrayList(iRules);
    iInitialNameKey = iInitialNameKey;
    iInitialSaveMillis = iInitialSaveMillis;
    iUpperYear = iUpperYear;
    iUpperOfYear = iUpperOfYear;
  }
  
  public int getStandardOffset()
  {
    return iStandardOffset;
  }
  
  public void setStandardOffset(int paramInt)
  {
    iStandardOffset = paramInt;
  }
  
  public void setFixedSavings(String paramString, int paramInt)
  {
    iInitialNameKey = paramString;
    iInitialSaveMillis = paramInt;
  }
  
  public void addRule(DateTimeZoneBuilder.Rule paramRule)
  {
    if (!iRules.contains(paramRule)) {
      iRules.add(paramRule);
    }
  }
  
  public void setUpperLimit(int paramInt, DateTimeZoneBuilder.OfYear paramOfYear)
  {
    iUpperYear = paramInt;
    iUpperOfYear = paramOfYear;
  }
  
  public DateTimeZoneBuilder.Transition firstTransition(long paramLong)
  {
    if (iInitialNameKey != null) {
      return new DateTimeZoneBuilder.Transition(paramLong, iInitialNameKey, iStandardOffset + iInitialSaveMillis, iStandardOffset);
    }
    ArrayList localArrayList = new ArrayList(iRules);
    
    long l = Long.MIN_VALUE;
    int i = 0;
    DateTimeZoneBuilder.Transition localTransition1 = null;
    DateTimeZoneBuilder.Transition localTransition2;
    while ((localTransition2 = nextTransition(l, i)) != null)
    {
      l = localTransition2.getMillis();
      if (l == paramLong)
      {
        localTransition1 = new DateTimeZoneBuilder.Transition(paramLong, localTransition2);
        break;
      }
      if (l > paramLong)
      {
        if (localTransition1 == null) {
          for (DateTimeZoneBuilder.Rule localRule : localArrayList) {
            if (localRule.getSaveMillis() == 0)
            {
              localTransition1 = new DateTimeZoneBuilder.Transition(paramLong, localRule, iStandardOffset);
              break;
            }
          }
        }
        if (localTransition1 != null) {
          break;
        }
        localTransition1 = new DateTimeZoneBuilder.Transition(paramLong, localTransition2.getNameKey(), iStandardOffset, iStandardOffset); break;
      }
      localTransition1 = new DateTimeZoneBuilder.Transition(paramLong, localTransition2);
      
      i = localTransition2.getSaveMillis();
    }
    iRules = localArrayList;
    return localTransition1;
  }
  
  public DateTimeZoneBuilder.Transition nextTransition(long paramLong, int paramInt)
  {
    ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
    
    Object localObject = null;
    long l1 = Long.MAX_VALUE;
    
    Iterator localIterator = iRules.iterator();
    while (localIterator.hasNext())
    {
      DateTimeZoneBuilder.Rule localRule = (DateTimeZoneBuilder.Rule)localIterator.next();
      long l2 = localRule.next(paramLong, iStandardOffset, paramInt);
      if (l2 <= paramLong)
      {
        localIterator.remove();
      }
      else if (l2 <= l1)
      {
        localObject = localRule;
        l1 = l2;
      }
    }
    if (localObject == null) {
      return null;
    }
    if (localISOChronology.year().get(l1) >= YEAR_LIMIT) {
      return null;
    }
    if (iUpperYear < Integer.MAX_VALUE)
    {
      long l3 = iUpperOfYear.setInstant(iUpperYear, iStandardOffset, paramInt);
      if (l1 >= l3) {
        return null;
      }
    }
    return new DateTimeZoneBuilder.Transition(l1, (DateTimeZoneBuilder.Rule)localObject, iStandardOffset);
  }
  
  public long getUpperLimit(int paramInt)
  {
    if (iUpperYear == Integer.MAX_VALUE) {
      return Long.MAX_VALUE;
    }
    return iUpperOfYear.setInstant(iUpperYear, iStandardOffset, paramInt);
  }
  
  public DateTimeZoneBuilder.DSTZone buildTailZone(String paramString)
  {
    if (iRules.size() == 2)
    {
      DateTimeZoneBuilder.Rule localRule1 = (DateTimeZoneBuilder.Rule)iRules.get(0);
      DateTimeZoneBuilder.Rule localRule2 = (DateTimeZoneBuilder.Rule)iRules.get(1);
      if ((localRule1.getToYear() == Integer.MAX_VALUE) && (localRule2.getToYear() == Integer.MAX_VALUE)) {
        return new DateTimeZoneBuilder.DSTZone(paramString, iStandardOffset, iRecurrence, iRecurrence);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DateTimeZoneBuilder.RuleSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */