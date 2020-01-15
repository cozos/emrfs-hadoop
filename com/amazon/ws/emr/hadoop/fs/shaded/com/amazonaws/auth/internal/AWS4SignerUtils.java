package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;

public final class AWS4SignerUtils
{
  private static final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyyMMdd").withZoneUTC();
  private static final DateTimeFormatter timeFormatter = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'").withZoneUTC();
  
  public static String formatDateStamp(long timeMilli)
  {
    return dateFormatter.print(timeMilli);
  }
  
  public static String formatTimestamp(long timeMilli)
  {
    return timeFormatter.print(timeMilli);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal.AWS4SignerUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */