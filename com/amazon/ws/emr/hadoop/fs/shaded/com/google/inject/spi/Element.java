package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;

public abstract interface Element
{
  public abstract Object getSource();
  
  public abstract <T> T acceptVisitor(ElementVisitor<T> paramElementVisitor);
  
  public abstract void applyTo(Binder paramBinder);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */