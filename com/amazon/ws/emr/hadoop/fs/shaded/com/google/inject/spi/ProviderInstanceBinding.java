package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import java.util.Set;

public abstract interface ProviderInstanceBinding<T>
  extends Binding<T>, HasDependencies
{
  public abstract Provider<? extends T> getProviderInstance();
  
  public abstract Set<InjectionPoint> getInjectionPoints();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderInstanceBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */