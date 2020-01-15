package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class DateTimeFormat
{
  static final int FULL = 0;
  static final int LONG = 1;
  static final int MEDIUM = 2;
  static final int SHORT = 3;
  static final int NONE = 4;
  static final int DATE = 0;
  static final int TIME = 1;
  static final int DATETIME = 2;
  private static final int PATTERN_CACHE_SIZE = 500;
  private static final ConcurrentHashMap<String, DateTimeFormatter> cPatternCache = new ConcurrentHashMap();
  private static final AtomicReferenceArray<DateTimeFormatter> cStyleCache = new AtomicReferenceArray(25);
  
  public static DateTimeFormatter forPattern(String paramString)
  {
    return createFormatterForPattern(paramString);
  }
  
  public static DateTimeFormatter forStyle(String paramString)
  {
    return createFormatterForStyle(paramString);
  }
  
  public static String patternForStyle(String paramString, Locale paramLocale)
  {
    DateTimeFormatter localDateTimeFormatter = createFormatterForStyle(paramString);
    if (paramLocale == null) {
      paramLocale = Locale.getDefault();
    }
    return ((StyleFormatter)localDateTimeFormatter.getPrinter0()).getPattern(paramLocale);
  }
  
  public static DateTimeFormatter shortDate()
  {
    return createFormatterForStyleIndex(3, 4);
  }
  
  public static DateTimeFormatter shortTime()
  {
    return createFormatterForStyleIndex(4, 3);
  }
  
  public static DateTimeFormatter shortDateTime()
  {
    return createFormatterForStyleIndex(3, 3);
  }
  
  public static DateTimeFormatter mediumDate()
  {
    return createFormatterForStyleIndex(2, 4);
  }
  
  public static DateTimeFormatter mediumTime()
  {
    return createFormatterForStyleIndex(4, 2);
  }
  
  public static DateTimeFormatter mediumDateTime()
  {
    return createFormatterForStyleIndex(2, 2);
  }
  
  public static DateTimeFormatter longDate()
  {
    return createFormatterForStyleIndex(1, 4);
  }
  
  public static DateTimeFormatter longTime()
  {
    return createFormatterForStyleIndex(4, 1);
  }
  
  public static DateTimeFormatter longDateTime()
  {
    return createFormatterForStyleIndex(1, 1);
  }
  
  public static DateTimeFormatter fullDate()
  {
    return createFormatterForStyleIndex(0, 4);
  }
  
  public static DateTimeFormatter fullTime()
  {
    return createFormatterForStyleIndex(4, 0);
  }
  
  public static DateTimeFormatter fullDateTime()
  {
    return createFormatterForStyleIndex(0, 0);
  }
  
  static void appendPatternTo(DateTimeFormatterBuilder paramDateTimeFormatterBuilder, String paramString)
  {
    parsePatternTo(paramDateTimeFormatterBuilder, paramString);
  }
  
  private static void parsePatternTo(DateTimeFormatterBuilder paramDateTimeFormatterBuilder, String paramString)
  {
    int i = paramString.length();
    int[] arrayOfInt = new int[1];
    for (int j = 0; j < i; j++)
    {
      arrayOfInt[0] = j;
      String str1 = parseToken(paramString, arrayOfInt);
      j = arrayOfInt[0];
      
      int k = str1.length();
      if (k == 0) {
        break;
      }
      int m = str1.charAt(0);
      switch (m)
      {
      case 71: 
        paramDateTimeFormatterBuilder.appendEraText();
        break;
      case 67: 
        paramDateTimeFormatterBuilder.appendCenturyOfEra(k, k);
        break;
      case 89: 
      case 120: 
      case 121: 
        if (k == 2)
        {
          boolean bool = true;
          if (j + 1 < i)
          {
            arrayOfInt[0] += 1;
            if (isNumericToken(parseToken(paramString, arrayOfInt))) {
              bool = false;
            }
            arrayOfInt[0] -= 1;
          }
          switch (m)
          {
          case 120: 
            paramDateTimeFormatterBuilder.appendTwoDigitWeekyear(new DateTime().getWeekyear() - 30, bool);
            
            break;
          case 89: 
          case 121: 
          default: 
            paramDateTimeFormatterBuilder.appendTwoDigitYear(new DateTime().getYear() - 30, bool);
          }
        }
        else
        {
          int n = 9;
          if (j + 1 < i)
          {
            arrayOfInt[0] += 1;
            if (isNumericToken(parseToken(paramString, arrayOfInt))) {
              n = k;
            }
            arrayOfInt[0] -= 1;
          }
          switch (m)
          {
          case 120: 
            paramDateTimeFormatterBuilder.appendWeekyear(k, n);
            break;
          case 121: 
            paramDateTimeFormatterBuilder.appendYear(k, n);
            break;
          case 89: 
            paramDateTimeFormatterBuilder.appendYearOfEra(k, n);
          }
        }
        break;
      case 77: 
        if (k >= 3)
        {
          if (k >= 4) {
            paramDateTimeFormatterBuilder.appendMonthOfYearText();
          } else {
            paramDateTimeFormatterBuilder.appendMonthOfYearShortText();
          }
        }
        else {
          paramDateTimeFormatterBuilder.appendMonthOfYear(k);
        }
        break;
      case 100: 
        paramDateTimeFormatterBuilder.appendDayOfMonth(k);
        break;
      case 97: 
        paramDateTimeFormatterBuilder.appendHalfdayOfDayText();
        break;
      case 104: 
        paramDateTimeFormatterBuilder.appendClockhourOfHalfday(k);
        break;
      case 72: 
        paramDateTimeFormatterBuilder.appendHourOfDay(k);
        break;
      case 107: 
        paramDateTimeFormatterBuilder.appendClockhourOfDay(k);
        break;
      case 75: 
        paramDateTimeFormatterBuilder.appendHourOfHalfday(k);
        break;
      case 109: 
        paramDateTimeFormatterBuilder.appendMinuteOfHour(k);
        break;
      case 115: 
        paramDateTimeFormatterBuilder.appendSecondOfMinute(k);
        break;
      case 83: 
        paramDateTimeFormatterBuilder.appendFractionOfSecond(k, k);
        break;
      case 101: 
        paramDateTimeFormatterBuilder.appendDayOfWeek(k);
        break;
      case 69: 
        if (k >= 4) {
          paramDateTimeFormatterBuilder.appendDayOfWeekText();
        } else {
          paramDateTimeFormatterBuilder.appendDayOfWeekShortText();
        }
        break;
      case 68: 
        paramDateTimeFormatterBuilder.appendDayOfYear(k);
        break;
      case 119: 
        paramDateTimeFormatterBuilder.appendWeekOfWeekyear(k);
        break;
      case 122: 
        if (k >= 4) {
          paramDateTimeFormatterBuilder.appendTimeZoneName();
        } else {
          paramDateTimeFormatterBuilder.appendTimeZoneShortName(null);
        }
        break;
      case 90: 
        if (k == 1) {
          paramDateTimeFormatterBuilder.appendTimeZoneOffset(null, "Z", false, 2, 2);
        } else if (k == 2) {
          paramDateTimeFormatterBuilder.appendTimeZoneOffset(null, "Z", true, 2, 2);
        } else {
          paramDateTimeFormatterBuilder.appendTimeZoneId();
        }
        break;
      case 39: 
        String str2 = str1.substring(1);
        if (str2.length() == 1) {
          paramDateTimeFormatterBuilder.appendLiteral(str2.charAt(0));
        } else {
          paramDateTimeFormatterBuilder.appendLiteral(new String(str2));
        }
        break;
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      case 60: 
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 70: 
      case 73: 
      case 74: 
      case 76: 
      case 78: 
      case 79: 
      case 80: 
      case 81: 
      case 82: 
      case 84: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 91: 
      case 92: 
      case 93: 
      case 94: 
      case 95: 
      case 96: 
      case 98: 
      case 99: 
      case 102: 
      case 103: 
      case 105: 
      case 106: 
      case 108: 
      case 110: 
      case 111: 
      case 112: 
      case 113: 
      case 114: 
      case 116: 
      case 117: 
      case 118: 
      default: 
        throw new IllegalArgumentException("Illegal pattern component: " + str1);
      }
    }
  }
  
  private static String parseToken(String paramString, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    
    int i = paramArrayOfInt[0];
    int j = paramString.length();
    
    char c1 = paramString.charAt(i);
    if (((c1 >= 'A') && (c1 <= 'Z')) || ((c1 >= 'a') && (c1 <= 'z'))) {
      localStringBuilder.append(c1);
    }
    while (i + 1 < j)
    {
      char c2 = paramString.charAt(i + 1);
      if (c2 == c1)
      {
        localStringBuilder.append(c1);
        i++;
        
        continue;
        
        localStringBuilder.append('\'');
        
        c2 = '\000';
        for (; i < j; i++)
        {
          c1 = paramString.charAt(i);
          if (c1 == '\'')
          {
            if ((i + 1 < j) && (paramString.charAt(i + 1) == '\''))
            {
              i++;
              localStringBuilder.append(c1);
            }
            else
            {
              c2 = c2 == 0 ? '\001' : '\000';
            }
          }
          else
          {
            if ((c2 == 0) && (((c1 >= 'A') && (c1 <= 'Z')) || ((c1 >= 'a') && (c1 <= 'z'))))
            {
              i--;
              break;
            }
            localStringBuilder.append(c1);
          }
        }
      }
    }
    paramArrayOfInt[0] = i;
    return localStringBuilder.toString();
  }
  
  private static boolean isNumericToken(String paramString)
  {
    int i = paramString.length();
    if (i > 0)
    {
      int j = paramString.charAt(0);
      switch (j)
      {
      case 67: 
      case 68: 
      case 70: 
      case 72: 
      case 75: 
      case 83: 
      case 87: 
      case 89: 
      case 99: 
      case 100: 
      case 101: 
      case 104: 
      case 107: 
      case 109: 
      case 115: 
      case 119: 
      case 120: 
      case 121: 
        return true;
      case 77: 
        if (i <= 2) {
          return true;
        }
        break;
      }
    }
    return false;
  }
  
  private static DateTimeFormatter createFormatterForPattern(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("Invalid pattern specification");
    }
    Object localObject = (DateTimeFormatter)cPatternCache.get(paramString);
    if (localObject == null)
    {
      DateTimeFormatterBuilder localDateTimeFormatterBuilder = new DateTimeFormatterBuilder();
      parsePatternTo(localDateTimeFormatterBuilder, paramString);
      localObject = localDateTimeFormatterBuilder.toFormatter();
      if (cPatternCache.size() < 500)
      {
        DateTimeFormatter localDateTimeFormatter = (DateTimeFormatter)cPatternCache.putIfAbsent(paramString, localObject);
        if (localDateTimeFormatter != null) {
          localObject = localDateTimeFormatter;
        }
      }
    }
    return (DateTimeFormatter)localObject;
  }
  
  private static DateTimeFormatter createFormatterForStyle(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 2)) {
      throw new IllegalArgumentException("Invalid style specification: " + paramString);
    }
    int i = selectStyle(paramString.charAt(0));
    int j = selectStyle(paramString.charAt(1));
    if ((i == 4) && (j == 4)) {
      throw new IllegalArgumentException("Style '--' is invalid");
    }
    return createFormatterForStyleIndex(i, j);
  }
  
  private static DateTimeFormatter createFormatterForStyleIndex(int paramInt1, int paramInt2)
  {
    int i = (paramInt1 << 2) + paramInt1 + paramInt2;
    if (i >= cStyleCache.length()) {
      return createDateTimeFormatter(paramInt1, paramInt2);
    }
    DateTimeFormatter localDateTimeFormatter = (DateTimeFormatter)cStyleCache.get(i);
    if (localDateTimeFormatter == null)
    {
      localDateTimeFormatter = createDateTimeFormatter(paramInt1, paramInt2);
      if (!cStyleCache.compareAndSet(i, null, localDateTimeFormatter)) {
        localDateTimeFormatter = (DateTimeFormatter)cStyleCache.get(i);
      }
    }
    return localDateTimeFormatter;
  }
  
  private static DateTimeFormatter createDateTimeFormatter(int paramInt1, int paramInt2)
  {
    int i = 2;
    if (paramInt1 == 4) {
      i = 1;
    } else if (paramInt2 == 4) {
      i = 0;
    }
    StyleFormatter localStyleFormatter = new StyleFormatter(paramInt1, paramInt2, i);
    return new DateTimeFormatter(localStyleFormatter, localStyleFormatter);
  }
  
  private static int selectStyle(char paramChar)
  {
    switch (paramChar)
    {
    case 'S': 
      return 3;
    case 'M': 
      return 2;
    case 'L': 
      return 1;
    case 'F': 
      return 0;
    case '-': 
      return 4;
    }
    throw new IllegalArgumentException("Invalid style character: " + paramChar);
  }
  
  static class StyleFormatter
    implements InternalPrinter, InternalParser
  {
    private static final ConcurrentHashMap<DateTimeFormat.StyleFormatterCacheKey, DateTimeFormatter> cCache = new ConcurrentHashMap();
    private final int iDateStyle;
    private final int iTimeStyle;
    private final int iType;
    
    StyleFormatter(int paramInt1, int paramInt2, int paramInt3)
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
  
  static class StyleFormatterCacheKey
  {
    private final int combinedTypeAndStyle;
    private final Locale locale;
    
    public StyleFormatterCacheKey(int paramInt1, int paramInt2, int paramInt3, Locale paramLocale)
    {
      locale = paramLocale;
      
      combinedTypeAndStyle = (paramInt1 + (paramInt2 << 4) + (paramInt3 << 8));
    }
    
    public int hashCode()
    {
      int i = 1;
      i = 31 * i + combinedTypeAndStyle;
      i = 31 * i + (locale == null ? 0 : locale.hashCode());
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof StyleFormatterCacheKey)) {
        return false;
      }
      StyleFormatterCacheKey localStyleFormatterCacheKey = (StyleFormatterCacheKey)paramObject;
      if (combinedTypeAndStyle != combinedTypeAndStyle) {
        return false;
      }
      if (locale == null)
      {
        if (locale != null) {
          return false;
        }
      }
      else if (!locale.equals(locale)) {
        return false;
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */