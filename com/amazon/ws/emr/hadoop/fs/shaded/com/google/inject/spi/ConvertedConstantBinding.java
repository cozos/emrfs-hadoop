package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import java.util.Set;

public abstract interface ConvertedConstantBinding<T>
  extends Binding<T>, HasDependencies
{
  public abstract T getValue();
  
  public abstract TypeConverterBinding getTypeConverterBinding();
  
  public abstract Key<String> getSourceKey();
  
  public abstract Set<Dependency<?>> getDependencies();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ConvertedConstantBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */