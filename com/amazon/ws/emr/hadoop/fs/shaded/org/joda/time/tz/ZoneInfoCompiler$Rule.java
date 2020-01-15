package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import java.util.StringTokenizer;

class ZoneInfoCompiler$Rule
{
  public final String iName;
  public final int iFromYear;
  public final int iToYear;
  public final String iType;
  public final ZoneInfoCompiler.DateTimeOfYear iDateTimeOfYear;
  public final int iSaveMillis;
  public final String iLetterS;
  
  ZoneInfoCompiler$Rule(StringTokenizer paramStringTokenizer)
  {
    if (paramStringTokenizer.countTokens() < 6) {
      throw new IllegalArgumentException("Attempting to create a Rule from an incomplete tokenizer");
    }
    iName = paramStringTokenizer.nextToken().intern();
    iFromYear = ZoneInfoCompiler.parseYear(paramStringTokenizer.nextToken(), 0);
    iToYear = ZoneInfoCompiler.parseYear(paramStringTokenizer.nextToken(), iFromYear);
    if (iToYear < iFromYear) {
      throw new IllegalArgumentException();
    }
    iType = ZoneInfoCompiler.parseOptional(paramStringTokenizer.nextToken());
    iDateTimeOfYear = new ZoneInfoCompiler.DateTimeOfYear(paramStringTokenizer);
    iSaveMillis = ZoneInfoCompiler.parseTime(paramStringTokenizer.nextToken());
    iLetterS = ZoneInfoCompiler.parseOptional(paramStringTokenizer.nextToken());
  }
  
  public void addRecurring(DateTimeZoneBuilder paramDateTimeZoneBuilder, String paramString)
  {
    String str = formatName(paramString);
    iDateTimeOfYear.addRecurring(paramDateTimeZoneBuilder, str, iSaveMillis, iFromYear, iToYear);
  }
  
  private String formatName(String paramString)
  {
    int i = paramString.indexOf('/');
    if (i > 0)
    {
      if (iSaveMillis == 0) {
        return paramString.substring(0, i).intern();
      }
      return paramString.substring(i + 1).intern();
    }
    i = paramString.indexOf("%s");
    if (i < 0) {
      return paramString;
    }
    String str1 = paramString.substring(0, i);
    String str2 = paramString.substring(i + 2);
    String str3;
    if (iLetterS == null) {
      str3 = str1.concat(str2);
    } else {
      str3 = str1 + iLetterS + str2;
    }
    return str3.intern();
  }
  
  public String toString()
  {
    return "[Rule]\nName: " + iName + "\n" + "FromYear: " + iFromYear + "\n" + "ToYear: " + iToYear + "\n" + "Type: " + iType + "\n" + iDateTimeOfYear + "SaveMillis: " + iSaveMillis + "\n" + "LetterS: " + iLetterS + "\n";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.ZoneInfoCompiler.Rule
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */