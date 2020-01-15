package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public enum JsonFactory$Feature
{
  INTERN_FIELD_NAMES(true),  CANONICALIZE_FIELD_NAMES(true),  FAIL_ON_SYMBOL_HASH_OVERFLOW(true),  USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);
  
  private final boolean _defaultState;
  
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
  
  private JsonFactory$Feature(boolean defaultState)
  {
    _defaultState = defaultState;
  }
  
  public boolean enabledByDefault()
  {
    return _defaultState;
  }
  
  public boolean enabledIn(int flags)
  {
    return (flags & getMask()) != 0;
  }
  
  public int getMask()
  {
    return 1 << ordinal();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory.Feature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */