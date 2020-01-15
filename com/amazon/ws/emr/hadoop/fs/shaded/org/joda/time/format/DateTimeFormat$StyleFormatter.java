package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

class DateTimeFormat$StyleFormatter
  implements InternalPrinter, InternalParser
{
  private static final ConcurrentHashMap<DateTimeFormat.StyleFormatterCacheKey, DateTimeFormatter> cCache = new ConcurrentHashMap();
  private final int iDateStyle;
  private final int iTimeStyle;
  private final int iType;
  
  DateTimeFormat$StyleFormatter(int paramInt1, int paramInt2, int paramInt3)
  {
    iDateStyle = paramInt1;
    iTimeStyle = paramInt2;
    iType = paramInt3;
  }
  
  public int estimatePrintedLength()
  {
    return 40;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    InternalPrinter localInternalPrinter = getFormatter(paramLocale).getPrinter0();
    localInternalPrinter.printTo(paramAppendable, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    InternalPrinter localInternalPrinter = getFormatter(paramLocale).getPrinter0();
    localInternalPrinter.printTo(paramAppendable, paramReadablePartial, paramLocale);
  }
  
  public int estimateParsedLength()
  {
    return 40;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    InternalParser localInternalParser = getFormatter(paramDateTimeParserBucket.getLocale()).getParser0();
    return localInternalParser.parseInto(paramDateTimeParserBucket, paramCharSequence, paramInt);
  }
  
  private DateTimeFormatter getFormatter(Locale paramLocale)
  {
    paramLocale = paramLocale == null ? Locale.getDefault() : paramLocale;
    DateTimeFormat.StyleFormatterCacheKey localStyleFormatterCacheKey = new DateTimeFormat.StyleFormatterCacheKey(iType, iDateStyle, iTimeStyle, paramLocale);
    Object localObject = (DateTimeFormatter)cCache.get(localStyleFormatterCacheKey);
    if (localObject == null)
    {
      localObject = DateTimeFormat.forPattern(getPattern(paramLocale));
      DateTimeFormatter localDateTimeFormatter = (DateTimeFormatter)cCache.putIfAbsent(localStyleFormatterCacheKey, localObject);
      if (localDateTimeFormatter != null) {
        localObject = localDateTimeFormatter;
      }
    }
    return (DateTimeFormatter)localObject;
  }
  
  String getPattern(Locale paramLocale)
  {
    DateFormat localDateFormat = null;
    switch (iType)
    {
    case 0: 
      localDateFormat = DateFormat.getDateInstance(iDateStyle, paramLocale);
      break;
    case 1: 
      localDateFormat = DateFormat.getTimeInstance(iTimeStyle, paramLocale);
      break;
    case 2: 
      localDateFormat = DateFormat.getDateTimeInstance(iDateStyle, iTimeStyle, paramLocale);
    }
    if (!(localDateFormat instanceof SimpleDateFormat)) {
      throw new IllegalArgumentException("No datetime pattern for locale: " + paramLocale);
    }
    return ((SimpleDateFormat)localDateFormat).toPattern();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat.StyleFormatter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */