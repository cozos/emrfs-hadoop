package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import java.util.ArrayList;
import java.util.List;

class ZoneInfoCompiler$RuleSet
{
  private List<ZoneInfoCompiler.Rule> iRules;
  
  ZoneInfoCompiler$RuleSet(ZoneInfoCompiler.Rule paramRule)
  {
    iRules = new ArrayList();
    iRules.add(paramRule);
  }
  
  void addRule(ZoneInfoCompiler.Rule paramRule)
  {
    if (!iName.equals(iRules.get(0)).iName)) {
      throw new IllegalArgumentException("Rule name mismatch");
    }
    iRules.add(paramRule);
  }
  
  public void addRecurring(DateTimeZoneBuilder paramDateTimeZoneBuilder, String paramString)
  {
    for (int i = 0; i < iRules.size(); i++)
    {
      ZoneInfoCompiler.Rule localRule = (ZoneInfoCompiler.Rule)iRules.get(i);
      localRule.addRecurring(paramDateTimeZoneBuilder, paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.ZoneInfoCompiler.RuleSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */