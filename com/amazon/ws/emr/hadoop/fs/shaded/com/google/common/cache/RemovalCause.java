package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
public enum RemovalCause
{
  EXPLICIT,  REPLACED,  COLLECTED,  EXPIRED,  SIZE;
  
  private RemovalCause() {}
  
  abstract boolean wasEvicted();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.RemovalCause
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */