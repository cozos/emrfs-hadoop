package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.FixedDateTimeZone;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@ThreadSafe
public class DateUtils
{
  private static final DateTimeZone GMT = new FixedDateTimeZone("GMT", "GMT", 0, 0);
  private static final long MILLI_SECONDS_OF_365_DAYS = 31536000000L;
  private static final int AWS_DATE_MILLI_SECOND_PRECISION = 3;
  protected static final DateTimeFormatter iso8601DateFormat = ISODateTimeFormat.dateTime().withZone(GMT);
  protected static final DateTimeFormatter alternateIso8601DateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(GMT);
  protected static final DateTimeFormatter rfc822DateFormat = DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'")
    .withLocale(Locale.US)
    .withZone(GMT);
  protected static final DateTimeFormatter compressedIso8601DateFormat = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'")
    .withZone(GMT);
  
  public static Date parseISO8601Date(String dateString)
  {
    try
    {
      return doParseISO8601Date(dateString);
    }
    catch (RuntimeException ex)
    {
      throw handleException(ex);
    }
  }
  
  static Date doParseISO8601Date(String dateStringOrig)
  {
    String dateString = dateStringOrig;
    if (dateString.endsWith("+0000")) {
      dateString = dateString.substring(0, dateString.length() - 5).concat("Z");
    }
    String temp = tempDateStringForJodaTime(dateString);
    try
    {
      if (temp.equals(dateString)) {
        return new Date(iso8601DateFormat.parseMillis(dateString));
      }
      long milliLess365Days = iso8601DateFormat.parseMillis(temp);
      long milli = milliLess365Days + 31536000000L;
      if (milli < 0L) {
        return new Date(iso8601DateFormat.parseMillis(dateString));
      }
      return new Date(milli);
    }
    catch (IllegalArgumentException e)
    {
      try
      {
        return new Date(alternateIso8601DateFormat.parseMillis(dateString));
      }
      catch (Exception oops)
      {
        throw e;
      }
    }
  }
  
  private static String tempDateStringForJodaTime(String dateString)
  {
    String fromPrefix = "292278994-";
    String toPrefix = "292278993-";
    return dateString.startsWith("292278994-") ? "292278993-" + dateString
      .substring("292278994-".length()) : dateString;
  }
  
  private static <E extends RuntimeException> E handleException(E ex)
  {
    if (JodaTime.hasExpectedBehavior()) {
      return ex;
    }
    throw new IllegalStateException("Joda-time 2.2 or later version is required, but found version: " + JodaTime.getVersion(), ex);
  }
  
  public static String formatISO8601Date(Date date)
  {
    try
    {
      return iso8601DateFormat.print(date.getTime());
    }
    catch (RuntimeException ex)
    {
      throw handleException(ex);
    }
  }
  
  public static String formatISO8601Date(DateTime date)
  {
    try
    {
      return iso8601DateFormat.print(date);
    }
    catch (RuntimeException ex)
    {
      throw handleException(ex);
    }
  }
  
  public static Date parseRFC822Date(String dateString)
  {
    if (dateString == null) {
      return null;
    }
    try
    {
      return new Date(rfc822DateFormat.parseMillis(dateString));
    }
    catch (RuntimeException ex)
    {
      throw handleException(ex);
    }
  }
  
  public static String formatRFC822Date(Date date)
  {
    try
    {
      return rfc822DateFormat.print(date.getTime());
    }
    catch (RuntimeException ex)
    {
      throw handleException(ex);
    }
  }
  
  public static Date parseCompressedISO8601Date(String dateString)
  {
    try
    {
      return new Date(compressedIso8601DateFormat.parseMillis(dateString));
    }
    catch (RuntimeException ex)
    {
      throw handleException(ex);
    }
  }
  
  public static Date parseServiceSpecificDate(String dateString)
  {
    if (dateString == null) {
      return null;
    }
    try
    {
      BigDecimal dateValue = new BigDecimal(dateString);
      return new Date(dateValue.scaleByPowerOfTen(3)
        .longValue());
    }
    catch (NumberFormatException nfe)
    {
      throw new SdkClientException("Unable to parse date : " + dateString, nfe);
    }
  }
  
  public static Date parseUnixTimestampInMillis(String dateString)
  {
    if (dateString == null) {
      return null;
    }
    try
    {
      BigDecimal dateValue = new BigDecimal(dateString);
      return new Date(dateValue.longValue());
    }
    catch (NumberFormatException nfe)
    {
      throw new SdkClientException("Unable to parse date : " + dateString, nfe);
    }
  }
  
  public static String formatServiceSpecificDate(Date date)
  {
    if (date == null) {
      return null;
    }
    BigDecimal dateValue = BigDecimal.valueOf(date.getTime());
    return dateValue.scaleByPowerOfTen(-3)
      .toPlainString();
  }
  
  public static String formatUnixTimestampInMills(Date date)
  {
    if (date == null) {
      return null;
    }
    BigDecimal dateValue = BigDecimal.valueOf(date.getTime());
    return dateValue.toPlainString();
  }
  
  public static Date cloneDate(Date date)
  {
    return date == null ? null : new Date(date.getTime());
  }
  
  public static long numberOfDaysSinceEpoch(long milliSinceEpoch)
  {
    return TimeUnit.MILLISECONDS.toDays(milliSinceEpoch);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */