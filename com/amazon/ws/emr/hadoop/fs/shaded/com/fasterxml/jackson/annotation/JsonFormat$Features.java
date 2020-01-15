package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

public class JsonFormat$Features
{
  private final int enabled;
  private final int disabled;
  private static final Features EMPTY = new Features(0, 0);
  
  private JsonFormat$Features(int e, int d)
  {
    enabled = e;
    disabled = d;
  }
  
  public static Features empty()
  {
    return EMPTY;
  }
  
  public static Features construct(JsonFormat f)
  {
    return construct(f.with(), f.without());
  }
  
  public static Features construct(JsonFormat.Feature[] enabled, JsonFormat.Feature[] disabled)
  {
    int e = 0;
    for (JsonFormat.Feature f : enabled) {
      e |= 1 << f.ordinal();
    }
    int d = 0;
    for (JsonFormat.Feature f : disabled) {
      d |= 1 << f.ordinal();
    }
    return new Features(e, d);
  }
  
  public Features with(JsonFormat.Feature... features)
  {
    int e = enabled;
    for (JsonFormat.Feature f : features) {
      e |= 1 << f.ordinal();
    }
    return e == enabled ? this : new Features(e, disabled);
  }
  
  public Features without(JsonFormat.Feature... features)
  {
    int d = disabled;
    for (JsonFormat.Feature f : features) {
      d |= 1 << f.ordinal();
    }
    return d == disabled ? this : new Features(enabled, d);
  }
  
  public Boolean get(JsonFormat.Feature f)
  {
    int mask = 1 << f.ordinal();
    if ((disabled & mask) != 0) {
      return Boolean.FALSE;
    }
    if ((enabled & mask) != 0) {
      return Boolean.TRUE;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Features
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */