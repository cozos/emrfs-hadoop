package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import java.util.List;
import java.util.Set;

public abstract interface PrivateElements
  extends Element
{
  public abstract List<Element> getElements();
  
  public abstract Injector getInjector();
  
  public abstract Set<Key<?>> getExposedKeys();
  
  public abstract Object getExposedSource(Key<?> paramKey);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */