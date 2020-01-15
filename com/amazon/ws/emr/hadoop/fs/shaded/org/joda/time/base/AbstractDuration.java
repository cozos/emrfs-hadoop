package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Duration;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDuration;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.FormatUtils;
import org.joda.convert.ToString;

public abstract class AbstractDuration
  implements ReadableDuration
{
  public Duration toDuration()
  {
    return new Duration(getMillis());
  }
  
  public Period toPeriod()
  {
    return new Period(getMillis());
  }
  
  public int compareTo(ReadableDuration paramReadableDuration)
  {
    long l1 = getMillis();
    long l2 = paramReadableDuration.getMillis();
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    return 0;
  }
  
  public boolean isEqual(ReadableDuration paramReadableDuration)
  {
    if (paramReadableDuration == null) {
      paramReadableDuration = Duration.ZERO;
    }
    return compareTo(paramReadableDuration) == 0;
  }
  
  public boolean isLongerThan(ReadableDuration paramReadableDuration)
  {
    if (paramReadableDuration == null) {
      paramReadableDuration = Duration.ZERO;
    }
    return compareTo(paramReadableDuration) > 0;
  }
  
  public boolean isShorterThan(ReadableDuration paramReadableDuration)
  {
    if (paramReadableDuration == null) {
      paramReadableDuration = Duration.ZERO;
    }
    return compareTo(paramReadableDuration) < 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ReadableDuration)) {
      return false;
    }
    ReadableDuration localReadableDuration = (ReadableDuration)paramObject;
    return getMillis() == localReadableDuration.getMillis();
  }
  
  public int hashCode()
  {
    long l = getMillis();
    return (int)(l ^ l >>> 32);
  }
  
  @ToString
  public String toString()
  {
    long l = getMillis();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("PT");
    int i = l < 0L ? 1 : 0;
    FormatUtils.appendUnpaddedInteger(localStringBuffer, l);
    while (localStringBuffer.length() < (i != 0 ? 7 : 6)) {
      localStringBuffer.insert(i != 0 ? 3 : 2, "0");
    }
    if (l / 1000L * 1000L == l) {
      localStringBuffer.setLength(localStringBuffer.length() - 3);
    } else {
      localStringBuffer.insert(localStringBuffer.length() - 3, ".");
    }
    localStringBuffer.append('S');
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.AbstractDuration
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */