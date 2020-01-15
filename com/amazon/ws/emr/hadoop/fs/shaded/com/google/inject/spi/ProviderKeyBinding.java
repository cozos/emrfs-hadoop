package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import javax.inject.Provider;

public abstract interface ProviderKeyBinding<T>
  extends Binding<T>
{
  public abstract Key<? extends Provider<? extends T>> getProviderKey();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderKeyBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */