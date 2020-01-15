package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public abstract interface FormatFeature
{
  public abstract boolean enabledByDefault();
  
  public abstract int getMask();
  
  public abstract boolean enabledIn(int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */