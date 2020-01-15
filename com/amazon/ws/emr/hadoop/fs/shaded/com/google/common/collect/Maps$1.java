package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

final class Maps$1
  extends UnmodifiableIterator<V>
{
  Maps$1(UnmodifiableIterator paramUnmodifiableIterator) {}
  
  public boolean hasNext()
  {
    return val$entryIterator.hasNext();
  }
  
  public V next()
  {
    return (V)((Map.Entry)val$entryIterator.next()).getValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */