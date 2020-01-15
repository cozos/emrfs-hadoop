package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public enum JsonGenerator$Feature
{
  AUTO_CLOSE_TARGET(true),  AUTO_CLOSE_JSON_CONTENT(true),  FLUSH_PASSED_TO_STREAM(true),  QUOTE_FIELD_NAMES(true),  QUOTE_NON_NUMERIC_NUMBERS(true),  WRITE_NUMBERS_AS_STRINGS(false),  WRITE_BIGDECIMAL_AS_PLAIN(false),  ESCAPE_NON_ASCII(false),  STRICT_DUPLICATE_DETECTION(false),  IGNORE_UNKNOWN(false);
  
  private final boolean _defaultState;
  private final int _mask;
  
  public static int collectDefaults()
  {
    int flags = 0;
    for (Feature f : values()) {
      if (f.enabledByDefault()) {
        flags |= f.getMask();
      }
    }
    return flags;
  }
  
  private JsonGenerator$Feature(boolean defaultState)
  {
    _defaultState = defaultState;
    _mask = (1 << ordinal());
  }
  
  public boolean enabledByDefault()
  {
    return _defaultState;
  }
  
  public boolean enabledIn(int flags)
  {
    return (flags & _mask) != 0;
  }
  
  public int getMask()
  {
    return _mask;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */