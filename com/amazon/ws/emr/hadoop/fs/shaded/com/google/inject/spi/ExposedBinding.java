package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;

public abstract interface ExposedBinding<T>
  extends Binding<T>, HasDependencies
{
  public abstract PrivateElements getPrivateElements();
  
  public abstract void applyTo(Binder paramBinder);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ExposedBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */