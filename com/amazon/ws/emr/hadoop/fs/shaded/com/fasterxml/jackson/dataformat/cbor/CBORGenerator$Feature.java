package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatFeature;

public enum CBORGenerator$Feature
  implements FormatFeature
{
  WRITE_MINIMAL_INTS(true),  WRITE_TYPE_HEADER(false);
  
  protected final boolean _defaultState;
  protected final int _mask;
  
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
  
  private CBORGenerator$Feature(boolean defaultState)
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
    return (flags & getMask()) != 0;
  }
  
  public int getMask()
  {
    return _mask;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORGenerator.Feature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */