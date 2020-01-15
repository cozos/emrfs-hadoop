package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritableInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;

class StringConverter
  extends AbstractConverter
  implements InstantConverter, PartialConverter, DurationConverter, PeriodConverter, IntervalConverter
{
  static final StringConverter INSTANCE = new StringConverter();
  
  public long getInstantMillis(Object paramObject, Chronology paramChronology)
  {
    String str = (String)paramObject;
    DateTimeFormatter localDateTimeFormatter = ISODateTimeFormat.dateTimeParser();
    return localDateTimeFormatter.withChronology(paramChronology).parseMillis(str);
  }
  
  public int[] getPartialValues(ReadablePartial paramReadablePartial, Object paramObject, Chronology paramChronology, DateTimeFormatter paramDateTimeFormatter)
  {
    if (paramDateTimeFormatter.getZone() != null) {
      paramChronology = paramChronology.withZone(paramDateTimeFormatter.getZone());
    }
    long l = paramDateTimeFormatter.withChronology(paramChronology).parseMillis((String)paramObject);
    return paramChronology.get(paramReadablePartial, l);
  }
  
  public long getDurationMillis(Object paramObject)
  {
    String str1 = (String)paramObject;
    String str2 = str1;
    int i = str2.length();
    if ((i < 4) || ((str2.charAt(0) != 'P') && (str2.charAt(0) != 'p')) || ((str2.charAt(1) != 'T') && (str2.charAt(1) != 't')) || ((str2.charAt(i - 1) != 'S') && (str2.charAt(i - 1) != 's'))) {
      throw new IllegalArgumentException("Invalid format: \"" + str1 + '"');
    }
    str2 = str2.substring(2, i - 1);
    int j = -1;
    int k = 0;
    for (int m = 0; m < str2.length(); m++) {
      if ((str2.charAt(m) < '0') || (str2.charAt(m) > '9')) {
        if ((m == 0) && (str2.charAt(0) == '-'))
        {
          k = 1;
        }
        else
        {
          if (m > (k != 0 ? 1 : 0)) {
            if ((str2.charAt(m) == '.') && (j == -1))
            {
              j = m; continue;
            }
          }
          throw new IllegalArgumentException("Invalid format: \"" + str1 + '"');
        }
      }
    }
    long l1 = 0L;long l2 = 0L;
    int n = k != 0 ? 1 : 0;
    if (j > 0)
    {
      l2 = Long.parseLong(str2.substring(n, j));
      str2 = str2.substring(j + 1);
      if (str2.length() != 3) {
        str2 = (str2 + "000").substring(0, 3);
      }
      l1 = Integer.parseInt(str2);
    }
    else if (k != 0)
    {
      l2 = Long.parseLong(str2.substring(n, str2.length()));
    }
    else
    {
      l2 = Long.parseLong(str2);
    }
    if (k != 0) {
      return FieldUtils.safeAdd(FieldUtils.safeMultiply(-l2, 1000), -l1);
    }
    return FieldUtils.safeAdd(FieldUtils.safeMultiply(l2, 1000), l1);
  }
  
  public void setInto(ReadWritablePeriod paramReadWritablePeriod, Object paramObject, Chronology paramChronology)
  {
    String str = (String)paramObject;
    PeriodFormatter localPeriodFormatter = ISOPeriodFormat.standard();
    paramReadWritablePeriod.clear();
    int i = localPeriodFormatter.parseInto(paramReadWritablePeriod, str, 0);
    if (i < str.length())
    {
      if (i < 0) {
        localPeriodFormatter.withParseType(paramReadWritablePeriod.getPeriodType()).parseMutablePeriod(str);
      }
      throw new IllegalArgumentException("Invalid format: \"" + str + '"');
    }
  }
  
  public void setInto(ReadWritableInterval paramReadWritableInterval, Object paramObject, Chronology paramChronology)
  {
    String str1 = (String)paramObject;
    
    int i = str1.indexOf('/');
    if (i < 0) {
      throw new IllegalArgumentException("Format requires a '/' separator: " + str1);
    }
    String str2 = str1.substring(0, i);
    if (str2.length() <= 0) {
      throw new IllegalArgumentException("Format invalid: " + str1);
    }
    String str3 = str1.substring(i + 1);
    if (str3.length() <= 0) {
      throw new IllegalArgumentException("Format invalid: " + str1);
    }
    DateTimeFormatter localDateTimeFormatter = ISODateTimeFormat.dateTimeParser();
    localDateTimeFormatter = localDateTimeFormatter.withChronology(paramChronology);
    PeriodFormatter localPeriodFormatter = ISOPeriodFormat.standard();
    long l1 = 0L;long l2 = 0L;
    Period localPeriod = null;
    Chronology localChronology = null;
    
    int j = str2.charAt(0);
    DateTime localDateTime;
    if ((j == 80) || (j == 112))
    {
      localPeriod = localPeriodFormatter.withParseType(getPeriodType(str2)).parsePeriod(str2);
    }
    else
    {
      localDateTime = localDateTimeFormatter.parseDateTime(str2);
      l1 = localDateTime.getMillis();
      localChronology = localDateTime.getChronology();
    }
    j = str3.charAt(0);
    if ((j == 80) || (j == 112))
    {
      if (localPeriod != null) {
        throw new IllegalArgumentException("Interval composed of two durations: " + str1);
      }
      localPeriod = localPeriodFormatter.withParseType(getPeriodType(str3)).parsePeriod(str3);
      paramChronology = paramChronology != null ? paramChronology : localChronology;
      l2 = paramChronology.add(localPeriod, l1, 1);
    }
    else
    {
      localDateTime = localDateTimeFormatter.parseDateTime(str3);
      l2 = localDateTime.getMillis();
      localChronology = localChronology != null ? localChronology : localDateTime.getChronology();
      paramChronology = paramChronology != null ? paramChronology : localChronology;
      if (localPeriod != null) {
        l1 = paramChronology.add(localPeriod, l2, -1);
      }
    }
    paramReadWritableInterval.setInterval(l1, l2);
    paramReadWritableInterval.setChronology(paramChronology);
  }
  
  public Class<?> getSupportedType()
  {
    return String.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.StringConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */