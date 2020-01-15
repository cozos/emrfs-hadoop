package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

class DateTimeFormatterBuilder$TimeZoneName
  implements InternalPrinter, InternalParser
{
  static final int LONG_NAME = 0;
  static final int SHORT_NAME = 1;
  private final Map<String, DateTimeZone> iParseLookup;
  private final int iType;
  
  DateTimeFormatterBuilder$TimeZoneName(int paramInt, Map<String, DateTimeZone> paramMap)
  {
    iType = paramInt;
    iParseLookup = paramMap;
  }
  
  public int estimatePrintedLength()
  {
    return iType == 1 ? 4 : 20;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    paramAppendable.append(print(paramLong - paramInt, paramDateTimeZone, paramLocale));
  }
  
  private String print(long paramLong, DateTimeZone paramDateTimeZone, Locale paramLocale)
  {
    if (paramDateTimeZone == null) {
      return "";
    }
    switch (iType)
    {
    case 0: 
      return paramDateTimeZone.getName(paramLong, paramLocale);
    case 1: 
      return paramDateTimeZone.getShortName(paramLong, paramLocale);
    }
    return "";
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {}
  
  public int estimateParsedLength()
  {
    return iType == 1 ? 4 : 20;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    Map localMap = iParseLookup;
    localMap = localMap != null ? localMap : DateTimeUtils.getDefaultTimeZoneNames();
    Object localObject = null;
    for (String str : localMap.keySet()) {
      if ((DateTimeFormatterBuilder.csStartsWith(paramCharSequence, paramInt, str)) && (
        (localObject == null) || (str.length() > ((String)localObject).length()))) {
        localObject = str;
      }
    }
    if (localObject != null)
    {
      paramDateTimeParserBucket.setZone((DateTimeZone)localMap.get(localObject));
      return paramInt + ((String)localObject).length();
    }
    return paramInt ^ 0xFFFFFFFF;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.TimeZoneName
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */