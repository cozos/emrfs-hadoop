package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg;

public abstract interface ConfigFeature
{
  public abstract boolean enabledByDefault();
  
  public abstract int getMask();
  
  public abstract boolean enabledIn(int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ConfigFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */