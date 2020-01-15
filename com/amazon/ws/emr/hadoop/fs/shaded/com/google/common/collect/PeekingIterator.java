package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract interface PeekingIterator<E>
  extends Iterator<E>
{
  public abstract E peek();
  
  public abstract E next();
  
  public abstract void remove();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.PeekingIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */