package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

class DateTimeParserInternalParser
  implements InternalParser
{
  private final DateTimeParser underlying;
  
  static InternalParser of(DateTimeParser paramDateTimeParser)
  {
    if ((paramDateTimeParser instanceof InternalParserDateTimeParser)) {
      return (InternalParser)paramDateTimeParser;
    }
    if (paramDateTimeParser == null) {
      return null;
    }
    return new DateTimeParserInternalParser(paramDateTimeParser);
  }
  
  private DateTimeParserInternalParser(DateTimeParser paramDateTimeParser)
  {
    underlying = paramDateTimeParser;
  }
  
  DateTimeParser getUnderlying()
  {
    return underlying;
  }
  
  public int estimateParsedLength()
  {
    return underlying.estimateParsedLength();
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    return underlying.parseInto(paramDateTimeParserBucket, paramCharSequence.toString(), paramInt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeParserInternalParser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */