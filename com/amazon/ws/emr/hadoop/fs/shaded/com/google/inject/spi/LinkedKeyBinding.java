package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;

public abstract interface LinkedKeyBinding<T>
  extends Binding<T>
{
  public abstract Key<? extends T> getLinkedKey();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.LinkedKeyBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */