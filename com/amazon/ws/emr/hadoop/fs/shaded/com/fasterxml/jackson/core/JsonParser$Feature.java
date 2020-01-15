package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public enum JsonParser$Feature
{
  AUTO_CLOSE_SOURCE(true),  ALLOW_COMMENTS(false),  ALLOW_YAML_COMMENTS(false),  ALLOW_UNQUOTED_FIELD_NAMES(false),  ALLOW_SINGLE_QUOTES(false),  ALLOW_UNQUOTED_CONTROL_CHARS(false),  ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),  ALLOW_NUMERIC_LEADING_ZEROS(false),  ALLOW_NON_NUMERIC_NUMBERS(false),  STRICT_DUPLICATE_DETECTION(false),  IGNORE_UNDEFINED(false);
  
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
  
  private JsonParser$Feature(boolean defaultState)
  {
    _mask = (1 << ordinal());
    _defaultState = defaultState;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */