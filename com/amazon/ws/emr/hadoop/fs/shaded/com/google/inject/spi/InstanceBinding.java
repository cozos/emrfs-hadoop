package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import java.util.Set;

public abstract interface InstanceBinding<T>
  extends Binding<T>, HasDependencies
{
  public abstract T getInstance();
  
  public abstract Set<InjectionPoint> getInjectionPoints();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InstanceBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */