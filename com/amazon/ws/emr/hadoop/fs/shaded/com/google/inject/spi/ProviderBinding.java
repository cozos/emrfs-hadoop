package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;

public abstract interface ProviderBinding<T extends Provider<?>>
  extends Binding<T>
{
  public abstract Key<?> getProvidedKey();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */