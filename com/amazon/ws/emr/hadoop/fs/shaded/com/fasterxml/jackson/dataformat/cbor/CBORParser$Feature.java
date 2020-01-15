package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatFeature;

public enum CBORParser$Feature
  implements FormatFeature
{
  final boolean _defaultState;
  final int _mask;
  
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
  
  private CBORParser$Feature(boolean defaultState)
  {
    _defaultState = defaultState;
    _mask = (1 << ordinal());
  }
  
  public boolean enabledByDefault()
  {
    return _defaultState;
  }
  
  public int getMask()
  {
    return _mask;
  }
  
  public boolean enabledIn(int flags)
  {
    return (flags & _mask) != 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORParser.Feature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */