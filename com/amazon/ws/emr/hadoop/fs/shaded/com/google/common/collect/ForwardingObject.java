package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@GwtCompatible
public abstract class ForwardingObject
{
  protected abstract Object delegate();
  
  public String toString()
  {
    return delegate().toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */