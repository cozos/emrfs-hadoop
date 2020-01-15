package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.io.Serializable;

@Beta
public abstract interface Funnel<T>
  extends Serializable
{
  public abstract void funnel(T paramT, PrimitiveSink paramPrimitiveSink);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Funnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */