package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import java.util.Map;
import java.util.StringTokenizer;

class ZoneInfoCompiler$Zone
{
  public final String iName;
  public final int iOffsetMillis;
  public final String iRules;
  public final String iFormat;
  public final int iUntilYear;
  public final ZoneInfoCompiler.DateTimeOfYear iUntilDateTimeOfYear;
  private Zone iNext;
  
  ZoneInfoCompiler$Zone(StringTokenizer paramStringTokenizer)
  {
    this(paramStringTokenizer.nextToken(), paramStringTokenizer);
  }
  
  private ZoneInfoCompiler$Zone(String paramString, StringTokenizer paramStringTokenizer)
  {
    iName = paramString.intern();
    iOffsetMillis = ZoneInfoCompiler.parseTime(paramStringTokenizer.nextToken());
    iRules = ZoneInfoCompiler.parseOptional(paramStringTokenizer.nextToken());
    iFormat = paramStringTokenizer.nextToken().intern();
    
    int i = Integer.MAX_VALUE;
    ZoneInfoCompiler.DateTimeOfYear localDateTimeOfYear = ZoneInfoCompiler.getStartOfYear();
    if (paramStringTokenizer.hasMoreTokens())
    {
      i = Integer.parseInt(paramStringTokenizer.nextToken());
      if (paramStringTokenizer.hasMoreTokens()) {
        localDateTimeOfYear = new ZoneInfoCompiler.DateTimeOfYear(paramStringTokenizer);
      }
    }
    iUntilYear = i;
    iUntilDateTimeOfYear = localDateTimeOfYear;
  }
  
  void chain(StringTokenizer paramStringTokenizer)
  {
    if (iNext != null) {
      iNext.chain(paramStringTokenizer);
    } else {
      iNext = new Zone(iName, paramStringTokenizer);
    }
  }
  
  public void addToBuilder(DateTimeZoneBuilder paramDateTimeZoneBuilder, Map<String, ZoneInfoCompiler.RuleSet> paramMap)
  {
    addToBuilder(this, paramDateTimeZoneBuilder, paramMap);
  }
  
  private static void addToBuilder(Zone paramZone, DateTimeZoneBuilder paramDateTimeZoneBuilder, Map<String, ZoneInfoCompiler.RuleSet> paramMap)
  {
    for (; paramZone != null; paramZone = iNext)
    {
      paramDateTimeZoneBuilder.setStandardOffset(iOffsetMillis);
      if (iRules == null) {
        paramDateTimeZoneBuilder.setFixedSavings(iFormat, 0);
      } else {
        try
        {
          int i = ZoneInfoCompiler.parseTime(iRules);
          paramDateTimeZoneBuilder.setFixedSavings(iFormat, i);
        }
        catch (Exception localException)
        {
          ZoneInfoCompiler.RuleSet localRuleSet = (ZoneInfoCompiler.RuleSet)paramMap.get(iRules);
          if (localRuleSet == null) {
            throw new IllegalArgumentException("Rules not found: " + iRules);
          }
          localRuleSet.addRecurring(paramDateTimeZoneBuilder, iFormat);
        }
      }
      if (iUntilYear == Integer.MAX_VALUE) {
        break;
      }
      iUntilDateTimeOfYear.addCutover(paramDateTimeZoneBuilder, iUntilYear);
    }
  }
  
  public String toString()
  {
    String str = "[Zone]\nName: " + iName + "\n" + "OffsetMillis: " + iOffsetMillis + "\n" + "Rules: " + iRules + "\n" + "Format: " + iFormat + "\n" + "UntilYear: " + iUntilYear + "\n" + iUntilDateTimeOfYear;
    if (iNext == null) {
      return str;
    }
    return str + "...\n" + iNext.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.ZoneInfoCompiler.Zone
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */