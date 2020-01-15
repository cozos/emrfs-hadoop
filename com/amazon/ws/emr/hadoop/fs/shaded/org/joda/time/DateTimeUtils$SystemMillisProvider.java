package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

class DateTimeUtils$SystemMillisProvider
  implements DateTimeUtils.MillisProvider
{
  public long getMillis()
  {
    return System.currentTimeMillis();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils.SystemMillisProvider
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */