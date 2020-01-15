package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

 enum DateTimeFormatterBuilder$TimeZoneId
  implements InternalPrinter, InternalParser
{
  INSTANCE;
  
  private static final List<String> ALL_IDS;
  static final int MAX_LENGTH;
  
  static
  {
    ALL_IDS = new ArrayList(DateTimeZone.getAvailableIDs());
    Collections.sort(ALL_IDS);
    
    int i = 0;
    for (String str : ALL_IDS) {
      i = Math.max(i, str.length());
    }
    MAX_LENGTH = i;
  }
  
  public int estimatePrintedLength()
  {
    return MAX_LENGTH;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    paramAppendable.append(paramDateTimeZone != null ? paramDateTimeZone.getID() : "");
  }
  
  public int estimateParsedLength()
  {
    return MAX_LENGTH;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    Object localObject = null;
    int i = prefixedStartPosition(paramCharSequence, paramInt);
    for (int j = i; j < ALL_IDS.size(); j++)
    {
      String str = (String)ALL_IDS.get(j);
      if (!DateTimeFormatterBuilder.csStartsWith(paramCharSequence, paramInt, str)) {
        break;
      }
      if ((localObject == null) || (str.length() > ((String)localObject).length())) {
        localObject = str;
      }
    }
    if (localObject != null)
    {
      paramDateTimeParserBucket.setZone(DateTimeZone.forID((String)localObject));
      return paramInt + ((String)localObject).length();
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  private static int prefixedStartPosition(CharSequence paramCharSequence, int paramInt)
  {
    int i = 0;
    int j = ALL_IDS.size() - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      String str = (String)ALL_IDS.get(k);
      int m = DateTimeFormatterBuilder.csCompare(paramCharSequence, paramInt, str);
      if (m > 0) {
        j = k - 1;
      } else if (m < 0) {
        i = k + 1;
      } else {
        return k;
      }
    }
    return i;
  }
  
  private DateTimeFormatterBuilder$TimeZoneId() {}
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.TimeZoneId
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */