package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

abstract interface InternalParser
{
  public abstract int estimateParsedLength();
  
  public abstract int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.InternalParser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */