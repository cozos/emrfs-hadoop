package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public enum TimestampFormat
{
  ISO_8601("iso8601"),  UNIX_TIMESTAMP("unixTimestamp"),  UNIX_TIMESTAMP_IN_MILLIS("unixTimestampInMillis"),  RFC_822("rfc822"),  UNKNOWN("unknown");
  
  private final String format;
  
  private TimestampFormat(String format)
  {
    this.format = format;
  }
  
  public String getFormat()
  {
    return format;
  }
  
  public static TimestampFormat fromValue(String format)
  {
    if (format == null) {
      return null;
    }
    for (TimestampFormat timestampFormat : values()) {
      if (format.equals(format)) {
        return timestampFormat;
      }
    }
    throw new IllegalArgumentException("Unknown enum value for TimestampFormat : " + format);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */