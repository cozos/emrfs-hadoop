package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Set;

final class Maps$3
  extends ForwardingSet<E>
{
  Maps$3(Set paramSet) {}
  
  protected Set<E> delegate()
  {
    return val$set;
  }
  
  public boolean add(E element)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends E> es)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */