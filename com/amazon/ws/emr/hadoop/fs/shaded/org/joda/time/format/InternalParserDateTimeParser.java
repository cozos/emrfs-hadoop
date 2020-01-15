package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

class InternalParserDateTimeParser
  implements DateTimeParser, InternalParser
{
  private final InternalParser underlying;
  
  static DateTimeParser of(InternalParser paramInternalParser)
  {
    if ((paramInternalParser instanceof DateTimeParserInternalParser)) {
      return ((DateTimeParserInternalParser)paramInternalParser).getUnderlying();
    }
    if ((paramInternalParser instanceof DateTimeParser)) {
      return (DateTimeParser)paramInternalParser;
    }
    if (paramInternalParser == null) {
      return null;
    }
    return new InternalParserDateTimeParser(paramInternalParser);
  }
  
  private InternalParserDateTimeParser(InternalParser paramInternalParser)
  {
    underlying = paramInternalParser;
  }
  
  public int estimateParsedLength()
  {
    return underlying.estimateParsedLength();
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    return underlying.parseInto(paramDateTimeParserBucket, paramCharSequence, paramInt);
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, String paramString, int paramInt)
  {
    return underlying.parseInto(paramDateTimeParserBucket, paramString, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof InternalParserDateTimeParser))
    {
      InternalParserDateTimeParser localInternalParserDateTimeParser = (InternalParserDateTimeParser)paramObject;
      return underlying.equals(underlying);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.InternalParserDateTimeParser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */