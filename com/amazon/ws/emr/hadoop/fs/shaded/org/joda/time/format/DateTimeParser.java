package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

public abstract interface DateTimeParser
{
  public abstract int estimateParsedLength();
  
  public abstract int parseInto(DateTimeParserBucket paramDateTimeParserBucket, String paramString, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeParser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */